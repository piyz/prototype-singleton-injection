package by.matrosov.prototypesingletoninjection.singleton;

import by.matrosov.prototypesingletoninjection.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class SingletonFunctionBean {

    @Autowired
    private Function<String, PrototypeBean> beanFactory;

    public PrototypeBean getPrototypeInstance(String name) {
        return beanFactory.apply(name);
    }
}
