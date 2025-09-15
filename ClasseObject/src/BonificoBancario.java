public class BonificoBancario implements MetodoPagamento{ //oppure è possibile dichiararla astratta e non dichiarare il metodo

    @Override
    public void paga(double importo) {
        System.out.println("Bonifico inviato di euro: " + importo);
    }
}
