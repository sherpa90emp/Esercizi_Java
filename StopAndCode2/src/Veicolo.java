public class Veicolo {
    private Marche marca;
    private String modello;
    private String numeroDiTarga;
    private TariffaGiornalieraEuro tariffaGiornalieraEuro;

    public Veicolo(Marche marca, String modello, String numeroDiTarga, TariffaGiornalieraEuro tariffaGiornalieraEuro) {
        this.marca = marca;
        this.modello = maiuscoloPrimaLettera(modello);
        this.numeroDiTarga = numeroDiTarga;
        this.tariffaGiornalieraEuro = tariffaGiornalieraEuro;
    }

    public Marche getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getNumeroDiTarga() {
        return numeroDiTarga;
    }

    public TariffaGiornalieraEuro getTariffaGiornalieraEuro() {
        return tariffaGiornalieraEuro;
    }

    public void setTariffaGiornalieraEuro(TariffaGiornalieraEuro tariffaGiornalieraEuro) {
        this.tariffaGiornalieraEuro = tariffaGiornalieraEuro;
    }

    public void setMarca(Marche marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setNumeroDiTarga(String numeroDiTarga) {
        this.numeroDiTarga = numeroDiTarga;
    }

    @Override
    public String toString() {
        return  "Marca: " + marca + "\n" +
                "Modello: " + modello + "\n" +
                "Numero di targa: " + numeroDiTarga + "\n" +
                "Tariffa giornaliera: " + tariffaGiornalieraEuro.getPrezzo() + " €" + "\n";
    }

    public static String maiuscoloPrimaLettera(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
