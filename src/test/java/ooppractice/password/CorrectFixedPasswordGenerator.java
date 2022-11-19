package ooppractice.password;

import ooppractice.password.PasswordGenerator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "abcdefgh"; // 8 글자
    }
}
