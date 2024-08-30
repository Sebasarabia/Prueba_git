package Operaciones;

import java.time.LocalDateTime;

public class Movimientos {

    LocalDateTime time;
    int cuentaOr;
    int cuestaDes;
    double cantidad;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCuentaOr() {
        return cuentaOr;
    }

    public void setCuentaOr(int cuentaOr) {
        this.cuentaOr = cuentaOr;
    }

    public int getCuestaDes() {
        return cuestaDes;
    }

    public void setCuestaDes(int cuestaDes) {
        this.cuestaDes = cuestaDes;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
