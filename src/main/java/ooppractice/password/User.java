package ooppractice.password;

import lombok.Getter;
import ooppractice.password.PasswordGenerator;

@Getter
public class User {

    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is 아래의 케이스는 강한 결합이다.
        // RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be 반대로 아래 케이스는 낮은 결합의 케이스 이다.
        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if(password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }
}
