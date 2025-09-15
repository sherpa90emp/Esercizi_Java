public class ContoCorrente {

    //variabili di istanza
    private double euro;
    private double dollaro;
    private static final double CAMBIO = 0.85;

    //costruttore
    public ContoCorrente(double euro, double dollaro) {
        this.euro = euro;
        this.dollaro = dollaro;
    }

    public double getEuro() {
        return euro;
    }
    public double getDollaro() {
        return dollaro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }
    public void setDollaro(double dollaro) {
        this.dollaro = dollaro;
    }

    public void aggiungiEuro(double q) {
        this.euro += q;
    }
    public void aggiungiDollaro(double q) {
        this.dollaro += q;
    }
    public void prelevaEuro(double q) {
        if (this.euro >= q) this.euro -= q;
    }
    public void prelevaDollaro(double q) {
        if (this.dollaro >= q) this.dollaro -= q;
    }
    public double saldoTotale() {
        return this.euro + (this.dollaro * CAMBIO);
    }
    public boolean alVerde() {
        return saldoTotale() <= 0;
        //return this.euro == 0 && this.dollaro == 0;
    }
}
