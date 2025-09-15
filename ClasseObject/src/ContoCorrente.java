public class ContoCorrente {
    private double euro;
    private double dollaro;
    private static final double CAMBIO = 0.85;

    public ContoCorrente(double euro, double dollaro){
        this.euro = euro;
        this.dollaro = dollaro;
    }

    // Getter
    public double getEuro(){
        return euro;
    }

    // Getter
    public double getDollaro(){
        return dollaro;
    }

    // setter
    public void setEuro(double euro){
        this.euro = euro;
    }

    // setter
    public void setDollaro(double dollaro){
        this.dollaro = dollaro;
    }

    // aggiungi euro
    // aggiungi dollaro
    // preleva euro
    // preleva dollaro
    // saldo totale euro
    // alVerde

    public void aggiungiEuro(double q){
        this.euro +=q;
    }

    public void aggiungiDollaro(double q){
        this.dollaro +=q;
    }

    public void prelevaEuro(double q){
        if(this.euro-q >= 0) this.euro -=q;
        else System.out.println("Non c'é abbastanza disponibilità");
    }

    public void prelevaDollaro(double q){
        if(this.dollaro-q >= 0) this.dollaro -=q;
        else System.out.println("Non c'é abbastanza disponibilità");
    }

    public double saldoTotale(){
        // Trasforma dollari in euro
        return this.euro+ (this.dollaro* CAMBIO);
    }

    public boolean alverde(){
        return this.saldoTotale() <= 0;
    }
}
