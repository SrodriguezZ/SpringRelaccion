package com.user_food.service;

import com.user_food.dto.AutorLibroDto;
import com.user_food.entity.Autor;
import com.user_food.entity.Libro;
import com.user_food.entity.LibroAutor;
import com.user_food.exception.ResourceNotFoundException;
import com.user_food.repository.AutorLibroRepository;
import com.user_food.repository.IAutorRepository;
import com.user_food.repository.ILibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorLibroService {
    @Autowired
    private ILibroRepository _libroRepository;
    @Autowired
    private IAutorRepository _autorRepository;

    @Autowired
    private AutorLibroRepository _autorLibroRepository;
    @Transactional
    public void postAutoLibro(AutorLibroDto autorLibroDto){
        Libro libro = _libroRepository.findById(autorLibroDto.getIdLibro())
                .orElseThrow(()-> new ResourceNotFoundException("No  se encontro con el id :" + autorLibroDto.idLibro));

        Autor autor  = _autorRepository.findById(autorLibroDto.getIdAutor())
                .orElseThrow(()-> new ResourceNotFoundException("No  se encontro con el id :" + autorLibroDto.idAutor));

        LibroAutor libroAutor = new LibroAutor();
        libroAutor.setAutor(autor);
        libroAutor.setLibro(libro);
        libroAutor.setComentario(autorLibroDto.getComentario());

        //Guardar el libro
        libro.getLibroAutors().add(libroAutor);
        autor.getLibroAutors().add(libroAutor);

        _autorLibroRepository.save(libroAutor);

    }
}
