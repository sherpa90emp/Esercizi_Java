public class Garage {
    private static final int NUM_POSTI = 15;
    private Veicolo[] veicoli;

    public Garage() {
        veicoli = new Veicolo[NUM_POSTI];
    }

    // metodo per inserire veicoli nel garage
    public void inserisciVeicolo(Veicolo veicolo) { //void perchè non ci da nulla, inserisce e basta
        for (int i = 0; i < veicoli.length; i++) {
            if(veicoli[i] == null) {
                veicoli[i] = veicolo;
                return; //quando inserisce il veicolo riparte in ricerca di un altro posto
            }
        }
        System.out.println("Nessun posto disponibile."); // se non ritrova posti liberi ci dice che sono finiti i posti
    }

    //estrarre un veicolo dal garage tramite il posto (intero che rappresenta indice array +1)
    public Veicolo estraiVeicolo(int posto) {
        if (posto < 1 || posto > NUM_POSTI)
            return null;
        Veicolo veicoloDaEstrarre = veicoli[posto - 1];
        veicoli[posto - 1 ] = null;
        return veicoloDaEstrarre;
    }

    public void stampa() {
        String retvalue = "";
        for (int i = 0; i < veicoli.length; i++) {
            retvalue += "Posto n°: " + (i + 1) + " - ";
            if (veicoli[i] == null) retvalue += "vuoto";
            else retvalue += veicoli[i].getClass().getSimpleName();
            retvalue += "\n";
        }
        System.out.println(retvalue);
    }
}
