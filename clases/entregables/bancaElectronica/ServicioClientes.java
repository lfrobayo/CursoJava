package entregables.bancaElectronica;

import java.util.List;

public interface ServicioClientes {

    boolean agregarCliente(Cliente cliente);
    boolean eliminarCliente(int numero);
    Cliente consultarCliente(int numero);
    List<Cliente> obtenerCliente();
    Cliente buscarClientePorRFC(String rfc);

}
