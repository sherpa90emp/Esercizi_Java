import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Noleggio {
    private LocalDate dataInizioNoleggio;
    private LocalDate dataFineNoleggio;
    private Cliente cliente;
    private Veicolo veicolo;

    public Noleggio(LocalDate dataInizioNoleggio, LocalDate dataFineNoleggio, Cliente cliente, Veicolo veicolo) {
        this.dataInizioNoleggio = dataInizioNoleggio;
        this.dataFineNoleggio = dataFineNoleggio;
        this.cliente = cliente;
        this.veicolo = veicolo;
    }

    public LocalDate getDataInizioNoleggio() {
        return dataInizioNoleggio;
    }

    public void setDataInizioNoleggio(LocalDate dataInizioNoleggio) {
        this.dataInizioNoleggio = dataInizioNoleggio;
    }

    public LocalDate getDataFineNoleggio() {
        return dataFineNoleggio;
    }

    public void setDataFineNoleggio(LocalDate dataFineNoleggio) {
        this.dataFineNoleggio = dataFineNoleggio;
    }

    public Cliente getClienti() {
        return cliente;
    }

    public void setClienti(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veicolo getVeicoli() {
        return veicolo;
    }

    public void setVeicoli(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    @Override
    public String toString() {
        long durataNolegggio = ChronoUnit.DAYS.between(dataInizioNoleggio, dataFineNoleggio);
        double costoNoleggio = durataNolegggio * veicolo.getTariffaGiornalieraEuro().getPrezzo();


        return  "Cliente: " + "\n" +
                "Sig/Sig.ra: " + cliente.getNome() + " " + cliente.getCognome() + "\n" +
                "Numero patente: " + cliente.getNumeroPatente() + "\n" +
                "Veicolo noleggiato: " + "\n" +
                "Marca: " + veicolo.getMarca() + "\n" +
                "Modello: " + veicolo.getModello() + "\n" +
                "Tariffa giornaliera: " + veicolo.getTariffaGiornalieraEuro().getPrezzo()+ " €" + "\n" +
                "Data di inizio noleggio: " + dataInizioNoleggio + "\n" +
                "Data di fine noleggio: " + dataFineNoleggio + "\n" +
                "Costo totale noleggio: " + costoNoleggio + " €";
    }
}