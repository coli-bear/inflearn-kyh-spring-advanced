package myl.colibear.study.sample.beanfactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class BeanFactorySample implements FactoryBean<String> {
    @Override
    public String getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
