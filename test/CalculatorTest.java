import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class CalculatorTest {
    private Calculator cal;

    @BeforeAll
    void setup(){
        cal = new Calculator();
    }

    @DisplayName("입력에 공백만 존재할 경우 0을 반환한다.")
    @Test
    void blankReturnZeroTest() {
        // given
        String input = " ";

        // when
        int result = cal.add(input);

        // then
        assertEquals(0, result);

    }

    @DisplayName("콜론을 기준으로 숫자를 분리하여 더한 값을 반환한다.")
    @Test
    void seperatorColonTest() {
        // given
        String input = "2:3:4";

        // when
        int result = cal.add(input);

        // then
        assertEquals(9, result);
    }

    @DisplayName("쉼표를 기준으로 숫자를 분리하여 더한 값을 반환한다.")
    @Test
    void seperatorCommaTest() {
        // given
        String input = "2,3,4";

        // when
        int result = cal.add(input);

        // then
        assertEquals(9, result);

    }
    
    @DisplayName("'//'와 '\\n' 사이에 오는 문자는 구분자로 적용된다.")
    @Test
    void customSeperatorTest() {
        // given
        String input = "//#\n2#3#4";
        
        // when
        int result = cal.add(input);

        // then
        assertEquals(9, result);
        
    }
    
    @DisplayName("정규식의 특수문자를 구분자로 적용할 수 있다.")
    @Test
    void customSeperatorIsMetacharacter() {
        // given
        String input = "//*\n2*3*4";

        // when
        int result = cal.add(input);

        // then
        assertEquals(9, result);
        
    }
    
    @DisplayName("음수가 있으면 IllegalArgumentException이 발생한다.")
    @Test
    void negativeExpectExceptionTest() {
        // given
        String input = "2,-3,4";
        
        // when & then
        assertThrows(IllegalArgumentException.class, () -> cal.add(input));
    }
}