package practicas.bucles;

import java.util.ArrayList;

public class EjerciciosFor {

    public void Descendente(int a, int b){
        for(int i=b;i>=a;i--){
            System.out.println(i); ;
        }
    }

    public void Pares(int a){
        for(int i=1;i<a+1;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }

    public void Impares(int a){
        for(int i=0;i<a+1;i++){
            if(i%2==1){
                System.out.println(i);
            }
        }
    }

    public void TablaCinco(int a){
        for(int i=1;i<a+1;i++){
            System.out.println("5x"+i+"="+i*5);
        }
    }

    public void Exponencial(int a){
        for(int i=1;i<a+1;i++){
            System.out.println(i+"^2= "+i*i);
        }
    }

    public void Doble(int a){
        for(int i=1;i<a+1;i++){
            System.out.println(i+"-"+i*2);
        }
    }

    public void Escritura(int a){
        for(int i=1;i<a+1;i++){
            System.out.println("Numero: "+i);
        }
    }

    public int SumaPrimeros(int a){//revisar recursion
        int suma=0;
        for(int i=0;i<=a;i++){
            suma=suma+i;
        }
        return suma;
    }

    public void AsteriscosLinea(int a){
        for(int i=0;i<a;i++){
            System.out.print("*");
        }
    }

    public void ImprimirArray(ArrayList<Integer> arreglo){
        int pos=0;
        for(int i:arreglo){ //Esto es un for del tipo for- each, se ve mejor para recorrer arreglos.
            System.out.println("Posicion "+pos+"= "+i);
            pos++;
        }
    }

    public int SumaArray(ArrayList<Integer> arreglo){
        int suma=0;
        for(int i:arreglo){
            suma+=i;
        }
        return suma;
    }

    public int NumMayor(ArrayList<Integer> arreglo){
        int mayor=0;
        for(int i:arreglo){
            if(mayor<i){
                mayor=i;
            }
        }
        return mayor;
    }

    public int CuantosDiez(ArrayList<Integer> arreglo){
        int cont=0;
        for(int i:arreglo){
            if(i==10){
                cont++;
            }
        }
        return cont;
    }

    public int MayorQue(ArrayList<Integer> arreglo,int a){
        int cont=0;
        for(int i:arreglo){
            if(i>a){
                cont++;
            }
        }
        return cont;
    }





}
