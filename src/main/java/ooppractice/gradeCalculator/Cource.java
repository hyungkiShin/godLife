package ooppractice.gradeCalculator;

import lombok.Getter;

@Getter
public class Cource {

    private String subject; // 과목명

    private int credit; // 성적정보

    private String grade; // 성적 (A+, A, B+, B, C+, C)

    public Cource(final String subject, final int credit, final String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
        }

        return grade;
    }

    public double multiplyCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }
}
