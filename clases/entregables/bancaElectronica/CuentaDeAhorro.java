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
        return "CuentaDeAhorro{" +
                "tasaInteresMenual=" + tasaInteresMenual +
                '}';
    }
}
