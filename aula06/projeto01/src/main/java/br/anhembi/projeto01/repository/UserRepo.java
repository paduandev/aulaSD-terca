package br.anhembi.projeto01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.projeto01.model.User;

// CRUD = Create, Read, Update, Delete
public interface UserRepo extends CrudRepository<User, Long> {
    
}
