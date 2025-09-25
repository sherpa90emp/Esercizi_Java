package Injector;

import Beans.MyDependency;

//agisce da container per l'iniezione tramite interfaccia; crea la dipendenza e la passa aqualsiasi oggetto che implementi l'interfaccia
public class Injector {

    public static void performInjection(Object target) {
        //controlla se l'oggetto target implementa la giusta interfaccia
        if (target instanceof Injectable) {
            System.out.println("Injector: Trovato oggetto di tipo onjectable. Procedo con l'iniezione");
            //creo la dipendenza
            MyDependency dependency = new MyDependency();
            //cast dell'oggetto al tipo dell'interfaccia
            Injectable injectable = (Injectable) target;
            //chiamo il metodo dell'interfaccia
            injectable.inject(dependency);
        }
    }
}
