import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        // creiamo una istanza di persona
        Persona p1 = new Persona();
        byte eta = 36;
        Persona p2 = new Persona("Giuseppe", eta);
        System.out.println(p2.getNome());
        p2.setNome("Mario");
        System.out.println(p2.getNome());
        p1.setNome("Antonio");
        System.out.println(p1.saluta(p2));
        p2.compiAnni();
        System.out.println(p2.getEta());

        // creo una istanza di contocorrente
        ContoCorrente cc = new ContoCorrente(1000, 1000);
        cc.aggiungiDollaro(100);
        cc.aggiungiEuro(230);
        cc.prelevaEuro(50);
        cc.prelevaDollaro(23);
        System.out.println(cc.saldoTotale());
        System.out.println(cc.alVerde());

        System.out.println(cc.getEuro());
        System.out.println(cc.getDollaro());
        cc.prelevaDollaro(1077.0);
        cc.prelevaEuro(1180.0);
        System.out.println(cc.alVerde());

        Scatola s1 = new Scatola(13, 17);
        s1.allunga();
        s1.allunga();
        s1.allarga();
        s1.allarga();
        s1.allarga();
        System.out.println(s1);
        s1.ruota();
        System.out.println(s1);

        System.out.println(p2);

        LocalDate now = LocalDate.now();
        System.out.println(now);

        Alimentare pecorinoRomano = new Alimentare( "ASDlol1", "Del formaggio", 10, LocalDate.of(2025, Month.JULY, 27));

        Alimentare yogurt = new Alimentare("ASDlol2", "Yogurt", 10, LocalDate.of(2026, Month.JULY, 25));

        NonAlimentare sediaSdraio = new NonAlimentare("SEDlol2", "Sedia bianca mare", 10, Materiale.PLASTICA);

        NonAlimentare tegola = new NonAlimentare("TEGlol2", "tegola", 10, Materiale.ETERNIT);

        pecorinoRomano.applicaSconto();
        System.out.println(pecorinoRomano.getPrezzo());
        yogurt.applicaSconto();
        System.out.println(yogurt.getPrezzo());
        sediaSdraio.applicaSconto();
        System.out.println(sediaSdraio.getPrezzo());
        tegola.applicaSconto();
        System.out.println(tegola.getPrezzo());

        Ticket ticket1 = new Ticket( "Problema con login", Priorita.ALTA);
        Ticket ticket2 = new Ticket("Richiesta info", Priorita.BASSA);
        ticket1.descrizionePriorita();
        ticket2.descrizionePriorita();


    }
}
