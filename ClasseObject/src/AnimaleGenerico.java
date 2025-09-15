public abstract class AnimaleGenerico {
    // metodo concreto
    void dormi() {
        System.out.println("Zzzzz...");
    }

    // metodo astratto senza corpo
    abstract void verso();
}

// classe concreta estende la classe abstract
class CaneConcreto extends AnimaleGenerico { //sarà sottolineate di rosso fino a che non implementeremo il metodo verso, poicheè è obbligatorio per la classe che estende la classe astratta
    @Override
    void verso() {
        System.out.println("Bau!");
    }
}

class MainAstratta {
    public static void main(String[] args) {
        //non si può fare è astratto
        //AnimaleGenerico animaleGenerico = new AnimaleGenerico();
        AnimaleGenerico animale = new CaneConcreto();
        animale.dormi();
        animale.verso();
    }
}
