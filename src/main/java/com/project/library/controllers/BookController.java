package com.project.library.controllers;

import com.project.library.dtos.BookDTO;
import com.project.library.dtos.BookDataDTO;
import com.project.library.models.Book;
import com.project.library.repositories.BookRepository;
import com.project.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    /*@GetMapping("/book")
    public String getAll(@RequestParam Map<String, Object> params, Model model){
        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;;

        PageRequest pageRequest = PageRequest.of(page, 10); //Con PageRequest vamos a buscar la página y cuantos registro quiero mostrar por página
        Page<Book> bookPage = bookService.getAll(pageRequest);

        int totalPage = bookPage.getTotalPages(); //Indica el total de páginas en la base de datos
        if(totalPage > 0){
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        model.addAttribute("list", bookPage.getContent());
        return "library/library.main/static/web/manager.html";
    }*/

    @GetMapping("/book") //CONSEGUIR LA LISTA DE LIBROS
    public List<BookDTO> getListBooks(){
        return bookRepository.findAll().stream().map(book -> new BookDTO(book)).collect(Collectors.toList());
    }

    @GetMapping("/book/{id}") //CONSEGUIR UN LIBRO POR SU ID
    public BookDTO getBook(@PathVariable Long id) {
        return bookRepository.findById(id).map(book -> new BookDTO(book)).orElse(null);
    }

    @PostMapping("/book") //AGREGAR UN LIBRO A LA LISTA EXISTENTE
    public ResponseEntity<Object> addBook(
            @RequestBody BookDataDTO bookData) {

        //CAPTURA DE ERRORES
        if(bookData.getTitle().isEmpty() || bookData.getWriter().isEmpty() || String.valueOf(bookData.getPrice()).isEmpty() || bookData.getDate().isEmpty()){
            return new ResponseEntity<>("Hay campos vacíos, por favor completelos todos para continuar", HttpStatus.FORBIDDEN);
        }

        if(bookRepository.findByTitle(bookData.getTitle()) != null){
            return new ResponseEntity<>("Este libro ya está en su repositorio", HttpStatus.FORBIDDEN);
        }

        if(bookData.getPrice() == 0){
            return new ResponseEntity<>("Ingrese un monto mayor a cero", HttpStatus.FORBIDDEN);
        }

        if(bookData.getPrice() < 0){
            return new ResponseEntity<>("No puede ingresar un monto negativo", HttpStatus.FORBIDDEN);
        }

        bookRepository.save(new Book(bookData.getTitle(), bookData.getWriter(), bookData.getPrice(), bookData.getDate())); //REGISTRO DE NUEVO LIBRO
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/book/{id}") //MODIFICAR UN LIBRO DE LA LISTA EXISTENTE
    public ResponseEntity<Object> changeDataBook(
            @RequestBody BookDataDTO bookData,
            @PathVariable Long id) {

        Book book = bookRepository.findById(id).orElse(null); //Buscamos un libro por su ID, si este no existe retorna un valor null

        //CAPTURA DE ERRORES
        if(bookData.getTitle().isEmpty() || bookData.getWriter().isEmpty() || String.valueOf(bookData.getPrice()).isEmpty() || bookData.getTitle().isEmpty()){
            return new ResponseEntity<>("Los campos no pueden ir vacíos, por favor completelos todos", HttpStatus.FORBIDDEN);
        }

        if(bookData.getPrice() == 0){
            return new ResponseEntity<>("Ingrese un monto mayor a cero", HttpStatus.FORBIDDEN);
        }

        if(bookData.getPrice() < 0){
            return new ResponseEntity<>("No puede ingresar un monto negativo", HttpStatus.FORBIDDEN);
        }

        //MODIFICACIÓN DE DATOS CON LOS MÉTODOS MODIFICADORES
        book.setTitle(bookData.getTitle());
        book.setWriter(bookData.getWriter());
        book.setPrice(bookData.getPrice());
        book.setReleaseDate(bookData.getDate());

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
