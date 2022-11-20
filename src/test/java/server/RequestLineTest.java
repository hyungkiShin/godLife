package server;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    @DisplayName("해당 요청을 처리할 수 있는지 확인한다.")
    void create() {

        RequestLine requestLine = new RequestLine("GET /calculator?operand1=11&operator=*&operand2=55 HTTP/1.1");

        assertThat(requestLine).isNotNull();
    }
}
