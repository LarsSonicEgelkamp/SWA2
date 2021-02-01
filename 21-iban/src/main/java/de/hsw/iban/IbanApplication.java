package de.hsw.iban;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import de.hsw.iban.services.IbanService;

@SpringBootApplication
public class IbanApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbanApplication.class, args);
	}

	@Component
	public final class IbanRunner implements CommandLineRunner {
		private IbanService service;

		@Autowired
		public IbanRunner(IbanService service) {
			this.service = service;
		}

		@Override
		public void run(String... args) throws Exception {
			service.createIban("DE", "1", "11111111");
			service.createIban("DE", "01", "22222222");
			service.createIban("DE", "101", "33333333");
			service.createIban("DE", "0101", "44444444");
			service.createIban("DE", "10101", "55555555");
			service.createIban("DE", "010101", "66666666");
			service.createIban("DE", "1010101", "77777777");
			service.createIban("DE", "01010101", "88888888");
			service.createIban("DE", "101010101", "88888888");
			service.createIban("DE", "0101010101", "88888888");
			service.createIban("DE", "1010101010", "88888888");

			System.out.println(service.getAllResponses());
			System.out.println(service.getAllValidIbans());
		}

	}
}
