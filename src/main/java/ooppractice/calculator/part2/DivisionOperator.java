package ooppractice.calculator.part2;

public class DivisionOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if(operand2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }

        return operand1 / operand2;
    }
}
