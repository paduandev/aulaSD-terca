package util;

import java.io.Serializable;

public class Resposta implements Serializable {
    public final int OK = 0; 
    public final int OPERADOR_INVALIDO = 1; 
    public final int DIVISAO_POR_ZERO = 2; 
    private int status;
    private double valor;
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }



}
