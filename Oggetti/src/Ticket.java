public class Ticket {
    private String titolo;
    private Priorita priorita;

    public Ticket(String titolo, Priorita priorita) {
        this.titolo = titolo;
        this.priorita = priorita;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Priorita getPriorita() {
        return priorita;
    }

    public void setPriorita(Priorita priorita) {
        this.priorita = priorita;
    }

    public void  descrizionePriorita() {
        System.out.println(titolo + " - Priorità: " + priorita.name() + ", " + priorita.getMessaggio());
    }
}
