package by.matrosov.prototypesingletoninjection;

import by.matrosov.prototypesingletoninjection.config.AppConfig;
import by.matrosov.prototypesingletoninjection.prototype.PrototypeBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonAppContextBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInjectionContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonAppContextBean fs = context.getBean(SingletonAppContextBean.class);
        PrototypeBean fp = fs.getPrototypeBean();

        SingletonAppContextBean ss = context.getBean(SingletonAppContextBean.class);
        PrototypeBean sp = ss.getPrototypeBean();

        if (fp.equals(sp)){
            System.out.println("The same instance is returned");
        }else {
            System.out.println("not the same");
        }
    }
}
