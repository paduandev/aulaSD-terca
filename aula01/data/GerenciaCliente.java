package data;

import java.util.ArrayList;

import base.Cliente;

public class GerenciaCliente {
    private ArrayList<Cliente> listaClientes;

    public GerenciaCliente() {
        listaClientes = new ArrayList<>();
    }

    public void cadastrar(String nome, int idade, float saldo) {
        Cliente cliente = new Cliente(nome, idade, saldo);
        listaClientes.add(cliente);
    }

    public String consultarCliente(String nome) {
        for (Cliente cliente : listaClientes) {
            if(cliente.getNome().equals(nome)){
                return cliente.toString();
            }
        }
        return "Não encontrado";
    }
    
}
