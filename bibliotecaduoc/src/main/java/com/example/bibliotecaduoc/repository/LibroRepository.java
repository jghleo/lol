package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    //Arreglo que guarda todos  los libros
    private List<Libro> listalibros = new ArrayList<>();

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

}
