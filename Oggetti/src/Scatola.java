public class Scatola extends Object { //extendens object è ridondante
    private int altezza;
    private int larghezza;

    public Scatola(int altezza, int larghezza) {
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    // alt ins - generate - getter and setter
    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public void allunga() {
        this.altezza++;
    }
    public void allarga() {
        this.larghezza++;
    }
    public void ruota() {
        int swap = this.altezza; // variabile di appoggio; altezza salvata in swap
        this.altezza = this.larghezza; // sostituzioni delle variabili
        this.larghezza = swap; // larghezza rimessa nella variabile di appoggio sennò andrebbe persa
    }

    // esiste gia in object (padre di tutti gli oggetti) e noi lo estendiamo (override)
    public String toString() {
        return "Altezza: " + this.altezza + " , Larghezza: " + this.larghezza;
    }
}
