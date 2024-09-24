package entregables.bancaElectronica;

import entregables.bancaElectronica.implementacion.ServicioClientesImp;
import entregables.bancaElectronica.implementacion.ServicioCuentasImp;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Crear domicilio
        Domicilio domicilioUno = new Domicilio("st", 2, "mani", "NY", 1701);

        // Crear clientes
        Cliente clienteUno = new Cliente(1, "Pruebaaaaaa", domicilioUno, "rfccap7", "300", "25 de junio 1994");
        Cliente clienteDos = new Cliente(2, "Prueba2", domicilioUno, "rfcCap7", "302", "25 de junio 1990");
        Cliente clienteTres = new Cliente(3, "Prueba3", domicilioUno, "rfcCap8", "303", "25 de junio 1980");

        // Crear TreeSet de clientes para el banco (TreeSet ya los ordena por número)
        TreeSet<Cliente> clientesBancoUno = new TreeSet<>();
        clientesBancoUno.add(clienteUno);
        clientesBancoUno.add(clienteDos);
        clientesBancoUno.add(clienteTres);


        /*Collections.sort(clientesBancoUno);
        Esto se hizo con la intencion de mostrar un ordenamiento
        pero al cambiar por TreeSet el tipo de dato de cliente
        ya no es necesario, pues treeSet ordena de menor a mayor
        System.out.println("Clientes ordenados por número:");
        for (Cliente cliente : clientesBancoUno) {
            System.out.println(cliente);
        }*/

        // Crear banco con los clientes
        Banco bancoUno = new Banco("RP", domicilioUno, "rfc", "301", clientesBancoUno);

        // Servicio de clientes y cuentas
        ServicioClientes servicioClientes = new ServicioClientesImp(bancoUno);
        ServicioCuentas servicioCuentasClienteUno = new ServicioCuentasImp(clienteUno);
        ServicioCuentas servicioCuentasClienteDos = new ServicioCuentasImp(clienteDos);

        // Crear cuentas para clienteUno y clienteDos
        CuentaDeAhorro cuentaAhorroClienteUno = new CuentaDeAhorro(1, 500, 2);  // Cuenta de ahorro para Cliente Uno
        CuentaDeCheque cuentaChequeClienteDos = new CuentaDeCheque(2, 1000, 10);  // Cuenta de cheque para Cliente Dos

        // Agregar cuentas a los clientes
        servicioCuentasClienteUno.agregarCuenta(cuentaAhorroClienteUno);
        servicioCuentasClienteDos.agregarCuenta(cuentaChequeClienteDos);

        // Mostrar cuentas de clienteUno
        System.out.println("Cuentas del Cliente Uno:");
        servicioCuentasClienteUno.obtenerCuentas().forEach(System.out::println);

        // Mostrar cuentas de clienteDos
        System.out.println("\nCuentas del Cliente Dos:");
        servicioCuentasClienteDos.obtenerCuentas().forEach(System.out::println);

        // Abonar y retirar
        servicioCuentasClienteUno.abonarCuenta(1, 100);
        servicioCuentasClienteDos.retirar(2, 20);

        // Mostrar estado final de las cuentas después de abonos y retiros
        System.out.println("\nEstado final de las cuentas después de abonos y retiros:");
        System.out.println("Cliente Uno:\n" + clienteUno);
        System.out.println("Cliente Dos:\n" + clienteDos);

        // Eliminar cliente del banco
        boolean clienteEliminado = servicioClientes.eliminarCliente(2);
        System.out.println("Cliente 2 eliminado: " + clienteEliminado);

        // Mostrar los clientes restantes en el banco
        System.out.println("Clientes restantes en el banco:");
        bancoUno.getClientes().forEach(System.out::println);
    }
}

