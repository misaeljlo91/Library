package com.project.library.controllers;

import com.project.library.dtos.BookDTO;
import com.project.library.models.Book;
import com.project.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books") //CONSEGUIR LA LISTA DE LIBROS
    public List<BookDTO> getListBooks(){
        return bookRepository.findAll().stream().map(book -> new BookDTO(book)).collect(Collectors.toList());
    }

    @GetMapping("/book/{id}") //CONSEGUIR UN LIBRO POR SU ID
    public BookDTO getBook(@PathVariable Long id) {
        return bookRepository.findById(id).map(book -> new BookDTO(book)).orElse(null);
    }

    @PostMapping("/book") //AGREGAR UN LIBRO A LA LISTA EXISTENTE
    public ResponseEntity<Object> addBook(
            @RequestParam String title,
            @RequestParam String writer,
            @RequestParam double price,
            @RequestParam String date) {

        //CAPTURA DE ERRORES
        if(title.isEmpty() || writer.isEmpty() || String.valueOf(price).isEmpty() || date.isEmpty()){
            return new ResponseEntity<>("Hay campos vacíos, por favor completelos todos para continuar", HttpStatus.FORBIDDEN);
        }

        if(bookRepository.findByTitle(title) != null){
            return new ResponseEntity<>("Este libro ya está en su repositorio", HttpStatus.FORBIDDEN);
        }

        if(price == 0){
            return new ResponseEntity<>("Ingrese un monto mayor a cero", HttpStatus.FORBIDDEN);
        }

        if(price < 0){
            return new ResponseEntity<>("No puede ingresar un monto negativo", HttpStatus.FORBIDDEN);
        }

        bookRepository.save(new Book(title, writer, price, date)); //REGISTRO DE NUEVO LIBRO
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/book/title/{id}") //MODIFICAR UN LIBRO POR SU TÍTULO
    public ResponseEntity<Object> changeTitle(
            @RequestParam String title,
            @PathVariable Long id) {

        Book book = bookRepository.findById(id).orElse(null); //Buscamos un libro por su ID, si este no existe retorna un valor null

        //CAPTURA DE ERRORES
        if(title.isEmpty()){
            return new ResponseEntity<>("Campo vacío, por favor completelo para continuar", HttpStatus.FORBIDDEN);
        }

        if(bookRepository.findByTitle(title) != null){
            return new ResponseEntity<>("Título ya se encuentra registrado", HttpStatus.FORBIDDEN);
        }

        //MODIFICACIÓN DE TÍTULO
        book.setTitle(title);

        bookRepository.save(book); //ALMACENAMIENTO DE TÍTULO MODIFICADO
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/book/data/{id}") //MODIFICAR UN LIBRO DE LA LISTA EXISTENTE
    public ResponseEntity<Object> changeDataBook(
            @RequestParam String writer,
            @RequestParam double price,
            @RequestParam String date,
            @PathVariable Long id) {

        Book book = bookRepository.findById(id).orElse(null); //Buscamos un libro por su ID, si este no existe retorna un valor null

        //CAPTURA DE ERRORES
        if(writer.isEmpty() || String.valueOf(price).isEmpty() || date.isEmpty()){
            return new ResponseEntity<>("Los campos no pueden ir vacíos, por favor completelos todos", HttpStatus.FORBIDDEN);
        }

        if(price == 0){
            return new ResponseEntity<>("Ingrese un monto mayor a cero", HttpStatus.FORBIDDEN);
        }

        if(price < 0){
            return new ResponseEntity<>("No puede ingresar un monto negativo", HttpStatus.FORBIDDEN);
        }

        //MODIFICACIÓN DE DATOS CON LOS MÉTODOS MODIFICADORES
        book.setWriter(writer);
        book.setPrice(price);
        book.setReleaseDate(date);

        bookRepository.save(book); //ALMACENAMIENTO DE DATOS MODIFICADOS
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}") //ELIMINAR UN LIBRO DE LA LISTA EXISTENTE
    public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        bookRepository.deleteById(book.getId()); //SE ELIMINA UN LIBRO POR SU NÚMERO DE ID
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
