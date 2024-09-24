package entregables.bancaElectronica;

import entregables.bancaElectronica.implementacion.LeerArchivoAsignarCuentas;
import entregables.bancaElectronica.implementacion.ServicioClientesImp;
import entregables.bancaElectronica.implementacion.ServicioCuentasImp;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Crear domicilio
        Domicilio domicilioUno = new Domicilio("st", 2, "mani", "NY", 1701);

        // Crear clientes
        Cliente clienteUno = new Cliente(1, "Pruebaaaaaa", domicilioUno, "rfccap7", "300", "25-06-1994");
        Cliente clienteDos = new Cliente(2, "Prueba2", domicilioUno, "rfcCap7", "302", "25-06-1990");
        Cliente clienteTres = new Cliente(3, "Prueba3", domicilioUno, "rfcCap8", "303", "25-06-1980");

        // Crear TreeSet de clientes para el banco
        TreeSet<Cliente> clientesBancoUno = new TreeSet<>();
        clientesBancoUno.add(clienteUno);
        clientesBancoUno.add(clienteDos);
        clientesBancoUno.add(clienteTres);

        // Crear banco
        Banco bancoUno = new Banco("RP", domicilioUno, "rfc", "301", clientesBancoUno);

        // Servicio de clientes y cuentas
        ServicioClientesImp servicioClientes = new ServicioClientesImp(bancoUno);
        ServicioCuentasImp servicioCuentasClienteUno = new ServicioCuentasImp(clienteUno);
        ServicioCuentasImp servicioCuentasClienteDos = new ServicioCuentasImp(clienteDos);
        ServicioCuentasImp servicioCuentasClienteTres = new ServicioCuentasImp(clienteTres);

        // Crear un hilo para leer el archivo y asignar cuentas
        //Esto hace que el hilo principal que esta encargado de la creacion no se vea afectado
        Thread hiloLectura = new Thread(new LeerArchivoAsignarCuentas(
                "clases/entregables/bancaElectronica/files/cuentas.txt",
                servicioCuentasClienteUno, servicioCuentasClienteDos, servicioCuentasClienteTres));

        // Iniciar el hilo
        hiloLectura.start();

        // Esperar a que el hilo termine para que las cuentas si esten divididas correctamente
        try {
            hiloLectura.join();
        } catch (InterruptedException e) {
            System.err.println("Error al esperar el hilo: " + e.getMessage());
        }

        // Mostrar cuentas de cada cliente
        System.out.println("Cuentas del Cliente Uno:");
        servicioCuentasClienteUno.obtenerCuentas().forEach(System.out::println);

        System.out.println("\nCuentas del Cliente Dos:");
        servicioCuentasClienteDos.obtenerCuentas().forEach(System.out::println);

        System.out.println("\nCuentas del Cliente Tres:");
        servicioCuentasClienteTres.obtenerCuentas().forEach(System.out::println);
    }
}

