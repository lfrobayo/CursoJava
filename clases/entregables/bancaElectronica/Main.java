package entregables.bancaElectronica;

import entregables.bancaElectronica.implementacion.ServicioClientesImp;
import entregables.bancaElectronica.implementacion.ServicioCuentasImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear domicilio
        Domicilio domicilioUno = new Domicilio("st", 2, "mani", "NY", 1701);


        // Crear clientes
        Cliente clienteUno = new Cliente(1, "Pruebaaaaaa", domicilioUno, "rfccap7", "300", "25-06-1994");
        Cliente clienteDos = new Cliente(2, "Prueba2", domicilioUno, "rfcCap7", "302", "25-06-1990");
        Cliente clienteTres = new Cliente(3, "Prueba3", domicilioUno, "rfcCap8", "303", "25-06-1980");

        // Crear TreeSet de clientes para el banco (TreeSet ya los ordena por número)
        TreeSet<Cliente> clientesBancoUno = new TreeSet<>();
        clientesBancoUno.add(clienteUno);
        clientesBancoUno.add(clienteDos);
        clientesBancoUno.add(clienteTres);

        // Leer el archivo de cuentas
        Path path = Paths.get("clases/entregables/bancaElectronica/files/cuentas.txt");
        List<String> lineas;
        try {
            lineas = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Crear banco con los clientes
        Banco bancoUno = new Banco("RP", domicilioUno, "rfc", "301", clientesBancoUno);

        // Servicio de clientes y cuentas
        ServicioClientes servicioClientes = new ServicioClientesImp(bancoUno);
        ServicioCuentas servicioCuentasClienteUno = new ServicioCuentasImp(clienteUno);
        ServicioCuentas servicioCuentasClienteDos = new ServicioCuentasImp(clienteDos);
        ServicioCuentas servicioCuentasClienteTres = new ServicioCuentasImp(clienteTres);

        // Asignar cuentas a los clientes según el archivo
        for (String linea : lineas) {
            try {
                if (linea.isEmpty()) {
                    continue; // Salta las líneas vacías
                }

                String tipoCuenta = linea.substring(0, 2);
                String[] partes = linea.substring(2).replace("[", "").replace("]", "").split(",");

                if (partes.length < 5) {
                    System.err.println("Línea mal formateada: " + linea);
                    continue;
                }
                //.trim() sirve para deshacerse de los espacios en blanco
                int numero = Integer.parseInt(partes[0].trim());
                String fecha = partes[1].trim();
                double saldo = Double.parseDouble(partes[2].trim());
                double tasaInteres = Double.parseDouble(partes[3].trim());
                int clienteId = Integer.parseInt(partes[4].trim());

                Cuenta cuenta;
                if (tipoCuenta.equals("CA")) {
                    cuenta = new CuentaDeAhorro(numero, saldo, tasaInteres);
                } else if (tipoCuenta.equals("CC")) {
                    cuenta = new CuentaDeCheque(numero, saldo, tasaInteres);
                } else {
                    System.err.println("Tipo de cuenta desconocido: " + tipoCuenta);
                    continue;
                }

                // Asignar cuentas a los clientes según su ID
                switch (clienteId) {
                    case 1:
                        servicioCuentasClienteUno.agregarCuenta(cuenta);
                        break;
                    case 2:
                        servicioCuentasClienteDos.agregarCuenta(cuenta);
                        break;
                    case 3:
                        servicioCuentasClienteTres.agregarCuenta(cuenta);
                        break;
                    default:
                        System.err.println("ID de cliente desconocido: " + clienteId);
                }
            } catch (Exception e) {
                System.err.println("Error al procesar la línea: " + linea);
                System.err.println("Error: " + e.getMessage());
            }
        }

        // Mostrar cuentas de cada cliente
        System.out.println("Cuentas del Cliente Uno:");
        for (Cuenta cuenta : servicioCuentasClienteUno.obtenerCuentas()) {
            System.out.println(cuenta);
        }

        System.out.println("\nCuentas del Cliente Dos:");
        for (Cuenta cuenta : servicioCuentasClienteDos.obtenerCuentas()) {
            System.out.println(cuenta);
        }

        System.out.println("\nCuentas del Cliente Tres:");
        for (Cuenta cuenta : servicioCuentasClienteTres.obtenerCuentas()) {
            System.out.println(cuenta);
        }


    }
}

