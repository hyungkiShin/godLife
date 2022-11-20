package server;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class QueryStringsTest {

    @Test
    @DisplayName("createTest")
    void createTest() {

        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");
        System.out.println("queryStrings = " + queryStrings);
        // given
        // when
        // then
    }
}
