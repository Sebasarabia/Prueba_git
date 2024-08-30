import Cliente.Cliente;
import Cliente.ClienteNuevo;
import Operaciones.Ejecuciones;
import Operaciones.Pagar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = new Cliente();
        ClienteNuevo clienteNuevo = new ClienteNuevo();
        Ejecuciones ejecuciones = new Ejecuciones();
        Pagar pagar = new Pagar();

        System.out.println("Hola! ¿Eres cliente de Bancorriendo? (si/no)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Ingresa tu nombre de usuario:");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu pin:");
            int pin = scanner.nextInt();

            if (usuario.equals(clienteNuevo.getUser()) && pin == clienteNuevo.getPassword()) {
                System.out.println("Bienvenido " + clienteNuevo.getNombre() + "!");

                System.out.println("1. Transferir Dinero");
                System.out.println("2. Pagar Servicio");
                System.out.println("3. Mostrar Extracto");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        ejecuciones.transferencia(cliente);
                        break;
                    case 2:
                        pagar.pagarServicios(cliente);
                        break;
                    case 3:
                        ejecuciones.extractoCuenta(cliente);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Usuario o pin incorrecto.");
            }
        } else {
            System.out.println("¿Quieres crear una nueva cuenta? (si/no)");
            String crear = scanner.nextLine();

            if (crear.equalsIgnoreCase("si")) {
                clienteNuevo.crearNuevoCliente();
                clienteNuevo.abrirCuenta();
                System.out.println("Bienvenido " + clienteNuevo.getNombre() + "!");

                System.out.println("1. Transferir Dinero");
                System.out.println("2. Pagar Servicio");
                System.out.println("3. Mostrar Extracto");
                System.out.println("4. Añadir nueva cuenta");
                System.out.println("0. Salir");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        ejecuciones.transferencia(clienteNuevo);
                        break;
                    case 2:
                        pagar.pagarServicios(clienteNuevo);
                        break;
                    case 3:
                        ejecuciones.extractoCuenta(clienteNuevo);
                        break;
                    case 4:
                        clienteNuevo.abrirCuenta();
                    case 0:
                        System.out.println("Hasta Luego"+clienteNuevo.getNombre());
                    default:
                        System.out.println("Opción no válida.");
            }
        }
    }
}
}