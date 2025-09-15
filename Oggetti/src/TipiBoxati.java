public class TipiBoxati {
    public static void main(String[] args) {
        // in java tutto è un oggetto tranne gli 8 tipi di dati primitivi; esistono delle versioni a oggetto anche di questi

        int numeroIntero = 10; // tipo di dato primitivo
        Integer numeroInteroBoxato = 10;

        //essendo un oggetoo può assumere il valore speciale null
        numeroInteroBoxato = null;

        //boxing
        Integer boxatoDaValueOf = Integer.valueOf(numeroIntero);
        //unboxing
        int numeroOriginale = boxatoDaValueOf.intValue();

        //alternativa al boxing
        Integer boxingAlt = 10;
        int unboxingAlt = boxingAlt;

        Integer numero1 = 10; // Integer, per altri parametri si fa Bolean ecc
        Integer numero2 = 10;
        //== si usa con dati primitivi, mentre .equals si usa con oggeti e quindi con tipi boxati
        System.out.println(numero1.equals(numero2));
    }
}
