import java.time.LocalDate;

public class Alimentare  extends Prodotto {


        private LocalDate dataScadenza;
        public Alimentare(String codice, String descrizione, double prezzo, LocalDate dataScadenza) {
            super(codice, descrizione, prezzo); //superclasse
            this.dataScadenza = dataScadenza;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    // estendere il metodo di applica sconto; 10gg dalla data di scandenza 10% altrimenti richiamo il metodo della superclasse
    @Override
    public void applicaSconto() {
        LocalDate oggi = LocalDate.now();
        if (oggi.plusDays(10).compareTo(dataScadenza) > 0) {
            double sconto = getPrezzo() * 0.1;
            setPrezzo(getPrezzo() - sconto);
        } else {
            super.applicaSconto(); //e qui si richiama l'applica sconto del 5%
        }
    }
}
