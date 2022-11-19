package ooppractice.gradeCalculator;

import java.util.List;

public class GradeCalculator {

    private final List<Cource> cources;

    public GradeCalculator (List<Cource> cources) {
        this.cources = cources;
    }

    /**
     * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
     * 일급 컬렉션 사용
     */
    public double calculateGrade() {
        double multipliedCreditAndCourceGrade = 0;
        for(Cource course: cources) {
            multipliedCreditAndCourceGrade += course.getCredit() * course.getGradeToNumber();
        }

        // 수강신청 총학점 수
        int totalCompletedCredit = cources.stream()
            .mapToInt(Cource::getCredit)
            .sum();

        return multipliedCreditAndCourceGrade / totalCompletedCredit;
    }
}
