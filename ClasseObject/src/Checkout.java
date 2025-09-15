public class Checkout {
    public static void main(String[] args) {
        MetodoPagamento metodo1 = new CartaDiCredito();
        MetodoPagamento metodo2 = new BonificoBancario();
        MetodoPagamento metodo3 = new PayPall();

        metodo1.paga(9.99);
        metodo2.paga(4.99);
        metodo3.paga(12.99);
    }
}
