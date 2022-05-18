package br.anhembi.projeto01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.projeto01.model.Veiculo;

public interface VeiculoRepo extends CrudRepository<Veiculo, Long>{
    
}
