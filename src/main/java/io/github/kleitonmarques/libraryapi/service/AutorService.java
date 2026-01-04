package io.github.kleitonmarques.libraryapi.service;

import io.github.kleitonmarques.libraryapi.model.Autor;
import io.github.kleitonmarques.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public Autor salvar(Autor autor) {
        return repository.save(autor);
    }
}
