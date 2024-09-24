package entregables.bancaElectronica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public abstract class Cuenta {

    private int numero;
    private LocalDate fechaApertura;
    private double saldo;
    private LocalDate fechaCancelacion;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = LocalDate.parse(fechaApertura,formatter);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = LocalDate.parse(fechaCancelacion,formatter);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numero=" + numero +
                ", fechaApertura='" + fechaApertura + '\'' +
                ", saldo=" + saldo +
                ", fechaCancelacion='" + fechaCancelacion + '\'' +
                '}';
    }

    public static Comparator<Cuenta> ordenarPorSaldo = new Comparator<Cuenta>() {
        @Override
        public int compare(Cuenta c1, Cuenta c2) {
            return Double.compare(c1.getSaldo(), c2.getSaldo());
        }
    };
}
