package entregables.bancaElectronica.implementacion;

import entregables.bancaElectronica.Banco;
import entregables.bancaElectronica.Cliente;
import entregables.bancaElectronica.ServicioClientes;

import java.util.ArrayList;
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
        clientes=banco.getClientes();
        for(Cliente cliente:clientes){
            if(cliente.getNumero()==numero){
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    @Override
    public Cliente consultarCliente(int numero) {
        clientes=banco.getClientes();
        for(Cliente cliente:clientes){
            if(cliente.getNumero()==numero){
                return cliente;
            }
        }
        return null;
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
