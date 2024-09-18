package entregables.bancaElectronica;

import java.util.List;

public interface ServicioCuentas {

    boolean agregarCuenta(Cuenta cuenta);
    boolean cancelarCuenta(int numero);
    void abonarCuenta(int numero, double abono);
    void retirar(int numero, double retiro);
    List<Cuenta> obtenerCuentas();

}
