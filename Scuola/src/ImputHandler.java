import java.util.Scanner;

public class ImputHandler {
    private Scanner scanner;

    public ImputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public int readInt(String msg) {
        System.out.println(msg);
        while (!scanner.hasNextInt()) {
            System.out.println("Inserire un intero");
            scanner.next();
            System.out.println(msg);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public void close() {
        scanner.close();
    }
}
