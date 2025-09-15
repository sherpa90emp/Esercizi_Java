public class Matrici {
    public static void main(String[] args) {
        // una matrice è un array a due dimensioni
        // un array i quali elementi sono a loro volta array

        int numeroRighe = 3;
        int numeroColonne = 3;

        int[][] matrice = new int[numeroRighe][numeroColonne]; //prima si inserisce la riga poi la colonna

        int counter = 0;

        for (int riga = 0; riga < matrice.length; riga++) { //ccrea un riga per ciclo fino al massimo della numero di righe (length)
            for (int colonna = 0; colonna < matrice[0].length ; colonna++) { // ad ogni riga creata crea anche la colonna fino al numero di colonne massime possibili
                matrice[riga][colonna] = ++counter;
            }
        }
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.println(matrice[i][j] + " ");
            }
            System.out.println(); //con questo stampiamo la matrice, con il for precedente abbiamo creato la matrice
        }
    }
}
