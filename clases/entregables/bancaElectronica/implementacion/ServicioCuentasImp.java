package entregables.bancaElectronica.implementacion;

import entregables.bancaElectronica.Cliente;
import entregables.bancaElectronica.Cuenta;
import entregables.bancaElectronica.ServicioCuentas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Cuenta> cuentas = cliente.getCuentas();
        Optional<Cuenta> cuentaAEliminar = cuentas.parallelStream()
                .filter(cuenta -> cuenta.getNumero() == numero)
                .findFirst();

        cuentaAEliminar.ifPresent(cuentas::remove);

        return cuentaAEliminar.isPresent();
    }

    @Override
    public void abonarCuenta(int numero, double abono) {
        cliente.getCuentas().parallelStream()
                .filter(cuenta -> cuenta.getNumero() == numero)
                .findFirst()
                .ifPresent(cuenta -> cuenta.setSaldo(cuenta.getSaldo() + abono));

    }

    @Override
    public void retirar(int numero, double retiro) {
        cliente.getCuentas().parallelStream()
                .filter(cuenta -> cuenta.getNumero() == numero)
                .findFirst()
                .ifPresent(cuenta -> cuenta.setSaldo(cuenta.getSaldo() - retiro));
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cliente.getCuentas();
    }
}

