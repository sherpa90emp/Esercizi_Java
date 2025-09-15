public class Animale {
    void verso() {
        System.out.println("Verso generico");
    }
}

class Cane extends Animale {
    void verso() {
        System.out.println("Bau!");
    }

    void scodinzola() {
        System.out.println("Scodinzola felice..");
    }
}

class MainCasting {
    public static void main(String[] args) {
        //upcasting
        Cane c = new Cane();
        Animale a = c;

        a.verso(); //fa bau

        //downcasting
        Animale a1 = new Cane();
        Cane c1 = (Cane) a1;

        Animale a2 = new Animale();
        if (a2 instanceof Cane) {
            System.out.println("Animale è un cane...");
            Cane c2 = (Cane) a2;
            c2.scodinzola();
        }
    }
}
