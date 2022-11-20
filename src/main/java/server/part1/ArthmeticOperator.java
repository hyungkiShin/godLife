package server.part1;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum ArthmeticOperator {
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    public abstract int arithmeticCalculate(final int operand1, final int operand2);

    public static int calculate(final int operand1, String operator, final int operand2) {
        final ArthmeticOperator arthmeticOperator = Arrays.stream(values())
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return arthmeticOperator.arithmeticCalculate(operand1, operand2);
    }
}
