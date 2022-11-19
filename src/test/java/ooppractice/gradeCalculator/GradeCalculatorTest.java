package ooppractice.gradeCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 요구사항
 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 MVC 패턴(Model-View-Controller) 기반으로 구현한다.
 일급 컬렉션 사용
 */
public class GradeCalculatorTest {

    // 학점 계산기 도메인: 이수한 과목 (객체지향 프로그래밍, 자료구조, 중국어회화), 학점 계산기
    // 객체지향 프로그래밍, 자료구조, 중국어회화 ---> 과목(코스) 로 표현할 수 있다.

    // 이수한 과목을 전달하여 평균학점 계산 요청 ---> 학점 계산기에게 요청 ---> (학점수 + 교과목 평점) 의 합계 --> 과목(코스)
    //                                                     ---> 수강신청 총학점 수           --> 과목(코스)

    @Test
    @DisplayName("평균 학점을 계산한다.")
    void calculateGradeTest() {
        final List<Cource> cources = List.of(new Cource("객체지향 프로그래밍", 3, "A+"),
                new Cource("자료구조", 3, "A+"),
                new Cource("중국어회화", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(cources);
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
