import java.util.Arrays;

public class Scuola {
    private  Persona[] persone = new Persona[10];

    public void aggiungiPersona(Persona p) throws PersonaDuplicataException {

        int indexP = -1; // gli diamo un valore negativo (che non può esistere all'interno dell'array)
        for (int i = 0; i < persone.length; i++) {
            if (persone[i] != null && persone[i].equals(p)) { //controlla se già esiste la persona nell'array; se la trova la lettura del codice si ferma e torna all'inizio
                throw new PersonaDuplicataException("Ti sei già iscritto");
            }
            if (persone[i] == null) { //segna un indice di posizione vuota nell'array
                indexP = i;
            }
        }
        if (indexP > -1) // se l'indice è "legale" allora inserisce la persona
            persone[indexP] = p;
    }

    public void displayAll(Persona[] array) {
        if (array == null)
            array = persone;

        for (Persona p : persone) //ciclo for enanched
            if (p != null) //fai il display di tutto ciò che è diverso da null
                p.display();
    }

    public void sortAndDisplay() {

        int count = 0;
        for (int i = 0; i < persone.length; i++)
            if (persone[i] != null)
                count++;

        Persona[] personaNonNulle = new Persona[count]; //creo nuovo array e ci copio le persone non nulle
        int j = 0;
        for (int i = 0; i < persone.length; i++)
            if (persone[i] != null)
                personaNonNulle[j++] = persone[i];

        Arrays.sort(personaNonNulle); //ordina l'array grazie all'implementazione della interface comparable in Persona e della successiva dichiarazione del metodo compareTo (override)
        displayAll(personaNonNulle);
    }
}
