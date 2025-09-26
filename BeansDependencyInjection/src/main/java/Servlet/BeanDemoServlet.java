package Servlet;

import Beans.MyDependency;
import Beans.StatefullBean;
import Beans.StatelessBean;
import Injector.Injectable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


//servlet che usa bean fatti da noi (non presi da framework) e dimostra le varie tecniche di dependency injection
public class BeanDemoServlet extends HttpServlet implements Injectable {

    // sono necessari i bean; li dichiaro come variabili di istanza della servlet (no costruttore)
    private StatelessBean statelessBean;
    private StatefullBean statefullBean;

    // dichiaro le dipendenze come var di istanza
    private MyDependency depFromConstructor; //impostata dal costruttore
    private MyDependency depFromSetter; // impostata tramite il setter
    private MyDependency deFromInterface; // impostata tramite interfaccia

    // costruttore che permette di iniettare la dipendenza
    public BeanDemoServlet(MyDependency dep) {
        System.out.println("BeanDemoServlet: Iniettata dipendenza <MyDependency> dal costruttore.");
        this.depFromConstructor = dep;
    }

    //setter che permette di iniettare la dipendenza
    public void setDepFromSetter(MyDependency dep) {
        System.out.println("BeanDemoServlet: Iniettata dipendenza <MyDependency> del setter.");
        this.depFromSetter = dep;
    }

    //interfaccia che permette di ricevere una dipendenza
    @Override
    public void inject(MyDependency dependency) {
        System.out.println("BeanDemoServlet: Iniettata dipendenza <MyDependency> dell'interfaccia.");
        this.deFromInterface = dependency;
    }

    //Setter per bean stateless
    public void setStatelessBean(StatelessBean statelessBean) {
        System.out.println("BeanDemoServlet: Iniettata dipendenza <StatelessBean> dal setter.");
        this.statelessBean = statelessBean;
    }

    //setter per bean statefull
    public  void setStatefullBean(StatefullBean statefullBean) {
        System.out.println("BeanDemoServlet: Iniettata dipendenza <StatefullBean> dal setter.");
        this.statefullBean = statefullBean;
    }

    //usiamo le dipendenze

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h1>Demo di Java Beans e Dependency Injection</h1>");
        out.println("<h2>Stateless Bean</h2>");
        out.printf("<p>%s</p>", statelessBean.saluta("Pippo"));

        out.println("<h2>Stateless Bean</h2>");
        out.printf("<p>Contatore pre incremento: %d</p>", statefullBean.getContatore());
        statefullBean.incremento();
        statefullBean.incremento();
        out.printf("<p>Contatore post incremento: %d</p>", statefullBean.getContatore());

        out.println("<h2>Dipendenza dal costruttore</h2>");
        out.printf("<p>%s</p>", depFromConstructor.getMessaggio());

        out.println("<h2>Dipendenza dal setter</h2>");
        out.printf("<p>%s</p>", depFromSetter.getMessaggio());

        out.println("<h2>Dipendenza da interfaccia</h2>");
        out.printf("<p>%s</p>", deFromInterface.getMessaggio());
    }
}
