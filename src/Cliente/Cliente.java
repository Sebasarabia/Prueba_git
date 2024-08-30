package Cliente;

import java.util.ArrayList;

public class Cliente extends ClienteNuevo {

    public ArrayList<ClienteNuevo> clientes = new ArrayList<ClienteNuevo>();
    int cantCliente;

    public void abrirCuenta(ClienteNuevo cliente) {
        Cuentas cuentas1 = new Cuentas();
        cuentas1.crearCuenta(cliente);
        clientes.add(cliente);
    }

    public ArrayList<ClienteNuevo> getClientes() {
        return clientes;
    }
}

