public class GestoreVeicoli {
    private static final int NUM_VEICOLI = 100;
    private Veicolo[] veicoli;

    public GestoreVeicoli() {
        veicoli = new Veicolo[NUM_VEICOLI];
    }

    public void stampaListaVeicoli() {
        String returnedValue = "";
        for (int i = 0; i < veicoli.length; i++) {
            if (veicoli[i] != null) {
                returnedValue += veicoli[i].toString() + "\n"; // se avessi messo  = avrebbe sovrasritto ogni volta
            }
        }
        if (returnedValue.isEmpty()) System.out.println("Nessun veicolo registrato.");
        else System.out.println(returnedValue);
    }

    public void registraAutovettura(Autovettura autovettura) {
        for (int i = 0; i < veicoli.length; i++) {
            if (veicoli[i] == null) {
                veicoli[i] = autovettura;
                return;
            }
        }
    }

    public void registraFurgone(Furgone furgone) {
        for (int i = 0; i < veicoli.length; i++) {
            if (veicoli[i] == null) {
                veicoli[i] = furgone;
                return;
            }
        }
    }

    public void stampaListaVeicoliIndicizzata() {
        String returnedValue = "";
        for (int i = 0; i < veicoli.length; i++) {
            if (veicoli[i] != null) {
                returnedValue += (i + 1) + "\n" + veicoli[i].toString() + "\n";
            }
        }
        if (returnedValue.isEmpty()) System.out.println("Nessun cliente registrato.");
        else System.out.println(returnedValue);
    }

    public Veicolo estraiVeicolo(int input) {
        if (input < 0 || input > NUM_VEICOLI)
            return null;
        Veicolo veicoloDaEstrarre = veicoli[input];
        return veicoloDaEstrarre;
    }
}
