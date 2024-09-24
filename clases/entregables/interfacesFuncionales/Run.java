package entregables.interfacesFuncionales;

public class Run {
    public static void main(String[] args) {
        Practica.Interfaz1 i1 = (a, b, c) -> { /* se agrega el sout para que muestre algo
            por pantalla pues es un metodo void
            O se puede poner el sout en el llamado, si se hace desde acá
            Es como modificar el "metodo", si se hace en el llamado,
            es como llamar un metodo que retorne otra cosa que se debe imprimir el resultado*/
            System.out.println("a: " + a + ", b: " + b + ", c: " + c);
        };
        i1.metodo(10, "Hi", 5.5f);

        Practica.Interfaz2<Integer, String, Float, String> i2 = (a, b, c) -> {
            return "a: " + a + ", b: " + b + ", c: " + c;
        };

        System.out.println(i2.metodo(10, "Hola", 5.5f));

        Practica.Interfaz3 i3= (a, b) ->{
            return " "+a+" "+b;
        };

        System.out.println(i3.metodo("hola", "mundo"));

        Practica.Interfaz4 i4=() ->
            System.out.println("Vacio, esto como para que sirve? ");
        i4.metodo();

        //Lo que hago aquí es definir que hace el metodo
        Practica.Interfaz5 i5=(int a,int b) -> (long) (a*b);
        System.out.println(i5.metodo(5,4));

        Practica.Interfaz6 i6=(Integer a, Long b) -> (Number) (a+b);
        System.out.println(i6.metodo(3, 8L));

        Practica.Interfaz7 i7=(String a, StringBuilder b) ->a+b.toString();
        System.out.println(i7.metodo("HOLAAAAA ",new StringBuilder("Hey friends")));

        Practica.Interfaz8 i8=() -> 43424323;
        System.out.println(i8.metodo());
        //Para qué sirven este tipo de metodos?

        Practica.Interfaz9 i9=(Object a,Object b) ->{ return a.toString()+b.toString();};
        System.out.println(i9.metodo(9," clasesss"));
        //Cuando se necesitan las llaves? Solo con los return?

        Practica.Interfaz10 i10=(int a,char b, float c) -> String.valueOf(a)+b+c;
        System.out.println(i10.metodo(4,'a',4.5f));
        //Por que en el float no me pide el String value?
    }
}


