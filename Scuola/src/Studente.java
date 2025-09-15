public class Studente extends Persona {
    private  String matricola;

    public Studente(String nome, int eta, String matricola) {
        super(nome, eta);
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @Override //è necessario implementare il metodo
    public void display() {
        System.out.println("Nome: " + getNome() + ", età: " + getEta() + ", matricola: " + getMatricola());
    }
}
