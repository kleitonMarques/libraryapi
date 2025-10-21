package io.github.kleitonmarques.libraryapi.repository;

import io.github.kleitonmarques.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
