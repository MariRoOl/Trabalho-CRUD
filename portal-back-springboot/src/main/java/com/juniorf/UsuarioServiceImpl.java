package com.juniorf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario create(Usuario user) {
        return repository.save(user);
    }

    @Override
    public Usuario delete(int id) {
    	Usuario user = findById(id);
        if(user != null){
            repository.delete(user);
        }
        return user;
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Usuario update(Usuario user) {
        return repository.save(user);
    }
}
