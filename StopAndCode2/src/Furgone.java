public class Furgone extends Veicolo {
    private short portataInKg;
    private short lunghezza;
    private short larghezza;
    private short altezza;

    public Furgone(Marche marca, String modello, String numeroDiTarga, TariffaGiornalieraEuro tariffaGiornalieraEuro, short portataInKg, short lunghezza, short larghezza, short altezza) {
        super(marca, modello, numeroDiTarga, tariffaGiornalieraEuro);
        this.portataInKg = portataInKg;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public short getPortataInKg() {
        return portataInKg;
    }

    public void setPortataInKg(short portataInKg) {
        this.portataInKg = portataInKg;
    }

    public short getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(short lunghezza) {
        this.lunghezza = lunghezza;
    }

    public short getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(short larghezza) {
        this.larghezza = larghezza;
    }

    public short getAltezza() {
        return altezza;
    }

    public void setAltezza(short altezza) {
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "Portata: " + portataInKg + " kg" + "\n" +
                "Lunghezza: " + lunghezza + " cm" + "\n" +
                "Larghezza: " + larghezza + " cm" + "\n" +
                "Altezza: " + altezza + " cm" + "\n";
    }
}
