public class DemoEccezioneCustom {
    public static void main(String[] args) {
        String nome = "Andrea";
        nome = null;
        try {
            stampaNome(nome); // si arrabbia se non gestiamo l'eccezione; possiamo passare la gestione al main
        } catch (MiaEccezione mEx) {
            System.out.println(mEx.getMessage());
        }

    }

    public static void stampaNome(String nome) throws MiaEccezione{ // dichiarazione dell'eccezione che poi andrà gestita
        if (nome == null)
            throw new MiaEccezione("Il nome non può essere null"); //va lanciata e dichiarata poichè è checked
        System.out.println("Ciao " + nome);
    }
}
