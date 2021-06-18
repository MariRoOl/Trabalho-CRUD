package com.juniorf;

import java.util.List;


public interface UsuarioService {
	Usuario create(Usuario user);

	Usuario delete(int id);

    List<Usuario> findAll();

    Usuario findById(int id);

    Usuario update(Usuario user);
}
