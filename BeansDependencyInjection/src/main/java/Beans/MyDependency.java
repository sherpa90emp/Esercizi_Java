package Beans;

// una semplice dipendenza; classe java pojo che verrà usata per essere iniettata in un altro componente
public class MyDependency {
    private static final String MESSAGGIO = "Ciao dalla dipendenza";

    public String getMessaggio() {
        return MESSAGGIO;
    }
}
