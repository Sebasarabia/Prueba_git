package Cliente;

import java.util.Random;
import java.util.Scanner;

public class Cuentas {
    String tipoCuenta;
    String banco;
    String tipoMoneda;
    double balance;
    int numeroCuenta;
    int cuentaDestino;

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void crearCuenta (ClienteNuevo c1){
        Cuentas c2 = new Cuentas();
        Random a = new Random();
        c2.setNumeroCuenta(a.nextInt(200000));
        c2.setBanco("Bancorriendo");
        c2.setBalance(0);
        int tel=0;
        String tel2="";
        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.println("Elija un tipo de cuenta: \n1. Ahorro\n2. Credito");
            tel2=sc.nextLine();
            try {
                if (Integer.parseInt(tel2)>2 || Integer.parseInt(tel2)<1) tel=0/0;
                tel=Integer.parseInt(tel2);
                break;
            } catch (Exception e) {
                try {
                    throw new Excepcion("Opcion Invalida, Seleccione 1 o 2");
                }catch(Excepcion z){
                    z.printStackTrace();
                    tel2=sc.nextLine();
                }
            }

        }
        if (tel == 1) {c2.setTipoCuenta("Ahorro");}
        if (tel == 2) {c2.setTipoCuenta("Credito");}



        while(true) {
            System.out.println("Elija una divisa: \n1. Bolivianos\n2. Dólares");
            tel2=sc.nextLine();
            try {
                if (Integer.parseInt(tel2)>2 || Integer.parseInt(tel2)<1) tel=0/0;
                tel=Integer.parseInt(tel2);
                break;
            } catch (Exception e) {
                try {
                    throw new Excepcion("Opcion Invalida, Seleccione 1 o 2");
                }catch(Excepcion z){
                    z.printStackTrace();
                    tel2=sc.nextLine();
                }
            }

        }
        if (tel == 1) {c2.setTipoMoneda("Bolivianos");}
        if (tel == 2) {c2.setTipoMoneda("Dólares");}

        for (int i = 0; i<c1.getCuentas().length; i++){
            if (null == c1.cuentas[i]) {
                c1.cuentas[i] = c2;
            }
        }
    }
}
