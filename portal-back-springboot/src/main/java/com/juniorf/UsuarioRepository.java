package com.juniorf;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface UsuarioRepository extends Repository<Usuario, Integer> {

    void delete(Usuario user);

    List<Usuario> findAll();

    Usuario findById(int id);

    Usuario save(Usuario user);

}
