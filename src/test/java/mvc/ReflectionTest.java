package mvc;


import mvc.annotation.Controller;
import mvc.annotation.Service;
import mvc.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Controller 에노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.
 */
class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {

        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));
        logger.debug("beans: {}", beans);
    }

    private Set<Class<?>> getTypesAnnotatedWith(List<Class <? extends Annotation>> annotations) {
        // java.mvc 패키지 하위에 있는 클래스를 찾는다.
        Reflections reflections = new Reflections("mvc");

        Set<Class<?>> beans = new HashSet<>();

        // @Controller 에노테이션이 설정돼 있는 모든 클래스를 찾아 hashSet 에 저장한다.
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));

        return beans;
    }

    @Test
    void showClass() {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());

        /**
         * Arrays.stream -> clazz.getDeclaredFields() -> User 에 선언된 모든 필드 들을 출력한다.
         * Arrays.stream -> clazz.getDeclaredMethods() -> User 에 선언된 모든 메소드 들을 출력한다.
         * Arrays.stream -> clazz.getDeclaredConstructors() -> User 에 선언된 모든 생성자 들을 출력한다.
         */
        logger.debug("User all declared fields: [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared methods: [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
        logger.debug("User all declared constructor: [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
    }

    @Test
    void load() throws ClassNotFoundException {

        /**
         * Heap 영역에 올라가 있는 객체를 확인 하는 방법 3가지
         */

        // 1
        Class<User> clazz1 = User.class;

        // 2
        User user = new User("serverwizard", "신형기");
        Class<? extends User> clazz2 = user.getClass();

        // 3
        final Class<?> clazz3 = Class.forName("mvc.model.User");

        logger.debug("clazz1: {}", clazz1);
        logger.debug("clazz2: {}", clazz2);
        logger.debug("clazz3: {}", clazz3);

        assertThat(clazz1 == clazz2).isTrue();
        assertThat(clazz2 == clazz3).isTrue();
        assertThat(clazz1 == clazz3).isTrue();
    }
}
