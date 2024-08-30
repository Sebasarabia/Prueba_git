package Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteNuevo {
    String nombre;
    String p;
    int numeroTelf;
    int ci;
    String direccionCorreo;
    String direccion;
    String user;
    int password;
    Scanner entrada = new Scanner(System.in);
    public Cuentas [] cuentas = new Cuentas[3];
    Operaciones.Movimientos muv;
    public ArrayList movimientos = new ArrayList();

    public ArrayList getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList movimientos) {
        this.movimientos = movimientos;
    }

    public Cuentas[] getCuentas() {
        return cuentas;
    }

    public String getUser() {return user;}

    public void setUser(String user) {this.user = user;}

    public int getPassword() {return password;}

    public void setPassword(int password) {this.password = password;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroTelf() {
        return numeroTelf;
    }

    public void setNumeroTelf(int numeroTelf) {
        this.numeroTelf = numeroTelf;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void crearNuevoCliente() {

        System.out.println("Ingrese el nombre del cliente: ");
        setNombre(entrada.nextLine());
        int tel=0;
        String tel2="";

        while (true) {
            tel2="";
            System.out.println("Ingrese el numero de teléfono: ");
            try {
                tel=Integer.parseInt(entrada.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese solo valores numéricos");
            }
            tel2=String.valueOf(tel);
            if (tel2.length() != 8) {
                try {
                    throw new Excepcion("Telefono Invalido, requiere 8 numeros");
                }catch(Excepcion e){
                    e.printStackTrace();
                    tel2=entrada.nextLine();
                }
            } else {
                break;
            }
        }
        setNumeroTelf(tel);

        while (true) {
            tel = 0;
            tel2 = "";
            System.out.println("Ingrese el numero de carnet de identidad: ");
            try {
                tel2=entrada.nextLine();
                tel=Integer.parseInt(tel2);
            } catch (Exception e) {
                System.out.println("Ingrese solo valores numéricos");
            }
            if (tel2.length() != 8) {
                try {
                    throw new Excepcion("Carnet Invalido, requiere 8 numeros");
                }catch(Excepcion e){
                    e.printStackTrace();
                    tel2=entrada.nextLine();
                }
            } else {
                break;
            }
        }
            setCi(tel);

            while (true) {

                System.out.println("Ingrese el direccion correo: ");
                tel2=entrada.nextLine();
                if (tel2.contains("@")) {
                    setDireccionCorreo(tel2);
                    break;
                } else {
                    try {
                        throw new Excepcion("Correo Invalido, requiere un @");
                    }catch(Excepcion e){
                        e.printStackTrace();
                        tel2=entrada.nextLine();
                    }
                }
            }

            System.out.println("Ingrese la direccion de su domicilio: ");
            setDireccion(entrada.nextLine());


            while (true) {
                tel2="";
                System.out.println("Ingrese el user (no más de 10 caracteres): ");
                tel2=entrada.nextLine();
                if (tel2.length() > 10) {
                    try {
                        throw new Excepcion("Usuario Invalido, Maximo 10 caracteres");
                    }catch(Excepcion e){
                        e.printStackTrace();
                        tel2=entrada.nextLine();
                    }
                } else {
                    setUser(tel2);
                    break;
                }
            }

            while (true) {
                entrada = new Scanner(System.in);
                tel=0;
                tel2="";
                System.out.println("Ingrese una contraseña de 4 dígitos numéricos: ");
                try {
                    tel2=entrada.nextLine();
                    tel=Integer.parseInt(tel2);
                } catch (Exception e) {
                    System.out.println("Ingrese solo valores numéricos");
                }
                if (tel2.length() != 4) {
                    try {
                        throw new Excepcion("Pin Invalido, requiere 4 numeros");
                    }catch(Excepcion e){
                        e.printStackTrace();
                        tel2=entrada.nextLine();
                    }
                } else {
                    break;
                }
            }
            setPassword(tel);
        }
    public void abrirCuenta() {
        Cuentas cuentas1 = new Cuentas();
        cuentas1.crearCuenta(this);

    }
    }
