package util;

import java.io.Serializable;

public class Requisicao implements Serializable {
    private double operando1, operando2;
    private char operador;

    public Requisicao(double operando1, double operando2, char operador) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
    }

    public char getOperador() {
        return operador;
    }

    public double getOperando1() {
        return operando1;
    }

    public double getOperando2() {
        return operando2;
    }
}