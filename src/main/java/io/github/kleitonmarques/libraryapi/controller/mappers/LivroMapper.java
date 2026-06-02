package io.github.kleitonmarques.libraryapi.controller.mappers;

import io.github.kleitonmarques.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.kleitonmarques.libraryapi.model.Livro;
import io.github.kleitonmarques.libraryapi.repository.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LivroMapper {

    @Autowired
    AutorRepository autorRepository;

    @Mapping(target = "autor", expression = "java( autorRepository.findById(dto.idAutor()).orElse(null) )")
    public abstract Livro toEntity(CadastroLivroDTO dto);
}
