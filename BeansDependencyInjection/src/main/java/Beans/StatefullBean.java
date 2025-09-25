package Beans;

//bean che mantiene lo stato
public class StatefullBean {
    private int contatore = 0;

    //incrementa il contatore di uno
    public void incremento() {
        contatore++;
        System.out.println("StatefullBean: contatore incrementato a " + contatore);
    }

    //legge lo stato del contatore
    public int getContatore() {
        return contatore;
    }
}
