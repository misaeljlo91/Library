package com.project.library;

import com.project.library.models.Book;
import com.project.library.models.Client;
import com.project.library.repositories.BookRepository;
import com.project.library.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, BookRepository bookRepository) {
		return (args) -> {

			Client client1 = new Client("admin", passwordEncoder.encode("admin"), "ADMIN");

			clientRepository.save(client1);

			Book book1 = new Book("El niño volador", "Amy Potter", 1350, "2013-12-15");
			Book book2 = new Book("Drácula", "Bram Stoker", 600, "1897-05-26");
			Book book3 = new Book("La sangre manda", "Stephen King", 2500, "2020-04-21");
			Book book4 = new Book("365 Citas para Vivir su vida", "I. C. Robledo", 2400, "2020-05-20");
			Book book5 = new Book("Frankenstein", "Mary Shelley", 650, "1818-01-01");

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			bookRepository.save(book5);
		};
	}
}
