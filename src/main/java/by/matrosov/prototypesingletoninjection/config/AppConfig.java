package by.matrosov.prototypesingletoninjection.config;

import by.matrosov.prototypesingletoninjection.prototype.PrototypeBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonAppContextBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonBean;
import by.matrosov.prototypesingletoninjection.singleton.SingletonObjectFactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("by.matrosov.prototypesingletoninjection")
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    public SingletonAppContextBean singletonAppContextBean() {
        return new SingletonAppContextBean();
    }

    @Bean
    public SingletonObjectFactoryBean singletonObjectFactoryBean(){
        return new SingletonObjectFactoryBean();
    }
}
