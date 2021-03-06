package com.romeurocha.springboot.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.romeurocha.springboot.domain.Addres;
import com.romeurocha.springboot.domain.Category;
import com.romeurocha.springboot.domain.City;
import com.romeurocha.springboot.domain.Client;
import com.romeurocha.springboot.domain.CredCard;
import com.romeurocha.springboot.domain.Order;
import com.romeurocha.springboot.domain.OrderItem;
import com.romeurocha.springboot.domain.Payment;
import com.romeurocha.springboot.domain.Product;
import com.romeurocha.springboot.domain.State;
import com.romeurocha.springboot.domain.enuns.StatusPayment;
import com.romeurocha.springboot.domain.enuns.TypeClient;
import com.romeurocha.springboot.repositories.AddresRepository;
import com.romeurocha.springboot.repositories.CategoryRepository;
import com.romeurocha.springboot.repositories.CityRepository;
import com.romeurocha.springboot.repositories.ClientRepository;
import com.romeurocha.springboot.repositories.OrderItemRepository;
import com.romeurocha.springboot.repositories.OrderRepository;
import com.romeurocha.springboot.repositories.PaymentRepository;
import com.romeurocha.springboot.repositories.ProductRepository;
import com.romeurocha.springboot.repositories.StateRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddresRepository addresRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().add(p2);
		
		p1.getCategories().add(cat1);
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().add(cat1);
		
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
			
		
		State sta = new State(null, "Alagoas");
		State sta2 = new State(null, "Bahia");
		
		City cit = new City(null, "Delmiro Gouveia", sta);
		City cit2 = new City(null, "Paulo Afonso", sta2);
		City cit3 = new City(null, "Maceió", sta);
		
		sta.getCities().addAll(Arrays.asList(cit,cit3));
		sta2.getCities().add(cit2);
		
		stateRepository.saveAll(Arrays.asList(sta,sta2));
		cityRepository.saveAll(Arrays.asList(cit,cit2,cit3));
		
		Client cli1 = new Client(null, "Romeu Rocha", "romeu@teste.com", "15665478", TypeClient.PERSONPHYSICAL);
		cli1.getPhones().addAll(Arrays.asList("36412036","981511017"));
		
		
		Addres addres = new Addres(null, "Rua Martins Cavalcantes", "284", null, "Pedra Velha","57480-000", cit, cli1);
		cli1.getAddres().add(addres);
		
		clientRepository.save(cli1);
		addresRepository.save(addres);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Order pedido = new Order(null, sdf.parse("04/09/2020 17:22"),  cli1, addres);
		Payment pagamento = new CredCard(null, StatusPayment.SETTLED, pedido, 3);
		
		pedido.setPayment(pagamento);
		cli1.getOrders().addAll(Arrays.asList(pedido));
		
		orderRepository.save(pedido);
		paymentRepository.save(pagamento);
		//clientRepository.save(cli1);//atualizando os pedidos desse cliente
		
		OrderItem itemPed = new OrderItem(pedido, p1, 0.0, 1, 2000.0);
		p1.getItems().addAll(Arrays.asList(itemPed));
		pedido.getItems().addAll(Arrays.asList(itemPed));
		orderItemRepository.save(itemPed);
	}

}
