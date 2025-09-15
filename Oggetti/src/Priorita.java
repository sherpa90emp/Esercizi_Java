public enum Priorita {
    BASSA(1, "Risposta entro 48 ore"),    //enum a cui sono anche assegnate delle proprietà
    MEDIA(2, "Risposta entro 24 ore"),
    ALTA(3, "Risposta immediata");

    private final int livello;
    private final String messaggio;

    Priorita(int livello, String messaggio) {
        this.livello = livello;
        this.messaggio = messaggio;
    }
    public int getLivello() {
        return livello;
    }
    public String getMessaggio() {
        return messaggio;
    }
}
