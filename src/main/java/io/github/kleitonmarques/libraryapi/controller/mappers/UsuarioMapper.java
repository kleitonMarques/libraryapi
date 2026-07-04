package io.github.kleitonmarques.libraryapi.controller.mappers;

import io.github.kleitonmarques.libraryapi.controller.dto.UsuarioDTO;
import io.github.kleitonmarques.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
