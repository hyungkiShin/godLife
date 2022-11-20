package server;

import server.part2.AdditionOperator;
import server.part2.DivisionOperator;
import server.part2.MultipleOperator;
import server.part2.NewArithmeticOperator;
import server.part2.PositiveNumber;
import server.part2.SubtractionOperator;

import java.util.List;

public class Calculator {


    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(
            new AdditionOperator(),
            new SubtractionOperator(),
            new MultipleOperator(),
            new DivisionOperator()
    );
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        // as-is
        // return doCalculate(operand1, operator, operand2);

        // to-be part1
        // return ArthmeticOperator.calculate(operand1, operator, operand2);

        // to-be part2
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자 입니다."));
    }

    private static int doCalculate(final int operand1, final String operator, final int operand2) {
        if("+".equals(operator)) {
            return operand1 + operand2;
        }
        if("-".equals(operator)) {
            return operand1 - operand2;
        }
        if("*".equals(operator)) {
            return operand1 * operand2;
        }
        if("/".equals(operator)) {
            return operand1 / operand2;
        }
        throw new IllegalArgumentException("연산자가 잘못되었습니다.");
    }
}
