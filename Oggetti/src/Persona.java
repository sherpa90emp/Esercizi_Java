public class Persona {
    // non si dichiara il main alla creazione della classe, poichè verra utilizzata esternamente in un main

    // variabili di istanza (questo è lo stampino lo scheletro che verrà riutilizzato al di fuori)
    private String nome;
    private byte eta;

    // essendo le caratteristiche private, dobbiamo creare un metodo per potervi accedere al di fuori di questa classe

    // metodo costruttore vuoto
    public Persona() {

    }

    // metodo costruttore a 2 argomenti (overload)
    public Persona(String nome, byte eta) {
        this.nome = nome; // a destra ci arriva il valore attraverso il metodo mentre thi.nome fa riferimento al nome della classe; per prassi si chiamano uguali
        this.eta = eta;
    }

    // getter, per solo la lettura delle var di istanza
    public String getNome() {
        return nome;
    }

    public byte getEta() {
        return eta;
    }

    // setter, permette la modifica delle var di istanza
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEta(byte eta) {
        this.eta = eta;
    }

    //metodi di comportamento
    public String saluta(Persona p) {
        return "Ciao " + p.getNome() + " sono " + this.nome + " e ti saluto!";
    }

    public void  compiAnni() {
        this.eta++;
    }

    @Override
    public String toString() {
        String retValue ="";

        retValue += "Nome : " + nome + ", età: " + eta;
        return retValue;
    }
}
