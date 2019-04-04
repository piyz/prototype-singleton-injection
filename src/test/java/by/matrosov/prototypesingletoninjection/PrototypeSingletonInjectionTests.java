package by.matrosov.prototypesingletoninjection;

import by.matrosov.prototypesingletoninjection.config.AppConfig;
import by.matrosov.prototypesingletoninjection.config.BeanInjectionProxyConfig;
import by.matrosov.prototypesingletoninjection.prototype.PrototypeBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonAppContextBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonLookupBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonObjectFactoryBean;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class PrototypeSingletonInjectionTests {

    @Test
    public void beanInjectionLookUp(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonLookupBean fs = context.getBean(SingletonLookupBean.class);
        PrototypeBean fp = fs.getPrototypeBean();

        SingletonLookupBean ss = context.getBean(SingletonLookupBean.class);
        PrototypeBean sp = ss.getPrototypeBean();

        assertNotSame("New instance expected", fp, sp);
    }

    @Test
    @Ignore
    public void beanInjectionProxy(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInjectionProxyConfig.class);

        SingletonBean fs = context.getBean(SingletonBean.class);
        PrototypeBean fp = fs.getPrototypeBean();

        SingletonBean ss = context.getBean(SingletonBean.class);
        PrototypeBean sp = ss.getPrototypeBean();

        assertNotSame("New instance expected", fp, sp);
    }

    @Test
    public void beanInjectionProblem(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonBean fs = context.getBean(SingletonBean.class);
        PrototypeBean fp = fs.getPrototypeBean();

        SingletonBean ss = context.getBean(SingletonBean.class);
        PrototypeBean sp = ss.getPrototypeBean();

        assertEquals("New instance not expected", fp, sp);
    }

    @Test
    public void beanInjectionFactory(){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonObjectFactoryBean firstContext = context.getBean(SingletonObjectFactoryBean.class);
        SingletonObjectFactoryBean secondContext = context.getBean(SingletonObjectFactoryBean.class);

        PrototypeBean firstInstance = firstContext.getPrototypeInstance();
        PrototypeBean secondInstance = secondContext.getPrototypeInstance();

        assertNotSame("New instance expected", firstInstance, secondInstance);
    }

    @Test
    public void beanInjectionContext(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonAppContextBean fs = context.getBean(SingletonAppContextBean.class);
        PrototypeBean fp = fs.getPrototypeBean();

        SingletonAppContextBean ss = context.getBean(SingletonAppContextBean.class);
        PrototypeBean sp = ss.getPrototypeBean();

        assertNotSame("New instance expected", fp, sp);
    }
}
