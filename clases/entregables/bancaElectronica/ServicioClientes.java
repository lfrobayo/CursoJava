package entregables.bancaElectronica;

import java.util.List;
import java.util.TreeSet;

public interface ServicioClientes {

    boolean agregarCliente(Cliente cliente);
    boolean eliminarCliente(int numero);
    Cliente consultarCliente(int numero);
    TreeSet<Cliente> obtenerCliente();
    Cliente buscarClientePorRFC(String rfc);

}
