package by.matrosov.prototypesingletoninjection;

import by.matrosov.prototypesingletoninjection.config.BeanInjectionProxyConfig;
import by.matrosov.prototypesingletoninjection.prototype.PrototypeBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInjectionProxy {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInjectionProxyConfig.class);

        SingletonBean firstS = context.getBean(SingletonBean.class);
        PrototypeBean firstP = firstS.getPrototypeBean();

        SingletonBean sendonS = context.getBean(SingletonBean.class);
        PrototypeBean secondP = sendonS.getPrototypeBean();

        if (firstP.equals(secondP)){
            System.out.println("The same instance is returned");
        }
    }
}
