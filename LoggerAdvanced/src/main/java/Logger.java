// Un oggetto che stampa con diversi livelli di log con colori diversi (https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797)
// Strutturato come Singleton (pattern), esiste una sola e unica istanza di questa classe

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.String.valueOf;

/**
 * Un oggetto che stampa con diversi livelli di log con colori diversi
 * Strutturato come Singleton (pattern), esiste una sola e unica istanza di questa classe
 */

public final class Logger {

    /**
     * Escape code ANSI per colore verde
     */
    public static final String ANSI_GREEN = "\u001b[32m";
    /**
     * Escape code ANSI per colore blue
     */
    public static final String ANSI_BLUE = "\u001b[34m";
    /**
     * Escape code ANSI per colore giallo
     */
    public static final String ANSI_YELLOW = "\u001b[33m";
    /**
     * Escape code ANSI per colore rosso
     */
    public static final String ANSI_RED = "\u001b[31m";
    /**
     * Escape code ANSI per reset colore
     */
    public static final String ANSI_RESET = "\u001b[0m";

    /**
     * Enumm che rappresenta i diversi livelli di log
     * Comprende DEBUG, INFO, WARNING, ERROR
     */
    public enum LogLevel {

        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    /**
     * Unica istanza possibile di Logger, i client usano questo tramite il metodo getInstance()
     */
    private static final Logger sole_instance = new Logger();
    private static boolean enable = true; // Abilita i log
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Il costruttore privato evita l'uso di new al di fuori di questa classe
     */
    private Logger() {
    }

    /**
     * Ritorna l'unica istanza della classe Logger
     *
     * @return L'istanza Singleton del Logger.
     */

    public static Logger getInstance() {
        return sole_instance;
    }

    /**
     * Logga un messaggio di livello INFO
     *
     * @param  message Il messaggio da scrivere nei log.
     */
    public void info(String message) {
        log(message, ANSI_BLUE, valueOf(LogLevel.INFO));
    }
    /**
     * Logga un messaggio di livello DEBUG
     *
     * @param  message Il messaggio da scrivere nei log.
     */
    public void debug(String message) {
        log(message, ANSI_GREEN, valueOf(LogLevel.DEBUG));
    }
    /**
     * Logga un messaggio di livello WARNING
     *
     * @param  message Il messaggio da scrivere nei log.
     */
    public void warn(String message) {
        log(message, ANSI_YELLOW, valueOf(LogLevel.WARNING));
    }

    /**
     * Logga un messaggio di livello ERROR
     *
     * @param  message Il messaggio da scrivere nei log.
     */
    public void error(String message) {
        log(message, ANSI_RED, valueOf(LogLevel.ERROR));
    }

    /**
     * Il metodo di stampa principale. Prende un messaggio del colore deciso
     * e mette come prefisso un determinato TAG.
     *
     * @param message Il messaggio da salvare in stringa
     * @param colore Il colore del messaggio in formato ANSI Unicode
     * @param tag Il tag da anteporre al messaggio
     */
    private void log(String message, String colore, String tag) {
        if (!enable) return; // TODO [base] evolvi per poter disabilitare ogni livello
        // TODO [media] prendere livelli da file
        // TODO [avanzato] creare diversi livelli leggendo da file

        // debug - true - \u001B[33m


        String timestamp = dtf.format(LocalDateTime.now());

        System.out.println(
                colore +
                        "[" + timestamp + "] - " +
                        "[" + tag + "] " +
                        message +
                        ANSI_RESET
        );
    }

}
