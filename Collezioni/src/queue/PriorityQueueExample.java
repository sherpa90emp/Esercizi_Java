package queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        simulaProntoSoccorso();;
    }

    public static void simulaProntoSoccorso() {
        Queue<Paziente> prontoSoccorso = new PriorityQueue<>(new Comparator<Paziente>() {
            @Override
            public int compare(Paziente p1, Paziente p2) {
                int res = Integer.compare(p1.codiceTriage, p2.codiceTriage);
                if (res == 0) return Long.compare(p1.oraArrivo, p2.oraArrivo);
                return res;
            }
        });

        //arrivo dei pazienti
        long tempo = System.currentTimeMillis() / 1000;
        prontoSoccorso.offer(new Paziente("Mario Rossi", 3, tempo++)); //al tempo si aggiunge un secondo
        prontoSoccorso.offer(new Paziente("Anna Verdi", 1, tempo++));
        prontoSoccorso.offer(new Paziente("Luigi Blu", 4, tempo++));
        prontoSoccorso.offer(new Paziente("Carla Neri", 2, tempo++));
        prontoSoccorso.offer(new Paziente("Paolo Gialli", 1, tempo));

        System.out.println("Pazienti in attesa: " + prontoSoccorso.size());

        int numeroChiamata = 1;
        while (!prontoSoccorso.isEmpty()) {
            Paziente paziente = prontoSoccorso.poll();
            System.out.println(numeroChiamata);
        }
    }
}

class Paziente {
    String nome;
    int codiceTriage; // 1 = rosso; 2 = arancione; 3 = giallo; 4 = verde; 5 = bianco;
    long oraArrivo;

    public Paziente(String nome, int codiceTriage, long oraArrivo) {
        this.nome = nome;
        this.codiceTriage = codiceTriage;
        this.oraArrivo = oraArrivo;
    }

    @Override
    public String toString() {
        String[] colori = {"", "ROSSO", "ARANCIONE", "GIALLO", "VERDE", "BIANCO"};
        return  nome + " [" + colori[codiceTriage] + "]";
    }
}
