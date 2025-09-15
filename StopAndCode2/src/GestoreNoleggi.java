public class GestoreNoleggi {
    private static final int NUM_NOLEGGI = 100;
    private Noleggio[] noleggi;

    public GestoreNoleggi() {
        noleggi = new Noleggio[NUM_NOLEGGI];
    }

    public void registraNoleggio(Noleggio noleggio) {
        for (int i = 0; i < noleggi.length; i++) {
            if (noleggi[i] == null) {
                noleggi[i] = noleggio;
                return;
            }
        }
    }

    public void stampaListaNoleggi() {
        String returnedValue = "";
        for (int i = 0; i < noleggi.length; i++) {
            if (noleggi[i] != null) {
                returnedValue += noleggi[i].toString() + "\n";
            }
        }
        if (returnedValue.isEmpty()) System.out.println("Nessun contratto di noleggio registrato.");
        else System.out.println(returnedValue);
    }
}
