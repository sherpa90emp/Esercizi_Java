public enum TariffaGiornalieraEuro {
    LUSSO (150.99, "Tariffa giornaliera per auto di lusso"),
    UTILITARIE (20.50, "Tariffa giornaliera per utilitarie"),
    COMMERCIALI(75.85, "Tariffa giornaliera per veicoli commerciali");

    private double prezzo;
    private final String messaggio;

    TariffaGiornalieraEuro(double prezzo, String messaggio) {
        this.prezzo = prezzo;
        this.messaggio = messaggio;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getMessaggio() {
        return messaggio;
    }
}
