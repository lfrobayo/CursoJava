package practicas;

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
}
