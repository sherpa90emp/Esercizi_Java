package Injector;

import Beans.MyDependency;

// interfaccia che una classe deve implementare se vuole ricevere una certa dipendenza
public interface Injectable {
    void inject(MyDependency dependency);
}
