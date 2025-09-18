// Un oggetto che stampa con diversi livelli di log con colori diversi (https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797)
// Strutturato come Singleton (pattern), esiste una sola e unica istanza di questa classe

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.String.valueOf;

public final class Logger {

    public static String fileColor;

    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_RESET = "\u001b[0m";

    public enum LogLevel {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    // Unica istanza possibile di Logger, i client usano questo tramite il metodo getInstance()
    private static final Logger sole_instance = new Logger();
    private static boolean enable = true; // Abilita i log
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Il costruttore privato evita l'uso di new al di fuori di questa classe
    private Logger() {
    }

    // Metodo che permette di averer una istanza
    public static Logger getInstance(){
        return sole_instance;
    }

    public void info(String messagge){
        log(messagge, ANSI_BLUE, valueOf(LogLevel.INFO), enable);
    }

    public void debug(String messagge){
        log(messagge, ANSI_GREEN, valueOf(LogLevel.DEBUG), enable);
    }

    public void warn(String messagge){
        log(messagge, ANSI_YELLOW, valueOf(LogLevel.WARNING), enable);
    }

    public void error(String messagge){
        log(messagge, ANSI_RED, valueOf(LogLevel.ERROR), enable);
    }

    private void log(String message, String colore, String tag, boolean currentEnable) {
        if(!currentEnable) return; // TODO [base] evolvi per poter disabilitare ogni livello
        // TODO [media] prendere livelli da file
        // TODO [avanzato] creare diversi livelli leggendo da file

        // debug - true - \u001B[33m



        String timestamp = dtf.format(LocalDateTime.now());

        System.out.println(
                colore +
                        "[" +  timestamp + "] - " +
                        "[" + tag + "] " +
                        message +
                        ANSI_RESET
        );
    }

    public  void log(CustomLogLevel logLevel, String message){
        log(message, logLevel.getColor(), logLevel.getLevel(), logLevel.isActivation());
    }

}
