public class App {
    public static void main(String[] args) {
        Scuola scuola = new Scuola();
        ImputHandler imputHandler = new ImputHandler();

        while (true) { // finchè è vero = ciclo infinito
            System.out.println("\n1. Aggiungi studente");
            System.out.println("\n2. Aggiungi insegnante");
            System.out.println("\n3. Mostra tutti");
            System.out.println("\n4. Ordina e mostra tutti");
            System.out.println("\n5. Esci");

            int scelta = imputHandler.readInt("\nInserisci scelta: ");

            try {
                switch (scelta) {
                    case 1:
                        String nome = imputHandler.readString("Inserire nome studente: ");
                        int eta = imputHandler.readInt("Inserire età studente: ");
                        String matricola = imputHandler.readString("Inserire matricola: ");
                        Persona p = new Studente(nome, eta, matricola);
                        scuola.aggiungiPersona(p);
                        break;
                    case 2:
                        String nomeIns = imputHandler.readString("Inserire nome insegnante: ");
                        int etaIns = imputHandler.readInt("Inserire età insegnante: ");
                        String materia = imputHandler.readString("Inserira materia: ");
                        Insegnante insegnante = new Insegnante(nomeIns, etaIns, materia);
                        scuola.aggiungiPersona(insegnante);
                        break;
                    case 3:
                        scuola.displayAll(null);
                        break;
                    case 4:
                        scuola.sortAndDisplay();
                        break;
                    case 5:
                        imputHandler.close();
                        return;
                    default:
                        System.out.println("Scelta non valida.");
                        break;
                }
            } catch (PersonaDuplicataException pdEx) {
                System.out.println(pdEx.getMessage());
            }
        }
    }
}
