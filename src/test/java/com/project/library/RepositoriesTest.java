package com.project.library;

import com.project.library.models.Book;
import com.project.library.models.Client;
import com.project.library.repositories.BookRepository;
import com.project.library.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest //Indica a Spring que se debe escanear para buscar clases @Entity y configurar los repositorios JPA
@AutoConfigureTestDatabase(replace = NONE)
public class RepositoriesTest {

//TEST DE INTEGRACIÓN. PRUEBA LA COMUNICACIÓN ENTRE LA APLICACIÓN Y LA BASE DE DATOS.

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BookRepository bookRepository;

    @Test //Prueba de integración - Busca que el repositorio no esté vacío
    public void existBooks(){
        List<Book> books = bookRepository.findAll();
        assertThat(books, is(not(empty())));
    }

    @Test //Prueba de integración - Busca que exista un libro determinado
    public void existNameBook(){
        List<Book> books = bookRepository.findAll();
        assertThat(books, hasItem(hasProperty("title", is("Drácula")))); //Cambiar el value para el test
    }

    @Test //Busca que el repositorio de clientes no esté vacío
    public void exitsClients(){
        List<Client> clients = clientRepository.findAll();
        assertThat(clients, is(not(empty())));
    }
}
