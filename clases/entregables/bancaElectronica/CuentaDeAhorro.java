package entregables.bancaElectronica;

public class CuentaDeAhorro extends Cuenta{

    private double tasaInteresMenual;

    public CuentaDeAhorro(int numero, double saldo, double tasaInteresMenual) {
        super(numero, saldo);
        this.tasaInteresMenual=tasaInteresMenual;
    }

    public double getTasaInteresMenual() {
        return tasaInteresMenual;
    }

    public void setTasaInteresMenual(double tasaInteresMenual) {
        this.tasaInteresMenual = tasaInteresMenual;
    }

    public double calcularIntereses(){
        double interes= getSaldo()*(getTasaInteresMenual()/100);
        return interes;
    }

    @Override
    public String toString() {
        return String.format(
                "Cuenta de Ahorro: %d\nSaldo: %.2f\nTasa de Interés Mensual: %.2f%%\n",
                getNumero(), getSaldo(), getTasaInteresMenual()
        );
    }
}
