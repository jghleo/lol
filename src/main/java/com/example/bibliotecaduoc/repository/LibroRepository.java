package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    //Arreglo que guarda todos  los libros
    private List<Libro> listalibros = new ArrayList<>();

    public LibroRepository() {
        listalibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", "2018", "George R. R. Martin"));
        listalibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", "2014", "Sergio Gomez"));
        listalibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", "2020", "Anghel Leonard"));
        listalibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", "2024", "J. K. Rowling"));
        listalibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", "1999", "J. K. Rowling"));
        listalibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", "2000", "J. K. Rowling"));
        listalibros.add(new Libro(7, "9780321127426", "Effective Java", "AddisonWesley", "2008", "Joshua Bloch"));
        listalibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", "2017", "Robert C. Martin"));
        listalibros.add(new Libro(9, "9780201633610", "Design Patterns", "AddisonWesley", "1994", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listalibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall", "2008", "Robert C. Martin"));

    }




    //Metodo que retorna todos los libros
    public  List<Libro> obtenerLibros(){
        return listalibros;
    }

    // Buscar un libro por su id
    public Libro buscarLibroId(int id){
        for (Libro libro : listalibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    // Buscar un libro por su isbn
    public Libro BuscarLibroIsbn(String isbn){
        for (Libro libro : listalibros) {
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }
    public Libro guardar(Libro lib){
        listalibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;
        for (int i = 0; i < listalibros.size(); i++) {
            if(listalibros.get(i).getId() == lib.getId()){
                id = listalibros.get(i).getId();
                idPosicion = i;
            }
        }
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setIsbn(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listalibros.set(idPosicion, libro1);
        return libro1;
    }

    public  void eliminar(int id){
        //alternativa 1
        Libro libro = buscarLibroId(id);
        if(libro != null){
            listalibros.remove(libro);
        }
        //alternativa 2
        int idPosicion = 0;
        for (int i = 0; i < listalibros.size(); i++) {
            if(listalibros.get(i).getId() == id){
                idPosicion = i;
                break;
            }
        }
        if(idPosicion == 0){
            listalibros.remove(idPosicion);
        }
        // otra alternativa
        listalibros.removeIf(x -> x.getId() == id);
    }

    public int totalLibros(){
        return listalibros.size();
    }
}
