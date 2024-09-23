package entregables.bancaElectronica.implementacion;

import entregables.bancaElectronica.Cliente;
import entregables.bancaElectronica.Cuenta;
import entregables.bancaElectronica.ServicioCuentas;

import java.util.ArrayList;
import java.util.List;

public class ServicioCuentasImp implements ServicioCuentas {

    private ArrayList<Cuenta> cuentas;
    private Cliente cliente;

    public ServicioCuentasImp(Cliente cliente) {
        this.cliente = cliente;
        if (cliente.getCuentas() == null) {
            cliente.setCuentas(new ArrayList<>());
        }
    }

    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        cuentas=cliente.getCuentas();
        cuentas.add(cuenta);
        cliente.setCuentas(cuentas);
        return cliente.getCuentas().contains(cuenta);
    }

    @Override
    public boolean cancelarCuenta(int numero) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero() == numero) {
                cuentas.remove(cuenta);
                return true;
            }
        }
        return false;
    }

    @Override
    public void abonarCuenta(int numero, double abono) {
        cuentas=cliente.getCuentas();
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero() == numero) {
                cuenta.setSaldo(cuenta.getSaldo()+abono);
                break;
            }
        }
    }

    @Override
    public void retirar(int numero, double retiro) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero() == numero) {
                cuenta.setSaldo(cuenta.getSaldo()-retiro);
                break;
            }
        }
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cliente.getCuentas();
    }
}

