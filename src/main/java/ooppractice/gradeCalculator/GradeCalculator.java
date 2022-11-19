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
     *     // 이수한 과목을 전달하여 평균학점 계산 요청 ---> 학점 계산기에게 요청 ---> (학점수 + 교과목 평점) 의 합계 --> 과목(코스)
     *     //                                                     ---> 수강신청 총학점 수           --> 과목(코스)
     *     이게 바로 협력을 설계 한다의 의미
     */
    public double calculateGrade() {
        // (학점수 + 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        // 수강신청 총학점 수
        final int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
