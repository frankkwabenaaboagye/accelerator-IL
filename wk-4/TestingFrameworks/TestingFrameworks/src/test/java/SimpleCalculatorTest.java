import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    SimpleCalculator simpleCalculator;

    @BeforeEach
    void setUp() {
        simpleCalculator = new SimpleCalculator();

    }

    @AfterEach
    void tearDown() {
        simpleCalculator = null;
    }

    @Test
    void correctSimpleAddition() {
        simpleCalculator.add(2, 5);
        int expectedResult = 7;
        int resultFromCalculation = simpleCalculator.add(2, 5);
        assertEquals(expectedResult, resultFromCalculation);
    }
}