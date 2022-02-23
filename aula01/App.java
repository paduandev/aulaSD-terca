import base.Cliente;
import base.Pessoa;
import data.GerenciaCliente;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
       GerenciaCliente clientes = new GerenciaCliente();

       clientes.cadastrar("Carlos", 23, 1000);

       System.out.println(clientes.consultarCliente("Carlos"));
       System.out.println(clientes.consultarCliente("Amanda"));

       
    }
}