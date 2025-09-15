public class Autovettura extends Veicolo {
    private byte numeroDiPorte;
    private byte numeroDiPosti;

    public Autovettura(Marche marca, String modello, String numeroDiTarga, TariffaGiornalieraEuro tariffaGiornalieraEuro, byte numeroDiPorte, byte numeroDiPosti) {
        super(marca, modello, numeroDiTarga, tariffaGiornalieraEuro);
        this.numeroDiPorte = numeroDiPorte;
        this.numeroDiPosti = numeroDiPosti;
    }

    public byte getNumeroDiPorte() {
        return numeroDiPorte;
    }

    public void setNumeroDiPorte(byte numeroDiPorte) {
        this.numeroDiPorte = numeroDiPorte;
    }

    public byte getNumeroDiPosti() {
        return numeroDiPosti;
    }

    public void setNumeroDiPosti(byte numeroDiPosti) {
        this.numeroDiPosti = numeroDiPosti;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Numero di porte: " + numeroDiPorte + "\n" +
                "Numero di posti: " + numeroDiPosti + "\n";
    }
}
