public class CartaDiCredito  implements MetodoPagamento{ //con implements si deve sempre implementare il metodo dichiarato nella interfaccia
    @Override
    public void paga(double importo) { // è un metodo astratto a tutti gli effetti
        System.out.println("Striscio carta e pago euro " + importo);
    }
}
