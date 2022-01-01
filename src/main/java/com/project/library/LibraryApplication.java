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
			Book book6 = new Book("Orgullo y prejuicio", "Jane Austen", 500, "1863-01-28");
			Book book7 = new Book("El hombre invisible", "Ralph Ellison", 1200, "1952-04-14");
			Book book8 = new Book("Cien años de soledad", "Gabriel García Márquez", 950, "1967-05-01");
			Book book9 = new Book("Doña Bárbara", "Rómulo Gallegos", 800, "1929-02-15");
			Book book10 = new Book("Harry Potter y la piedra filosofal", "J. K. Rowling", 1850, "1997-06-26");
			Book book11 = new Book("El peregrino de Compostela", "Paulo Coelho", 750, "1987-04-01");
			Book book12 = new Book("Los ojos del perro siberiano", "Antonio Santa Ana", 450, "1998-03-01");
			Book book13 = new Book("Padre rico, padre pobre", "Robert Kiyosaki", 1550, "1997-01-01");
			Book book14 = new Book("El hijo de Billy", "Patricia Nell Warren", 500, "2006-03-30");
			Book book15 = new Book("Cementerio de animales", "Stephen King", 1500, "1983-11-14");
			Book book16 = new Book("Las valkirias", "Paulo Coelho", 1000, "1992-01-01");
			Book book17 = new Book("El señor de los anillos", "J. R. R. Tolkien", 1600, "1954-07-29");
			Book book18 = new Book("50 sombras de Grey", "E. L. James", 900, "2011-05-11");
			Book book19 = new Book("El secreto", "Rhonda Byrne", 1200, "2006-11-01");
			Book book20 = new Book("La tía Tula", "Miguel de Unamuno", 300, "1926-01-01");
			Book book21 = new Book("La metamorfosis", "Franz Kafka", 700, "1915-10-01");
			Book book22 = new Book("Viaje al centro de la tierra", "Julio Verne", 1500, "1864-11-25");
			Book book23 = new Book("Harry Potter y el cáliz de fuego", "J. K. Rowling", 2000, "2000-07-08");
			Book book24 = new Book("Ángeles y demonios", "Dan Brown", 1400, "2000-01-01");

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			bookRepository.save(book5);
			bookRepository.save(book6);
			bookRepository.save(book7);
			bookRepository.save(book8);
			bookRepository.save(book9);
			bookRepository.save(book10);
			bookRepository.save(book11);
			bookRepository.save(book12);
			bookRepository.save(book13);
			bookRepository.save(book14);
			bookRepository.save(book15);
			bookRepository.save(book16);
			bookRepository.save(book17);
			bookRepository.save(book18);
			bookRepository.save(book19);
			bookRepository.save(book20);
			bookRepository.save(book21);
			bookRepository.save(book22);
			bookRepository.save(book23);
			bookRepository.save(book24);
		};
	}
}
