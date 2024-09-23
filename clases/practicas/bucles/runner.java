package practicas.bucles;

import java.util.ArrayList;

public class runner {
    public static void main(String[] args) {
        EjerciciosFor ejercicios= new EjerciciosFor();
        //ejercicios.Descendente(1,10);
        //ejercicios.Pares(20);
        //ejercicios.Impares(20);
        //ejercicios.TablaCinco(10);
        //ejercicios.Exponencial(10);
        //ejercicios.Doble(10);
        //ejercicios.Escritura(10);
        //System.out.println(ejercicios.SumaPrimeros(10));
        //ejercicios.AsteriscosLinea(10);

        ArrayList<Integer> numeros=new ArrayList<>();
        numeros.add(2);
        numeros.add(10);
        numeros.add(4);
        numeros.add(12);
        numeros.add(10);
        numeros.add(3);
        numeros.add(11);
        //ejercicios.ImprimirArray(numeros);
        //System.out.println(ejercicios.SumaArray(numeros));
        //System.out.println(ejercicios.NumMayor(numeros));
        //System.out.println(ejercicios.CuantosDiez(numeros));
        //System.out.println(ejercicios.MayorQue(numeros,10));
        //ejercicios.Multiplos(1,100,3);
        //ejercicios.Inverso(numeros);
        //System.out.println(ejercicios.Fibonacci(3));
        //ejercicios.FibonacciFor(5);
        //ejercicios.Palabra("hola");
        //ejercicios.Mayuscula("hola");
        //ejercicios.AsteriscosPiramide(5);
        //System.out.println(ejercicios.Encontrado(numeros,40));
        //ejercicios.PosImpares(numeros);
        //System.out.println(ejercicios.PromArray(numeros));
        Object[] arreglo = {1, "Hola", 3.14, "Mundo", 42, "Java"};
        //System.out.println(ejercicios.CuantosString(arreglo));
        String[] arregloS = {"Hola", "Mundo", "Java", "Programación", "Código"};
        //ejercicios.Cadena(arregloS);
        //ejercicios.PiramideInver(5);

        ArrayList<String> listaDeNumeros = new ArrayList<>();
        listaDeNumeros.add("123");
        listaDeNumeros.add("456");
        listaDeNumeros.add("789");
        listaDeNumeros.add("101112");
        listaDeNumeros.add("131415");

        //ejercicios.StringtoNum(listaDeNumeros);

        ArrayList<Integer> listaDeNumerosDos = new ArrayList<>();

        // Agregar números menores y mayores a 50
        listaDeNumerosDos.add(10);
        listaDeNumerosDos.add(25);
        listaDeNumerosDos.add(50);
        listaDeNumerosDos.add(75);
        listaDeNumerosDos.add(100);
        listaDeNumerosDos.add(1);
        listaDeNumerosDos.add(55);

        //ejercicios.MayorQueEnArray(listaDeNumerosDos,50);
        //ejercicios.MenorMayor(listaDeNumerosDos);

        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //ejercicios.Transpuesta(matriz);


        ArrayList<Integer> numerosPalindromos = new ArrayList<>();

        numerosPalindromos.add(1);
        numerosPalindromos.add(3);
        numerosPalindromos.add(5);
        numerosPalindromos.add(5);
        numerosPalindromos.add(3);
        numerosPalindromos.add(1);

        //System.out.println(ejercicios.Palindromo(numerosPalindromos));
        //ejercicios.SegundoMayor(numeros);
        //ejercicios.Factores(100);
        //System.out.println(ejercicios.Factorial(4));
        //System.out.println(ejercicios.FactorialDos(4));
        //ejercicios.Triangulo(5);
        //ejercicios.Primos(100);
        //ejercicios.Perfecto(5);
        int[][] matrizA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrizB = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        //ejercicios.SumaMatrices(matrizA,matrizB);
        //ejercicios.MultiplicarMatrices(matrizA,matrizB);
        ejercicios.TrianguloRaro(5);





    }
}
