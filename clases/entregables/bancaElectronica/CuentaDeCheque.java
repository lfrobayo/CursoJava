package entregables.bancaElectronica;

public class CuentaDeCheque extends Cuenta{

    private double costoManejoMensual;

    public CuentaDeCheque(int numero, double saldo, double costoManejoMensual) {
        super(numero, saldo);
        this.costoManejoMensual=costoManejoMensual;
    }

    public double getCostoManejoMensual() {
        return costoManejoMensual;
    }

    @Override
    public String toString() {
        return String.format(
                "Cuenta de cheque: %d\nSaldo: %.2f\nCosto de manejo mensual: %.2f%%\n",
                getNumero(), getSaldo(), getCostoManejoMensual()
        );
    }
}
