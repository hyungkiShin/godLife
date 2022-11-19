package ooppractice.gradeCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourceTest {

    @Test
    @DisplayName("과목(코스) 를 생성한다")
    void createTest() {
        // given
        // when
        // then
        assertThatCode(() ->new Cource("객체지향 프로그래밍", 3, "A+"))
                .doesNotThrowAnyException();
    }
}
