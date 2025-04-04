import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

    Grader grader;

    @BeforeEach
    void setUp() {
        grader = new Grader();
    }

    @AfterEach
    void tearDown() {
        grader = null;
    }

    @Test
    void letterGradeFor59ShouldBeF() {
        char expected = 'F';
        char actual = grader.determineLetterGrade(59);
        assertEquals(expected, actual, "59 should be an F");
    }

    @Test
    void letterGradeFor60ShouldBeD() {
        char expected = 'D';
        char actual = grader.determineLetterGrade(60);
        assertEquals(expected, actual, "60 should be a D");
    }

    @Test
    void letterGradeFor69ShouldBeD() {
        char expected = 'D';
        char actual = grader.determineLetterGrade(69);
        assertEquals(expected, actual, "69 should be a D");
    }

    @Test
    void letterGradeFor70ShouldBeC() {
        char expected = 'C';
        char actual = grader.determineLetterGrade(70);
        assertEquals(expected, actual, "70 should be a C");
    }

    @Test
    void letterGradeFor79ShouldBeC() {
        char expected = 'C';
        char actual = grader.determineLetterGrade(79);
        assertEquals(expected, actual, "79 should be a C");
    }

    @Test
    void letterGradeFor80ShouldBeB() {
        char expected = 'B';
        char actual = grader.determineLetterGrade(80);
        assertEquals(expected, actual, "80 should be a B");
    }

    @Test
    void letterGradeFor89ShouldBeB() {
        char expected = 'B';
        char actual = grader.determineLetterGrade(89);
        assertEquals(expected, actual, "89 should be a B");
    }

    @Test
    void letterGradeFor90ShouldBeA() {
        char expected = 'A';
        char actual = grader.determineLetterGrade(90);
        assertEquals(expected, actual, "90 should be an A");
    }

    @Test
    void letterGradeFor100ShouldBeA() {
        char expected = 'A';
        char actual = grader.determineLetterGrade(100);
        assertEquals(expected, actual, "100 should be an A");
    }


    // test throw new IllegalArgumentException("Number grade cannot be negative");
    @Test
    void letterGradeForNegative1ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            grader.determineLetterGrade(-1);
        });
    }


}