package mvc;


import mvc.annotation.Controller;
import mvc.annotation.Service;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @Controller 에노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.
 */
public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {

        // java.mvc 패키지 하위에 있는 클래스를 찾는다.
        Reflections reflections = new Reflections("mvc");

        Set<Class<?>> beans = new HashSet<>();

        // @Controller 에노테이션이 설정돼 있는 모든 클래스를 찾아 hashSet 에 저장한다.
        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));
        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));
        logger.debug("beans: {}", beans);
    }
}
