import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {

        GestoreVeicoli gestoreVeicoli = new GestoreVeicoli();
        GestoreClienti gestoreClienti = new GestoreClienti();
        GestoreNoleggi gestoreNoleggi = new GestoreNoleggi();

        System.out.println("*** GESTIONALE AUTOLONEGGIO LUGLI ***");

        Scanner scanner = new Scanner(System.in);
        byte operazione;


        do {
            stampaMenu();
            System.out.print("Selezionare una operazione: ");
            operazione = scanner.nextByte();
            scanner.nextLine();
            if (operazione == 0)
                break;
            else if (operazione < 0 || operazione > 7) {
                System.out.print("Voce non presente nel menù. Selezionare la voce corretta!");
            } else if (operazione == 1) {
                Autovettura autovettura = stampaRegistrazioneAutovettura(scanner);
                gestoreVeicoli.registraAutovettura(autovettura);
            } else if (operazione == 2) {
                Furgone furgone = stampaRegistrazioneFurgone(scanner);
                gestoreVeicoli.registraFurgone(furgone);
            } else if (operazione == 3) {
                Cliente cliente = stampaRegistrazioneCliente(scanner);
                gestoreClienti.registraCliente(cliente);
            } else if (operazione == 4) {
                Noleggio noleggio = stampaRegistrazioneNoleggi(scanner, gestoreClienti, gestoreVeicoli);
                gestoreNoleggi.registraNoleggio(noleggio);
            } else if (operazione == 5) {
                gestoreVeicoli.stampaListaVeicoli();
                tornaAlMenu(scanner);
            } else if (operazione == 6) {
                gestoreClienti.stampaListaClienti();
                tornaAlMenu(scanner);
            } else if (operazione == 7) {
                gestoreNoleggi.stampaListaNoleggi();
                tornaAlMenu(scanner);
            }
        }
        while (true);
        System.out.println("Arrivederci!");
    }

    public static void stampaMenu() {
        System.out.println("Menù del gestionale Autonoleggio Lugli, cosa desideri fare?");
        System.out.println("1 - Registra Autovettura");
        System.out.println("2 - Registra Furgone");
        System.out.println("3 - Registra Cliente");
        System.out.println("4 - Registra Noleggio");
        System.out.println("5 - Lista Veicoli");
        System.out.println("6 - Lista Clienti");
        System.out.println("7 - Lista Noleggi");
        System.out.println("0 - Esci");
    }

    public static void tornaAlMenu(Scanner scanner) {
        System.out.println("Se si desidera tornare al menù del gestionale premere INVIO");
        scanner.nextLine();
    }

    public static Autovettura stampaRegistrazioneAutovettura(Scanner scanner) {
        System.out.println("*** REGISTRAZIONE AUTOVETTURA ***");
        System.out.println("Selezionare la marca tra: IVECO, FIAT, DACIA, FORD, BMW, FERRARI, AUDI, JEEP, PEUGEUT, RENAULT, OPEL, SKODA");
        System.out.println("Inserire una marca: ");
        String marca = scanner.nextLine().toUpperCase();
        System.out.println("Inserire il modello: ");
        String modello = scanner.nextLine();
        System.out.println("Inserire il numero di targa: ");
        String targa = scanner.nextLine().toUpperCase();
        System.out.println("Selezionare una tariffa giornaliera tra:");
        System.out.println("Lusso");
        System.out.println("Utilitarie");
        System.out.println("Commerciali");
        System.out.println("Scrivera la tariffa da applicare: ");
        String tariffa = scanner.nextLine().toUpperCase();
        System.out.println("Inserire il numero di porte: ");
        byte numeroPorte = scanner.nextByte();
        System.out.println("Inserire il numero di posti: ");
        byte numeroPosti = scanner.nextByte();
        scanner.nextLine();


        return new Autovettura (Marche.valueOf(marca), modello, targa, TariffaGiornalieraEuro.valueOf(tariffa), numeroPorte, numeroPosti);
    }

    public static Furgone stampaRegistrazioneFurgone(Scanner scanner) {
        System.out.println("*** REGISTRAZIONE Furgone ***");
        System.out.println("Selezionare la marca tra: IVECO, FIAT, DACIA, FORD, BMW, FERRARI, AUDI, JEEP, PEUGEUT, RENAULT, OPEL, SKODA");
        System.out.println("Inserire una marca: ");
        String marca = scanner.nextLine().toUpperCase();
        System.out.println("Inserire il modello: ");
        String modello = scanner.nextLine();
        System.out.println("Inserire il numero di targa: ");
        String targa = scanner.nextLine().toUpperCase();
        System.out.println("Selezionare una tariffa giornaliera tra:");
        System.out.println("Lusso");
        System.out.println("Utilitarie");
        System.out.println("Commerciali");
        System.out.println("Scrivera la tariffa da applicare: ");
        String tariffa = scanner.nextLine().toUpperCase();
        System.out.println("Inserire la portata in kg: ");
        short portataKg = scanner.nextShort();
        System.out.println("Inserire la lunghezza in cm: ");
        short lunghezza = scanner.nextShort();
        System.out.println("Inserire la larghezza in cm: ");
        short larghezza = scanner.nextShort();
        System.out.println("Inserire l'altezza in cm: ");
        short altezza = scanner.nextShort();
        scanner.nextLine();


        return new Furgone(Marche.valueOf(marca), modello, targa, TariffaGiornalieraEuro.valueOf(tariffa), portataKg, lunghezza, larghezza, altezza);
    }

    public static Cliente stampaRegistrazioneCliente(Scanner scanner) {
        System.out.println("*** REGISTRAZIONE CLIENTE ***");
        System.out.println("Inserire il nome: ");
        String nome = scanner.nextLine();
        System.out.println("Inserire il cognome: ");
        String cognome = scanner.nextLine();
        System.out.println("Inserire il numero della patente: ");
        String numeroPatente = scanner.nextLine().toUpperCase();

        return new Cliente(nome, cognome, numeroPatente);
    }

    public static Noleggio stampaRegistrazioneNoleggi(Scanner scanner, GestoreClienti gestoreClienti, GestoreVeicoli gestoreVeicoli) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("*** REGISTRAZIONE NOLEGGI ***");
        System.out.print("Inserire data di inizio noleggio (aaaa-mm-gg): ");
        LocalDate dataInizioNoleggio = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Inserire data di fine noleggio (aaaa-mm-gg): ");
        LocalDate dataFineNoleggio = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Lista veicoli:");
        gestoreVeicoli.stampaListaVeicoliIndicizzata();
        System.out.println("Scegliere il veicolo da noleggiare: ");
        int sceltaVeicolo = Integer.parseInt(scanner.nextLine()) - 1;
        Veicolo veicolo = gestoreVeicoli.estraiVeicolo(sceltaVeicolo);
        System.out.println("Lista clienti:");
        gestoreClienti.stampaListaClientiIndicizzata();
        System.out.println("Scegliere il cliente che ha noleggiato il veicolo: ");
        int sceltaCliente = Integer.parseInt(scanner.nextLine()) - 1;
        Cliente cliente = gestoreClienti.estraiCliente(sceltaCliente);



        return new Noleggio (dataInizioNoleggio, dataFineNoleggio, cliente, veicolo);
    }
}

