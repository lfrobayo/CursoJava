package entregables.bancaElectronica.implementacion;

import entregables.bancaElectronica.Cuenta;
import entregables.bancaElectronica.CuentaDeAhorro;
import entregables.bancaElectronica.CuentaDeCheque;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LeerArchivoAsignarCuentas implements Runnable {

    private final String filePath;
    private final ServicioCuentasImp servicioCuentasClienteUno;
    private final ServicioCuentasImp servicioCuentasClienteDos;
    private final ServicioCuentasImp servicioCuentasClienteTres;

    public LeerArchivoAsignarCuentas(String filePath, ServicioCuentasImp servicioCuentasClienteUno,
                                     ServicioCuentasImp servicioCuentasClienteDos, ServicioCuentasImp servicioCuentasClienteTres) {
        this.filePath = filePath;
        this.servicioCuentasClienteUno = servicioCuentasClienteUno;
        this.servicioCuentasClienteDos = servicioCuentasClienteDos;
        this.servicioCuentasClienteTres = servicioCuentasClienteTres;
    }

    @Override
    public void run() {
        Path path = Path.of(filePath);
        List<String> lineas;
        try {
            lineas = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Asignar cuentas a los clientes según el archivo
        for (String linea : lineas) {
            try {
                if (linea.isEmpty()) {
                    continue;
                }

                String tipoCuenta = linea.substring(0, 2);
                String[] partes = linea.substring(2).replace("[", "").replace("]", "").split(",");

                if (partes.length < 5) {
                    System.err.println("Línea mal formateada: " + linea);
                    continue;
                }

                int numero = Integer.parseInt(partes[0].trim());
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
    }
}