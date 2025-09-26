import Beans.MyDependency;
import Beans.StatefullBean;
import Beans.StatelessBean;
import Injector.Injector;
import Servlet.BeanDemoServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception{
        //creazione delle dipendenze MyDependency
        MyDependency depForConstructor = new MyDependency();
        MyDependency depForSetter = new MyDependency();
        MyDependency depForInterface = new MyDependency();

        //creazione dei bean
        StatefullBean statefullBean = new StatefullBean();
        StatelessBean statelessBean = new StatelessBean();

        //creazione della servlet passando dipendenza nel costruttore
        BeanDemoServlet beanDemoServlet = new BeanDemoServlet(depForConstructor);

        // iniezione della dipendenza tramite costruttore
        beanDemoServlet.setDepFromSetter(depForSetter);

        //iniezione della dipendenza tramite interfaccia
        Injector.performInjection(beanDemoServlet);

        //iniezione dei bean tramite setter
        beanDemoServlet.setStatefullBean(statefullBean);
        beanDemoServlet.setStatelessBean(statelessBean);

        //configurazione del server jetty
        Server server = new Server(8080);
        ServletContextHandler contex = new ServletContextHandler(ServletContextHandler.SESSIONS);

        // registrazione della servlet
        contex.addServlet(new ServletHolder(beanDemoServlet), "/beans");
        server.setHandler(contex); //collego contesto al server
        server.start(); //parte il server
        System.out.println("Server partito, endpoint diponibili");
        server.join(); //evita che si chiuda
    }
}
