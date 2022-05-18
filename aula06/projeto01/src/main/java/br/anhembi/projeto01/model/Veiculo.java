package br.anhembi.projeto01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String modelo;

    @ManyToOne  // cada veículo pode ser de um único proprietário
    @JoinColumn(name = "code_user") // nome da coluna usada na tabela como chave extrangeira
    @JsonIgnoreProperties("veiculos") // para cada proprietário não traga novamente os veículos (erro de loop infinito)
    private User proprietario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public User getProprietario() {
        return proprietario;
    }

    public void setProprietario(User proprietario) {
        this.proprietario = proprietario;
    }

}
