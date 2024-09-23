package entregables.bancaElectronica;

import java.util.ArrayList;

public class Banco {
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private ArrayList<Cliente> clientes;

    public Banco(String nombre, Domicilio domicilio, String rfc, String telefono, ArrayList<Cliente> clientes) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //Stringbuldier permite mejorar la concatenación de string cuando
        // se tienen string dentro de otro como en este caso
        sb.append(String.format(
                "Banco: %s\nRFC: %s\nTelefono: %s\n%s\n\nClientes:\n",
                nombre, rfc, telefono, domicilio.toString()
        ));

        for (Cliente cliente : clientes) {
            sb.append(cliente.toString()).append("\n");
        }

        return sb.toString();
    }
}
