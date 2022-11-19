package ooppractice.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    @DisplayName("패스워드 초기화 여부를 판단한다")
    void passwordTest() {
        // given
        User user = new User();

        // when
        // user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(() -> "abcdefgh");

        // then
        assertThat(user.getPassword()).isNotNull();
    }


    @Test
    @DisplayName("패스워드가 요구사항에 부합되지 않아 초기화가 되지 않는다")
    void 패스워드가_요구사항에_부합되지_않아_초기화가_되지_않는다() {
        // given
        User user = new User();

        // when
        user.initPassword(new WrongFixedPasswordGenerator());

        // then
        assertThat(user.getPassword()).isNull();
    }

}