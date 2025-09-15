public class PayPall implements MetodoPagamento{
    @Override
    public void paga(double importo) {
        System.out.println("Pagato tramite paypal un importo di: " + importo);
    }
}
