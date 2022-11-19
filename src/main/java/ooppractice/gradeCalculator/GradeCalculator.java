package ooppractice.gradeCalculator;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;

    public GradeCalculator (List<Cource> cources) {
        this.courses = new Courses(cources);
    }

    /**
     * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
     * 일급 컬렉션 사용
     */
    public double calculateGrade() {
        // (학점수 + 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        // 수강신청 총학점 수
        final int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
