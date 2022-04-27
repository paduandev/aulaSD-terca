package br.anhembi.projeto01.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.projeto01.model.User;
import br.anhembi.projeto01.repository.UserRepo;

@RestController // esta é uma classe de Controller REST
@CrossOrigin("*") // aceita requisições de qualquer origem (server)
@RequestMapping("/user") // toda requisição para este controlle será "../user"
public class UserController {

    @Autowired // implementa a inteface com os métodos e retorna um objeto
    private UserRepo repo;

    // método acionado por uma chamada GET
    @GetMapping
    public ArrayList<User> listUsers() {
        ArrayList<User> listUsers = (ArrayList<User>) repo.findAll();

        return listUsers;
    }

    // deve ser passado uma informação na URL, {id} indica variável com nome id
    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable long id) { // parâmetro deve ter o mesmo nome usado na URL 
                                                                  // ou seja, {id} no GetMapping
        // procura um usuário e se não encontrar retorna null
        User userFound = repo.findById(id).orElse(null);

        if (userFound != null) {
            return ResponseEntity.ok(userFound); // ok = status 200, com o user no corpo da resposta
        }
        return ResponseEntity.notFound().build(); // notFound = status 404
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user) { // os dados do User deve vir no corpo da requisição
        // Para inserir um novo User, não deve ser informado o ID, pois este sera gerado pelo BD
        // Se tiver o ID, retorna um erro de requisição inválida do cliente.
        if(user.getCode() > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        User newUser = repo.save(user); // o método é usado para inserir um novo User no BD. Não deve ter o ID informado

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser); // retorna o código http 201 e no corpo da msg o
                                                                        // usuário inserido no BD
    }

    @PutMapping // a chamada neste caso deve ser via método PUT
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        // antes de atualizar, verifica se o User existe no BD para evitar inserir um
        // novo User no BD
        User userFound = repo.findById(user.getCode()).orElse(null);

        if (userFound == null) {
            return ResponseEntity.notFound().build();
        }

        User newUser = repo.save(user); // o mesmo método para inserir um novo User, porém aqui deve ser informado o ID

        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}") // a chamada deve ser via DELETE informando o ID do User a ser removido
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        // verifica se o usuário existe para depois apagar
        User userFound = repo.findById(id).orElse(null);

        if (userFound == null) {
            return ResponseEntity.notFound().build();
        }

        repo.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/email") // acionado via GET também, mas acrescentamos /email após o /user
    public ResponseEntity<User> findUserUsingEmail(@RequestBody User user) {
        // O método findByEmail foi declarado na Interface e é implementado pelo Spring JPA
        User userFound = repo.findByEmail(user.getEmail());

        if (userFound == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userFound);
    }

}
