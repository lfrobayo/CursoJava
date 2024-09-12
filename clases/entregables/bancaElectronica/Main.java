package entregables.bancaElectronica;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Domicilio domicilioUno= new Domicilio("st",2,"mani","NY",1701);
        Cliente clienteUno= new Cliente(1,"Prueba", domicilioUno,"rfc","300","25 de junio 1994");
        Cliente clienteDos= new Cliente(2,"Prueba2", domicilioUno,"rfc","302","25 de junio 1990");
        ArrayList<Cliente> clientesBancoUno= new ArrayList<>();
        clientesBancoUno.add(clienteUno);
        clientesBancoUno.add(clienteDos);
        Banco bancoUno=new Banco("RP",domicilioUno,"rfc","301",clientesBancoUno);
        System.out.println(bancoUno);
    }
}
