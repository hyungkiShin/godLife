package ooppractice.gradeCalculator;

import java.util.List;

public class Courses {

    private final List<Cource> courses;

    public Courses(final List<Cource> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multipliedCreditAndCourceGrade = 0;
        for(Cource course: courses) {
            // as-is -> getter 가 만능은 아니다 multipliedCreditAndCourceGrade += course.getCredit() * course.getGradeToNumber();
            // to-be -> 응집도를 높히기 위하여 (여러군대에서 쓰이는 중에 요구사항이 변하면 답도 없다.) 객체에게 작업을 위윔 (메세지를 전달) 해서 결과를 받아온다.
            multipliedCreditAndCourceGrade += course.multiplyCreditAndCourseGrade();
        }

        return multipliedCreditAndCourceGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Cource::getCredit)
                .sum();
    }
}
