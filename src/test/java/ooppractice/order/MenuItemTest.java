package ooppractice.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

 class MenuItemTest {

    @Test
    @DisplayName("메뉴항목을 생성한다")
    void 메뉴항목을_생성한다() {
        // given
        // when
        // then
        assertThatCode(() -> new MenuItem("만두", 5000))
                .doesNotThrowAnyException();
    }
}
