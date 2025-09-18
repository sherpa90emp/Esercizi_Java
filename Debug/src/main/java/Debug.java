public class Debug {
    public static final boolean DEBUG = true;

    public static final String TAG ="[DEBUG]";

    public static void println(String message){
        if(DEBUG) System.out.println( TAG+ message);
    }

    public static void print(String message){
        if(DEBUG) System.out.print(TAG + message);
    }
}
