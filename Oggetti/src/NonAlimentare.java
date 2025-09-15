import java.time.LocalDate;

public class NonAlimentare extends Prodotto {

    private Materiale materiale;

    public NonAlimentare(String codice, String descrizione, double prezzo, Materiale materiale) {
        super(codice, descrizione, prezzo);
        this.materiale = materiale;
    }
    public Materiale getMateriale() {
        return materiale;
    }
    public void setMateriale(Materiale materiale) {
        this.materiale = materiale;
    }

    @Override
    public void applicaSconto() {
        switch (materiale) {
            case CARTA:
            case VETRO:
            case PLASTICA:
                double sconto = getPrezzo() * 0.1;
                setPrezzo(getPrezzo() - sconto);
                break;
            default:
                super.applicaSconto();
                break;
        }
    }
}
