public class Calcolatrice {
    public int somma(int a, int b){
        Debug.println("Sono qui! Dentro somma con valori a=" + a + " b=" +b);
        return a +b;
    }

    public int sottrazione(int a, int b){
        Debug.println("Sono qui! Dentro sottrazione con valori a=" + a + " b=" +b);
        return a-b;
    }

    public int moltiplicazione(int a, int b){
        Debug.println("Sono qui! Dentro moltiplicazione con valori a=" + a + " b=" +b);
        return a*b;
    }

    public double divisione(int a, int b){
        System.out.println("Sono qui! Dentro divisione con valori a=" + a + " b=" +b);
        Debug.println("Attenzione, divisione per zero");
        return (double) a/b;
    }
}
