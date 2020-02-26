package tutorial.com;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {


    /*
    * ВЫЗЫВАЕТСЯ ДО ИНИЦИАЛИЗАЦИИ
    * */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InjectRandomIntBeanPostProcessor was called");
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field:declaredFields){
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation!=null){
                int min = annotation.min();
                int max = annotation.max();

                Random random = new Random();
                int i = min +random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, i);
            }
        }

        return bean;
    }


    /*
     * ВЫЗЫВАЕТСЯ ПОСЛЕ ИНИЦИАЛИЗАЦИИ
     * */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
