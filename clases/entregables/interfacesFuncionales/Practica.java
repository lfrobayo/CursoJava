package entregables.interfacesFuncionales;

public interface Practica {

    @FunctionalInterface
    interface Interfaz1{
        void metodo(int a, String b, float c);
    }

    @FunctionalInterface
    interface Interfaz2<A,B,C,D>{
        D metodo(A a, B b, C c);
    }

    @FunctionalInterface
    interface Interfaz3{
        String metodo(String a, String B);
    }

    @FunctionalInterface
    interface Interfaz4{
        void metodo();
    }

    @FunctionalInterface
    interface Interfaz5{
        Long metodo(int a, int b);
    }

    @FunctionalInterface
    interface Interfaz6{
        Number metodo(Integer a, Long b);
    }

    @FunctionalInterface
    interface Interfaz7{
        String metodo(String a, StringBuilder b);
    }

    @FunctionalInterface
    interface Interfaz8{
        Object metodo();
    }

    @FunctionalInterface
    interface Interfaz9{
        String metodo(Object a, Object b);
    }

    @FunctionalInterface
    interface Interfaz10{
        String metodo(int a, char b, float c);
    }
}
