package entregables.bancaElectronica;

import entregables.bancaElectronica.implementacion.ServicioClientesImp;
import entregables.bancaElectronica.implementacion.ServicioCuentasImp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Crear domicilio
        Domicilio domicilioUno = new Domicilio("st", 2, "mani", "NY", 1701);

        // Crear clientes
        Cliente clienteUno = new Cliente(1, "Prueba", domicilioUno, "rfc", "300", "25 de junio 1994");
        Cliente clienteDos = new Cliente(2, "Prueba2", domicilioUno, "rfc", "302", "25 de junio 1990");

        // Crear lista de clientes para el banco
        TreeSet<Cliente> clientesBancoUno = new TreeSet<>();
        clientesBancoUno.add(clienteUno);
        clientesBancoUno.add(clienteDos);

        /*Collections.sort(clientesBancoUno);
        Esto se hizo con la intencion de mostrar un ordenamiento
        pero al cambiar por TreeSet el tipo de dato de cliente
        ya no es necesario, pues treeSet ordena de menor a mayor
        System.out.println("Clientes ordenados por número:");
        for (Cliente cliente : clientesBancoUno) {
            System.out.println(cliente);
        }*/

        // Crear banco
        Banco bancoUno = new Banco("RP", domicilioUno, "rfc", "301", clientesBancoUno);

        // Servicio de clientes y cuentas
        ServicioClientes servicioClientes = new ServicioClientesImp(bancoUno);
        ServicioCuentas servicioCuentasClienteUno = new ServicioCuentasImp(clienteUno);
        ServicioCuentas servicioCuentasClienteDos = new ServicioCuentasImp(clienteDos);

        // Crear cuentas para clienteUno y clienteDos
        CuentaDeAhorro cuentaAhorroClienteUno = new CuentaDeAhorro(1, 500, 2);  // Cliente Uno
        CuentaDeCheque cuentaChequeClienteDos = new CuentaDeCheque(2, 1000, 100);  // Cliente Dos

        // Agregar cuentas a los clientes
        servicioCuentasClienteUno.agregarCuenta(cuentaAhorroClienteUno);
        servicioCuentasClienteDos.agregarCuenta(cuentaChequeClienteDos);

        // Mostrar cuentas de clienteUno
        System.out.println("Cuentas del Cliente Uno:");
        for (Cuenta cuenta : servicioCuentasClienteUno.obtenerCuentas()) {
            System.out.println(cuenta);
        }

        // Mostrar cuentas de clienteDos
        System.out.println("\nCuentas del Cliente Dos:");
        for (Cuenta cuenta : servicioCuentasClienteDos.obtenerCuentas()) {
            System.out.println(cuenta);
        }

        // Abonar y retirar
        servicioCuentasClienteUno.abonarCuenta(1, 100);  // Abonar 100 a la cuenta de clienteUno
        servicioCuentasClienteDos.retirar(2, 200);  // Retirar 200 de la cuenta de clienteDos

        // Mostrar estado final de las cuentas
        System.out.println("\nEstado final de las cuentas después de abonos y retiros:");
        System.out.println(clienteUno);
        System.out.println(clienteDos);


    }

}
