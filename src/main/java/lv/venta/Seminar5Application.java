package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Seminar5Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar5Application.class, args);
	}

	
	public CommandLineRunner testModel(IProductPero prodRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product p1 = new Product("Banana", 1.99f, "Eco, yellow", 5); 
				
			}
		};
	}
}
