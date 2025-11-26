package io.github.kleitonmarques.libraryapi.service;

import io.github.kleitonmarques.libraryapi.model.Autor;
import io.github.kleitonmarques.libraryapi.model.GeneroLivro;
import io.github.kleitonmarques.libraryapi.model.Livro;
import io.github.kleitonmarques.libraryapi.repository.AutorRepository;
import io.github.kleitonmarques.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    // livro (titulo,..., nome_arquivo) -> id.png
    @Transactional
    public void salvarLivroComFoto(){
        // salva o livro
        // repository.save(livro);

        // pega o id do livro = livro.getId();
        // var id = livro.getId();

        // salvar foto do livro -> bucket na nuvem
        // bucketService.salvar(livro.getFoto(), id + ".png");

        // atualizar o nome do arquivo que foi salvo
        //livro.setNomeArquivoFoto(id + ".png");
    }

    @Transactional
    public void atualizacaoSemAtualizar() {
        var livro = livroRepository.findById(UUID.fromString("d778b7e0-9c1e-4bc2-867a-ba8b293daf0a")).orElse(null);
        livro.setDataPublicacao(LocalDate.of(2024, 6, 1));
    }

    @Transactional
    public void executar() {
        // salva o autor
        Autor autor = new Autor();
        autor.setNome("Teste Francisco");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1951, 1, 31));
        autorRepository.save(autor);

        // salva o livro
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Teste Livro Francisca");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));
        livro.setAutor(autor);
        livroRepository.save(livro);

        if (autor.getNome().equals("Teste Francisco")) {
            throw new RuntimeException("Rollback!");
        }
    }
}
