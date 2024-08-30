package Operaciones;

import Cliente.ClienteNuevo;
import Cliente.Cuentas;
import Cliente.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejecuciones {
    Scanner teclado = new Scanner(System.in);
    ArrayList<Cuentas> movimientos;
    ArrayList<Cliente> beneficiarios;
    int y;
    int z;

    public void transferencia(ClienteNuevo c1) {
        Cuentas c4 = new Cuentas();
        Cliente c5 = new Cliente();
        Movimientos mov = new Movimientos();
        teclado = new Scanner(System.in);
        System.out.println("Ingrese la transacción que desea hacer: \n1. Cuentas Propias \n2. Cuentas del mismo banco \3. Cuentas de terceros");
        switch (teclado.nextInt()) {
            case 1: {//Cuentas propias
                teclado = new Scanner(System.in);
                System.out.println("Elija la cuenta origen desde la que desea hacer la transferencia: ");
                for (int i = 0; i < c1.getCuentas().length; i++) {
                    System.out.println(i + 1 + ". " + c1.getCuentas()[i]);
                }
                switch (teclado.nextInt()) {
                    case 1: {
                        c4.setNumeroCuenta(c1.getCuentas()[0].getNumeroCuenta());
                        mov.cuentaOr = c4.getNumeroCuenta();
                        y = 0;
                        break;
                    }
                    case 2: {
                        c4.setNumeroCuenta(c1.getCuentas()[1].getNumeroCuenta());
                        mov.cuentaOr = c4.getNumeroCuenta();
                        y = 1;
                        break;
                    }
                    case 3: {
                        c4.setNumeroCuenta(c1.getCuentas()[2].getNumeroCuenta());
                        mov.cuentaOr = c4.getNumeroCuenta();
                        y = 2;
                        break;
                    }
                }

                teclado = new Scanner(System.in);
                System.out.println("Elija la cuenta destino para la que desea hacer la transferencia: ");
                for (int i = 0; i < c1.getCuentas().length; i++) {
                    System.out.println(i + 1 + ". " + c1.getCuentas()[i]);
                }
                switch (teclado.nextInt()) {
                    case 1: {
                        c4.setCuentaDestino(c1.getCuentas()[0].getNumeroCuenta());
                        mov.setCuestaDes(c4.getCuentaDestino());
                        z = 0;
                        break;
                    }
                    case 2: {
                        c4.setCuentaDestino(c1.getCuentas()[1].getNumeroCuenta());
                        mov.setCuestaDes(c4.getCuentaDestino());
                        z = 1;
                        break;
                    }
                    case 3: {
                        c4.setCuentaDestino(c1.getCuentas()[2].getNumeroCuenta());
                        mov.setCuestaDes(c4.getCuentaDestino());
                        z = 2;
                        break;
                    }
                }
                teclado = new Scanner(System.in);
                System.out.println("Ingrese el monto de la transferencia: ");
                double x = teclado.nextInt();
                mov.cantidad = x;
                c1.getCuentas()[z].setBalance(x + c1.getCuentas()[y].getBalance());
                c1.getCuentas()[y].setBalance(c1.getCuentas()[z].getBalance() - x);
                mov.time = LocalDateTime.now();
                c1.getMovimientos().add(mov);
                break;
            }
            case 2: {//Cuentas del mismo banco
                Cuentas c6 = new Cuentas();
                while (true) {
                    teclado = new Scanner(System.in);
                    System.out.println("Ingresa el número de cuenta: ");
                    int h = teclado.nextInt();
                    teclado = new Scanner(System.in);
                    System.out.println("Ingresa el número de carnet: ");
                    int c = teclado.nextInt();
                    for (int i = 0; i < c5.getClientes().size(); i++) {
                        for (int j = 0; j < c5.getClientes().get(i).getCuentas().length; j++) {
                            if (h == c5.getClientes().get(i).getCuentas()[j].getNumeroCuenta() && c == c5.getClientes().get(i).getCi()) {
                                c6.setNumeroCuenta(c5.getClientes().get(i).getCuentas()[j].getNumeroCuenta());
                                mov.setCuestaDes(c6.getCuentaDestino());
                                break;
                            } else {
                                System.out.println("Usuario no encontrado");
                                break;
                            }
                        }
                    }

                    teclado = new Scanner(System.in);
                    System.out.println("Elije la cuenta origen de la transferencia: ");
                    for (int i = 0; i < c1.getCuentas().length; i++) {
                        System.out.println(i + 1 + ". " + c1.getCuentas()[i]);
                    }
                    switch (teclado.nextInt()) {
                        case 1: {
                            c4.setNumeroCuenta(c1.getCuentas()[0].getNumeroCuenta());
                            mov.cuentaOr = c4.getNumeroCuenta();
                            y = 0;
                            break;
                        }
                        case 2: {
                            c4.setNumeroCuenta(c1.getCuentas()[1].getNumeroCuenta());
                            mov.cuentaOr = c4.getNumeroCuenta();
                            y = 1;
                            break;
                        }
                        case 3: {
                            c4.setNumeroCuenta(c1.getCuentas()[2].getNumeroCuenta());
                            mov.cuentaOr = c4.getNumeroCuenta();
                            y = 2;
                            break;
                        }
                    }

                    teclado = new Scanner(System.in);
                    System.out.println("Ingrese el monto de la transferencia: ");
                    int x = teclado.nextInt();
                    mov.cantidad = x;
                    c1.getCuentas()[y].setBalance(c1.getCuentas()[y].getBalance() - x);
                    c6.setBalance(x + c6.getBalance());
                    mov.time = LocalDateTime.now();
                    c1.getMovimientos().add(mov);
                    break;
                }
            }
            case 3: {//Cuentas de terceros fuera del banco
                teclado = new Scanner(System.in);
                System.out.println("Ingrese el nombre del banco de destino: ");
                c4.setBanco(teclado.next());
                teclado = new Scanner(System.in);
                System.out.println("Ingrese el número de cuenta:");
                c4.setCuentaDestino(teclado.nextInt());
                mov.setCuestaDes(c4.getCuentaDestino());
                System.out.println("Elije la cuenta origen de la transferencia: ");
                for (int i = 0; i < c1.getCuentas().length; i++) {
                    System.out.println(i + 1 + ". " + c1.getCuentas()[i]);
                }
                switch (teclado.nextInt()) {
                    case 1: {
                        c4.setNumeroCuenta(c1.getCuentas()[0].getNumeroCuenta());
                        mov.cuentaOr = c4.getNumeroCuenta();
                        y = 0;
                        break;
                    }
                    case 2: {
                        c4.setNumeroCuenta(c1.getCuentas()[1].getNumeroCuenta());
                        mov.cuentaOr = c4.getNumeroCuenta();
                        y = 1;
                        break;
                    }
                    case 3: {
                        c4.setNumeroCuenta(c1.getCuentas()[2].getNumeroCuenta());
                        mov.cuentaOr = c4.getNumeroCuenta();
                        y = 2;
                        break;
                    }
                }

                teclado = new Scanner(System.in);
                System.out.println("Ingrese el monto de la transferencia: ");
                int x = teclado.nextInt();
                mov.cantidad = x;
                c1.getCuentas()[y].setBalance(c1.getCuentas()[y].getBalance() - x);
                mov.time = LocalDateTime.now();
                c1.movimientos.add(mov);
            }
        }

    }
    public void crearBeneficiarios (){
        Cliente beneficiario = new Cliente();

        teclado = new Scanner(System.in);
        System.out.println("Ingrese el primer nombre del beneficiario");
        beneficiario.setNombre(teclado.next());

        teclado = new Scanner(System.in);
        System.out.println("Ingrese el carnet de identidad del beneficiario:");
        beneficiario.setCi(teclado.nextInt());

        teclado = new Scanner(System.in);
        System.out.println("Ingrese el banco del beneficiario:");
        beneficiario.getCuentas()[0].setBanco(teclado.next());

        teclado = new Scanner(System.in);
        System.out.println("Ingrese el número de cuenta del beneficiario:");
        beneficiario.getCuentas()[1].setNumeroCuenta(teclado.nextInt());

        teclado = new Scanner(System.in);
        System.out.println("Ingrese la divisa de la cuenta: ");
        if (teclado.nextInt() == 1) {beneficiario.getCuentas()[0].setTipoMoneda("Bolivianos");}
        if (teclado.nextInt() == 2) {beneficiario.getCuentas()[0].setTipoMoneda("Dólares");}

        beneficiarios.add(beneficiario);
    }
    public void extractoCuenta (ClienteNuevo cl1){
                System.out.println("Extracto de cuenta de " + cl1.getNombre());
                System.out.println("Saldo actual: " + cl1.cuentas[0].getBalance());
                System.out.println("Saldo actual 2: " + cl1.cuentas[1].getBalance());
                System.out.println("Saldo actual 3: " + cl1.cuentas[2].getBalance());
                System.out.println("Movimientos:");
                mostrarMovimientos(cl1);
        }


    private void mostrarMovimientos(ClienteNuevo cliente) {
        for (int i = 0; i < cliente.getMovimientos().size();i++) {
            ClienteNuevo cr = cliente;
            System.out.println(cr.getMovimientos().get(i));
        }
    }

    public void abonar (){

    }
    public void debitar (){

    }
}
