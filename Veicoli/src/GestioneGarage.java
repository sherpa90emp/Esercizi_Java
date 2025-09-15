public class GestioneGarage {
    public static void main(String[] args) {
        Garage garage = new Garage();

        Automobile automobile = new Automobile(1999, "Fiat", "Benzina", 100, 5);
        Furgoone furgoone = new Furgoone(2005, "Fiat", "Diesel", 1300, 1200);
        Motocicletta motocicletta = new Motocicletta(1953, "Piaggio", "Miscela", 125, 2);

        garage.stampa();
        garage.inserisciVeicolo(automobile);
        garage.inserisciVeicolo(furgoone);
        garage.inserisciVeicolo(motocicletta);
        garage.stampa();

        garage.estraiVeicolo(1);
        garage.stampa(); 
    }
}
