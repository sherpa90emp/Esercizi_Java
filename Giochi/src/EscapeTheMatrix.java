import java.util.Random;
import java.util.Scanner;

public class EscapeTheMatrix {
    public static void main(String[] args) {

        final int RIGHE = 5;
        final int COLONNE = 7; //costanti scritte in maiuscolo per la visibilità
        final double PERC_MURI = 0.5;

        char[][] labirinto = generaLabirintoRandom(RIGHE, COLONNE, PERC_MURI);

//        char[][] labirinto = {
//                {'S', '-', '#', '#', '-', '-', '#'},
//                {'#', '-', '-', '-', '#', '-', '#'},
//                {'-', '-', '#', '-', '-', '-', '#'},
//                {'#', '-', '-', '#', '-', '#', '#'},
//                {'-', '-', '#', '-', '-', '-', 'E'}, //trailing comma; la virgola viene messa comunque per fare modifiche future
//        };



        char simboloGiocatore = 'G';
        int rigaGiocatore = 0;
        int colonnaGiocatore = 0;

        System.out.println("Benvenuto al gico \"Escape the Matrix\"");
        System.out.println("Muoviti utilizzando i tasti WASD");

        stampaLabirinto(labirinto, simboloGiocatore, rigaGiocatore, colonnaGiocatore);

        Scanner scanner = new Scanner(System.in);
        boolean uscitaTrovata = false;
        while (!uscitaTrovata){
            System.out.print("Dove vuoi spostarti?: ");
            String mossa = scanner.nextLine().toLowerCase();
            switch (mossa){
                case "w":
                    if  (rigaGiocatore > 0 && labirinto[rigaGiocatore - 1][colonnaGiocatore] != '#')
                        rigaGiocatore--;
                    else System.out.println("Hai preso er muro fratelli!");
                    break;
                case "a":
                    if (colonnaGiocatore > 0 && labirinto[rigaGiocatore][colonnaGiocatore - 1] != '#')
                        colonnaGiocatore--;
                    else System.out.println("Hai preso er muro fratelli!");
                    break;
                case "s":
                    if (rigaGiocatore < labirinto.length - 1 && labirinto[rigaGiocatore + 1][colonnaGiocatore] != '#')
                        rigaGiocatore++;
                    else System.out.println("Hai preso er muro fratelli!");
                    break;
                case "d":
                    if (colonnaGiocatore < labirinto[0].length && labirinto[rigaGiocatore][colonnaGiocatore + 1] != '#')
                        colonnaGiocatore++;
                    else System.out.println("Hai preso er muro fratelli!");
                    break;
                default:
                    System.out.println("Mossa non valida...");
                    break;
            }
            stampaLabirinto(labirinto,simboloGiocatore,rigaGiocatore,colonnaGiocatore);

            if (labirinto[rigaGiocatore][colonnaGiocatore] == 'E'){
                uscitaTrovata = true;
                System.out.println("Bravo Moprfeus è orgoglioso di te! Sei uscito da Matrix!");
            }
        }
    }

    private static char[][] generaLabirintoRandom(int righe, int colonne, double percMuri) {
        char[][] lab = new char[righe][colonne];
        Random random = new Random();

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if (i == 0 && j == 0) lab[i][j] = 'S';
                else if (i == righe - 1 && j == colonne - 1) lab[i][j] = 'E';
                else if (i == 1 && j == 0 && lab[0][1] == '#') lab[i][j] = '-';
                else if (i == righe - 1 && j == colonne - 2 && lab[righe - 2][colonne - 1] == '#') lab[i][j] = '-';
                else {
                    if (i > 0 && lab[i-1][j] =='#') lab[i][j] = '-';
                    else if (j > 0 && lab[i][j-1] == '#') lab[i][j] = '-';
                    else if (i >= 1 && j >= 1 && lab[i - 1][j - 1] == '#') lab[i][j] = '-';
                    else if (i > 1 && j < colonne - 2 && lab[i - 1][j + 1] == '#' && lab[i - 2][j + 2] == '#') lab[i][j] = '-';
                    else if (i > 1 && j > 2 && lab[i - 1][j - 1] == '#' && lab[i - 2][j - 2] == '#') lab[i][j] = '-';
                    else lab[i][j] = random.nextDouble() < percMuri ? '#' : '-'; // se si muro se no -
                }
            }
        }
        return lab;
    }

    private static void stampaLabirinto(char[][] labirinto, char simboloGiocatore, int rigaGiocatore, int colonnaGiocatore) {
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                if (i == rigaGiocatore && j == colonnaGiocatore && labirinto[i][j] != 'S' && labirinto[i][j] != 'E')
                    System.out.print(simboloGiocatore);
                else
                    System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }
}
