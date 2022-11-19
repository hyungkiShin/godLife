package ooppractice.calculator;

import ooppractice.calculator.part2.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 사칙연산 계산기 구현
 * 요구사항 :
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다. MVC 패턴(Model-View-Controller) 기반으로 구현한다.
 */
class CalculatorTest {

    // 1 + 2 ---> Calculate
    // 3 <---
    @Test
    @DisplayName("덧셈 연산을 수행한다")
    void 덧셈_연산을_수행한다() {
        // given
        int result = Calculator.calculate(new PositiveNumber(1), "+", new PositiveNumber(2));

        // when
        // then
        assertThat(result).isEqualTo(3);
    }


    @Test
    @DisplayName("뺄셈 연산을 수행한다")
    void 뺄셈_연산을_수행한다() {
        // given
        int result = Calculator.calculate(new PositiveNumber(1), "-", new PositiveNumber(2));

        // when
        // then
        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("사칙연산을 테스트한다.")
    @ParameterizedTest
    @MethodSource("formulateAndResult")
    void calculateTest(int operand1, String operator, int operand2, int expected) {
        // given
        // when
        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> formulateAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(1, "*", 2, 2),
                arguments(1, "/", 2, 0)
        );
    }

//    @Test
//    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
//    void calculateExceptionTest() {
//        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("Division by zero is not allowed");
//    }
}
