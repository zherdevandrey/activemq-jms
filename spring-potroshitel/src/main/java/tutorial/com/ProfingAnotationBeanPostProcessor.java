package tutorial.com;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfingAnotationBeanPostProcessor implements BeanPostProcessor {

    Map<String, Class> map = new HashMap<String, Class>();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        boolean annotationPresent = bean.getClass().isAnnotationPresent(Profiling.class);
        if (annotationPresent){
            map.put(beanName, bean.getClass());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass!=null){
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("profiling started");
                    Object invoke = method.invoke(bean, args);
                    System.out.println("profiling is finished");
                    return invoke;
                }
            });
        }
        else return bean;
    }
}
