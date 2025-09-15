public abstract class Persona implements Displayable, Comparable<Persona> {
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public abstract void display();

    @Override
    public int compareTo(Persona altro) {
        return Integer.compare(this.eta, altro.eta);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) return false;
        Persona p = (Persona) o;
        return  this.nome.equals(p.nome);
    }
}
