public class EsercizioOtto {
    public static void main(String[] args) {
        String ciao = "Ciao Mondo";
        System.out.println(ciao.indexOf("o"));
        if ((ciao.indexOf("o")) % 2 == 0) {
            System.out.println("Si, e' un numero pari");
        } else {
            System.out.println("No, non e' un numero pari");
        }
    }
}
