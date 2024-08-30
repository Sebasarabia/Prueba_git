package Cliente;
public class Banco {
    private Cliente cliente[] = new Cliente[10];
    private int numClientes;

    public Banco() {
        numClientes = 0;
    }

    public Cliente[] getCliente() {
        return cliente;
    }

    public void setCliente(Cliente[] cliente) {
        this.cliente = cliente;
    }
}
