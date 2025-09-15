public class Insegnante extends Persona {
    private String materia;

    public Insegnante(String nome, int eta, String matera) {
        super(nome, eta);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMatera(String materia) {
        this.materia = materia;
    }

    @Override
    public void display() {
        System.out.println("Nome: " + getNome() + ", età: " + getEta() + ", materia: " + getMateria());
    }
}
