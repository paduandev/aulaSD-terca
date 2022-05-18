package br.anhembi.projeto01.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.projeto01.model.Veiculo;
import br.anhembi.projeto01.repository.VeiculoRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/veiculo")
public class VeiculoController {
    
    @Autowired
    private VeiculoRepo repo;

    @PostMapping
    public ResponseEntity<Veiculo> insert(@RequestBody Veiculo veiculo) {
        Veiculo newVeiculo =  repo.save(veiculo);
        return ResponseEntity.ok(newVeiculo);
    }

    @GetMapping
    public ArrayList<Veiculo> listUsers() {
        ArrayList<Veiculo> listUsers = (ArrayList<Veiculo>) repo.findAll();

        return listUsers;
    }
    
}
