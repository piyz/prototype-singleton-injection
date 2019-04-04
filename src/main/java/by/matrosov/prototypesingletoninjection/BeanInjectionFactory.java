package by.matrosov.prototypesingletoninjection;

import by.matrosov.prototypesingletoninjection.config.AppConfig;
import by.matrosov.prototypesingletoninjection.prototype.PrototypeBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonObjectFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class BeanInjectionFactory {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonObjectFactoryBean firstContext = context.getBean(SingletonObjectFactoryBean.class);
        SingletonObjectFactoryBean secondContext = context.getBean(SingletonObjectFactoryBean.class);

        PrototypeBean firstInstance = firstContext.getPrototypeInstance();
        PrototypeBean secondInstance = secondContext.getPrototypeInstance();

        if (firstInstance.equals(secondInstance)){
            System.out.println("The same instance is returned");
        }

    }
}
