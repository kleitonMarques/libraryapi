package io.github.kleitonmarques.libraryapi.repository;

import io.github.kleitonmarques.libraryapi.model.Autor;
import io.github.kleitonmarques.libraryapi.model.GeneroLivro;
import io.github.kleitonmarques.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

   @Autowired
   LivroRepository repository;

   @Autowired
   AutorRepository autorRepository;

   @Test
    void salvarTest() {
       Livro livro = new Livro();
       livro.setIsbn("90887-84874");
       livro.setPreco(BigDecimal.valueOf(100));
       livro.setGenero(GeneroLivro.FICCAO);
       livro.setTitulo("UFO");
       livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

       Autor autor = autorRepository.findById(UUID.fromString("0525813a-73ec-45bb-82e9-ab5780c81542")).orElse(null);
       livro.setAutor(autor);
       repository.save(livro);
   }

}