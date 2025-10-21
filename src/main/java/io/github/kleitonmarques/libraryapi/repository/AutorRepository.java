package io.github.kleitonmarques.libraryapi.repository;

import io.github.kleitonmarques.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
