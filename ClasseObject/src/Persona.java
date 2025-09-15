public class Persona {
    //NON SI FA > String nome;
    String nome;

    @Override
    public String toString() {
        return "Persona" + nome;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true; // Il riferimento in memoria è lo stesso
        if(!(obj instanceof Persona)) return false;
        Persona altra = (Persona) obj;
        return this.nome.equals(altra.nome); // && this.eta == altra.eta;
    }

    @Override
    public int hashCode(){
        return nome.hashCode();
    }

    class Main {
        public static void main(String[] args){
            Persona p = new Persona();
            p.nome = "Giuseppe";
            System.out.println(p);

            Persona p1 = new Persona();
            p1.nome = "Mario";
            Persona p2 = new Persona();
            p2.nome = "Luigi";
            System.out.println("p1 è uguale a p2? " + p1.equals(p2));
            System.out.println(p1.equals("Mario"));
            System.out.println(p1.equals(null));
            Persona p4 = p1;
            System.out.println(p1.equals(p4));

            System.out.println("Hash di p: " + p.hashCode());
            System.out.println("Hash di p4: " + p4.hashCode());
        }
    }
}
