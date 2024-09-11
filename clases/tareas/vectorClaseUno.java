package tareas;

public class vectorClaseUno {
    public static void main(String[] args) {
        //Crear un arreglo
        int[] arreglo=new int[5];
        //Poner valores
        for(int i=0;i<arreglo.length;i++){
            arreglo[i]=i+1;
        }
        //Imprimir
        for(int i=0;i<arreglo.length;i++){
            System.out.println("Posición("+i+") ="+arreglo[i]);
        }
    }
}
