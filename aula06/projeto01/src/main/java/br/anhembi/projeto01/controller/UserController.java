package br.anhembi.projeto01.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.projeto01.model.User;
import br.anhembi.projeto01.repository.UserRepo;

@RestController  // esta é uma classe de Controller REST
@CrossOrigin("*")  // aceita requisições de qualquer origem (server)
@RequestMapping("/user")  // toda requisição para este controlle será "../user"
public class UserController {
    
    @Autowired // implementa a inteface com os métodos e retorna um objeto
    private UserRepo repo;

    @GetMapping
    public ArrayList<User> listUsers() {
        ArrayList<User> listUsers = (ArrayList<User>) repo.findAll();

        return listUsers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable long id) {
        // procura um usuário e se não encontrar retorna null
        User userFound = repo.findById(id).orElse(null);

        if(userFound != null) {
            return ResponseEntity.ok(userFound); // ok = status 200
        }
        return ResponseEntity.notFound().build(); // notFound = status 404
    }
    
}
