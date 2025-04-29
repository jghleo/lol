package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Método para listar todos los libros
    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    // Método para agregar un libro (se utiliza POST)
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    // Método para buscar un libro por ID
    @GetMapping("/{id}")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    // Método para actualizar un libro (se utiliza PUT)
    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        // El id es necesario para identificar el libro a actualizar
        return libroService.updateLibro(libro);
    }

    // Método para eliminar un libro (se utiliza DELETE)
    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }
}
