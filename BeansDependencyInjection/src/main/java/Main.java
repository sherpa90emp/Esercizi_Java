import Beans.MyDependency;
import Beans.StatefullBean;
import Beans.StatelessBean;
import Servlet.BeanDemoServlet;

public class Main {
    public static void main(String[] args) {
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

    }
}
