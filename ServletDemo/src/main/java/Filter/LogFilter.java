package Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

// una classe Filter che può intercettare richieste e risposte HTTP per trasformare o ispezionare le informazioni di intestazione e corpo
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Pre processing
        long startTime = System.currentTimeMillis(); // prendo il tempo iniziale
        HttpServletRequest request = (HttpServletRequest) servletRequest; // cast a HttpServletRequest
        System.out.println("-----");
        System.out.println("Request path: " + request.getRequestURI()); // recupero uri della richiesta
        System.out.println("Request method: " + request.getMethod()); // recupero metodo HTTP della richiesta
        System.out.println("Request start time: " + startTime);
        // Processing
        filterChain.doFilter(servletRequest, servletResponse); //dico all'anello di fianco alla catena che ho finito il pre-processing
        // Post processing
        long endTime = System.currentTimeMillis(); // prendo il tempo finale
        long duration = endTime - startTime; // calcolo il tempo di esecuzione della chiamata
        System.out.println("End time: " + endTime);
        System.out.println("Duration: " + duration);
        System.out.println("-----");
    }
}
