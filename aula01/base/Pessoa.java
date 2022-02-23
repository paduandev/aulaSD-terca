package base;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa() {
        nome = "não cadastrado";
        idade = 0;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade  = idade;
    }

    @Override
    public String toString() {
        return nome + " - " + idade;
    }

}
