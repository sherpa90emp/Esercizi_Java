package Beans;

//bean che non ha nessuno stato convenzionale
public class StatelessBean {
    // un semplice modo che crea una stringa di saluto con il nome passato in ingresso
    public String saluta(String nome) {
        System.out.println("StatelessBean: esegue saluta() con nome= " + nome);
        return "Ciao, " + nome + "! Sono lo state less Bean.";
    }
}
