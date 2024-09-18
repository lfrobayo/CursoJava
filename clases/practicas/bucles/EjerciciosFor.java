package practicas.bucles;

import java.util.ArrayList;

public class EjerciciosFor {

    public void Descendente(int a, int b) {
        for (int i = b; i >= a; i--) {
            System.out.println(i);
            ;
        }
    }

    public void Pares(int a) {
        for (int i = 1; i < a + 1; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public void Impares(int a) {
        for (int i = 0; i < a + 1; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    public void TablaCinco(int a) {
        for (int i = 1; i < a + 1; i++) {
            System.out.println("5x" + i + "=" + i * 5);
        }
    }

    public void Exponencial(int a) {
        for (int i = 1; i < a + 1; i++) {
            System.out.println(i + "^2= " + i * i);
        }
    }

    public void Doble(int a) {
        for (int i = 1; i < a + 1; i++) {
            System.out.println(i + "-" + i * 2);
        }
    }

    public void Escritura(int a) {
        for (int i = 1; i < a + 1; i++) {
            System.out.println("Numero: " + i);
        }
    }

    public int SumaPrimeros(int a) {//revisar recursion
        int suma = 0;
        for (int i = 0; i <= a; i++) {
            suma = suma + i;
        }
        return suma;
    }

    public void AsteriscosLinea(int a) {
        for (int i = 0; i < a; i++) {
            System.out.print("*");
        }
    }

    public void ImprimirArray(ArrayList<Integer> arreglo) {
        int pos = 0;
        for (int i : arreglo) { //Esto es un for del tipo for- each, se ve mejor para recorrer arreglos.
            System.out.println("Posicion " + pos + "= " + i);
            pos++;
        }
    }

    public int SumaArray(ArrayList<Integer> arreglo) {
        int suma = 0;
        for (int i : arreglo) {
            suma += i;
        }
        return suma;
    }

    public int NumMayor(ArrayList<Integer> arreglo) {
        int mayor = 0;
        for (int i : arreglo) {
            if (mayor < i) {
                mayor = i;
            }
        }
        return mayor;
    }

    public int CuantosDiez(ArrayList<Integer> arreglo) {
        int cont = 0;
        for (int i : arreglo) {
            if (i == 10) {
                cont++;
            }
        }
        return cont;
    }

    public int MayorQue(ArrayList<Integer> arreglo, int a) {
        int cont = 0;
        for (int i : arreglo) {
            if (i > a) {
                cont++;
            }
        }
        return cont;
    }

    public void Multiplos(int inf, int sup, int mul) {
        for (int i = inf; i <= sup; i++) {
            if (i % mul == 0) {
                System.out.println(i);
            }
        }
    }

    public void Inverso(ArrayList<Integer> arreglo) {
        System.out.println("Este es el array en su orden natural");
        for (int i : arreglo) {
            System.out.print(" - " + i);
        }
        System.out.println();
        System.out.println("Este es el array en su orden inverso");
        for (int i = arreglo.size() - 1; i >= 0; i--) {
            System.out.print(" - " + arreglo.get(i));
        }
    }

    public int Fibonacci(int a) {//Recursividad
        if (a == 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        } else {
            return Fibonacci(a - 1) + Fibonacci(a - 2);
        }
    }

    public void FibonacciFor(int a){
        int anterior=0;   //F(0)
        int actual=1;    //F(1)
        int siguiente=0; //F(n)
        for(int i=1;i<=a;i++){
            siguiente=anterior+actual;
            anterior=actual;
            actual=siguiente;
            System.out.println(siguiente);
        }
    }

    public void Palabra(String palabra){
        for(int i=0;i<palabra.length();i++){
            System.out.println(palabra.charAt(i));
        }
    }

    public void Mayuscula(String palabra){
        String mayus=palabra.toUpperCase();
        for(int i=0;i<mayus.length();i++){
            System.out.println(mayus.charAt(i));
        }
    }

    public void AsteriscosPiramide(int a){
        for (int i = 1; i <= a; i++) {//altura de piramide
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // Salto de línea después de cada fila
            System.out.println();
        }
    }

    public String Encontrado(ArrayList<Integer> arreglo, int a){
        for(int i:arreglo){
            if(i==a){
                return "Encontrado";
            }
        }
        return "No encontrado";
    }

    public void PosImpares(ArrayList<Integer> arreglo){
        for(int i=0;i< arreglo.size();i++){
            if(i%2==1){
                System.out.println(arreglo.get(i));
            }
        }
    }

    public double PromArray(ArrayList<Integer> arreglo){
        double suma=0;
        for(int i:arreglo){
            suma+=i;
        }
        return suma/arreglo.size();
    }

    public int CuantosString(Object[] arreglo){
        int var=0;
        for(Object i:arreglo){
            if(i instanceof String){
               var++; //instanfeof es para preguntar si es un instancia de....
            }
        }
        return var;
    }

    public void Cadena(String[] arreglo){
        StringBuilder cadena = new StringBuilder();
        for(String i:arreglo){
            cadena.append(i);
        }
        System.out.println(cadena);
    }

    public void PiramideInver(int a){
        for(int i=0;i<a;i++){
            for(int k=a;k>i;k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
