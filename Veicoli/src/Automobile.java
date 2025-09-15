public class Automobile extends Veicolo {
    private int numPorte;

    public Automobile(int annoImmatricolazione, String marca, String tipoAlimentazione, int cilindrata, int numPorte) {
        super(annoImmatricolazione, marca, tipoAlimentazione, cilindrata);
        this.numPorte = numPorte;
    }

    public int getNumPorte() {
        return numPorte;
    }

    public void setNumPorte(int numPorte) {
        this.numPorte = numPorte;
    }

    @Override
    public String toString() {
        return super.toString() + " - Automobile{" +
                "numPorte=" + numPorte +
                '}';
    }
}
