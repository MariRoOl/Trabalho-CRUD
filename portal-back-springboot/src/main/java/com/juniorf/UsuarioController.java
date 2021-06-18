package com.juniorf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"/api"})
public class UsuarioController {
	@Autowired
    private UsuarioService userService;

    @PostMapping
    public Usuario create(@RequestBody Usuario user){
        return userService.create(user);
    }

    @GetMapping(path = {"/find/{id}"})
    public Usuario findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PutMapping(path = {"/edit/{id}"})
    public Usuario update(@PathVariable("id") int id, @RequestBody Usuario usuario){
    	 List<Usuario> users = userService.findAll();
    	 Usuario currentUser = new Usuario();
    	 for(Usuario u: users) {
    		 if(u.getId() == id) {
    			 currentUser.setId(id);
    			 currentUser.setEmail(usuario.getEmail());
    			 currentUser.setFirstName(usuario.getFirstName());
    			 currentUser.setLastName(usuario.getLastName());
    		 }
    	 }
    	 System.out.println(currentUser.toString());
        return userService.update(currentUser);
    }

    @DeleteMapping(path ={"/{id}"})
    public Usuario delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<Usuario> findAll(){
        return userService.findAll();
    }
}
