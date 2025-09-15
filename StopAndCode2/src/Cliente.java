public class Cliente {
    private String nome;
    private String cognome;
    private String numeroPatente;

    public Cliente(String nome, String cognome, String numeroPatente) {
        this.nome = maiuscoloPrimaLettera(nome);
        this.cognome = maiuscoloPrimaLettera(cognome);
        this.numeroPatente = numeroPatente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroPatente() {
        return numeroPatente;
    }

    public void setNumeroPatente(String numeroPatente) {
        this.numeroPatente = numeroPatente;
    }

    public static String maiuscoloPrimaLettera(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + "\n" +
                "Cognome: " + cognome + "\n" +
                "Numero Patente: " + numeroPatente + "\n";
    }
}
