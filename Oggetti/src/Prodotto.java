public class Prodotto {
    private final String codice;
    private final String descrizione;
    private double prezzo;

    public Prodotto(String codice, String descrizione, double prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override // creato sempre tramite generate
    public String toString() {
        return "Prodotto{" +
                "codice='" + codice + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }

    public void applicaSconto() {
        double sconto = prezzo * 0.05;  //omesso il this. ma dal colore è visibile che stiamo richiamando il prezzo di prodotto
        prezzo -= sconto;
    }
}
