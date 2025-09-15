public class Motocicletta extends Veicolo {
    private int numeroTempiMotore;

    public Motocicletta(int annoImmatricolazione, String marca, String tipoAlimentazione, int cilindrata, int numeroTempiMotore) {
        super(annoImmatricolazione, marca, tipoAlimentazione, cilindrata);
        this.numeroTempiMotore = numeroTempiMotore;
    }

    public int getNumeroTempiMotore() {
        return numeroTempiMotore;
    }

    public void setNumeroTempiMotore(int numeroTempiMotore) {
        this.numeroTempiMotore = numeroTempiMotore;
    }

    @Override
    public String toString() {
        return super.toString() + " - Motocicletta{" +
                "numeroTempiMotore=" + numeroTempiMotore +
                '}';
    }
}
