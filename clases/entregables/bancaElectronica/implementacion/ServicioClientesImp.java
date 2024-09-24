package entregables.bancaElectronica.implementacion;

import entregables.bancaElectronica.Banco;
import entregables.bancaElectronica.Cliente;
import entregables.bancaElectronica.ServicioClientes;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class ServicioClientesImp implements ServicioClientes {

    private Banco banco;
    private TreeSet<Cliente> clientes;

    public ServicioClientesImp(Banco banco) {
        this.banco = banco;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        clientes=banco.getClientes();
        clientes.add(cliente);
        banco.setClientes(clientes);
        return banco.getClientes().contains(cliente);
    }

    @Override
    public boolean eliminarCliente(int numero) {
        TreeSet<Cliente> clientes = banco.getClientes();
        Optional<Cliente> clienteAEliminar = clientes.parallelStream()
                .filter(cliente -> cliente.getNumero() == numero)
                .findFirst();

        clienteAEliminar.ifPresent(clientes::remove);

        return clienteAEliminar.isPresent();
    }

    @Override
    public Cliente consultarCliente(int numero) {
        return banco.getClientes().parallelStream()
                .filter(cliente -> cliente.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    @Override
    public TreeSet<Cliente> obtenerCliente() {
        return banco.getClientes();
    }

    @Override
    public Cliente buscarClientePorRFC(String rfc) {
        clientes=banco.getClientes();
        for(Cliente cliente:clientes){
            if(cliente.getRfc().equals(rfc)){
                return cliente;
            }
        }
        return null;
    }
}
