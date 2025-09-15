public class GestoreClienti {
    private static final int NUM_CLIENTI = 100;
    private Cliente[] clienti;

    public GestoreClienti() {
        clienti = new Cliente[NUM_CLIENTI];
    }

    public void registraCliente(Cliente cliente) {
        for (int i = 0; i < clienti.length; i++) {
            if (clienti[i] == null) {
                clienti[i] = cliente;
                return;
            }
        }
    }

    public void stampaListaClienti() {
        String returnedValue = "";
        for (int i = 0; i < clienti.length; i++) {
            if (clienti[i] != null) {
                returnedValue += clienti[i].toString() + "\n";
            }
        }
        if (returnedValue.isEmpty()) System.out.println("Nessun cliente registrato.");
        else System.out.println(returnedValue);
    }

    public void stampaListaClientiIndicizzata() {
        String returnedValue = "";
        for (int i = 0; i < clienti.length; i++) {
            if (clienti[i] != null) {
                returnedValue += (i + 1) + "\n" + clienti[i].toString() + "\n";
            }
        }
        if (returnedValue.isEmpty()) System.out.println("Nessun cliente registrato.");
        else System.out.println(returnedValue);
    }

    public Cliente estraiCliente(int index) {
        if (index < 0 || index > NUM_CLIENTI )
            return null;
        Cliente clienteDaEstrarre = clienti[index];
        return clienteDaEstrarre;
    }
}
