import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitPracticalTask2 {
    @BeforeAll
    public static void beforeAll() {
        String s = "This is before all tests";
        System.out.println(s);
    }

    @BeforeEach
    public static void beforeEach() {
        String s = "... and this is before each tests";
        System.out.println(s);
    }

    @AfterAll
    public static void afterAll() {
        String s = "This is after all tests";
        System.out.println(s);
    }

    @AfterEach
    public static void afterEach() {
        String s = "This is after each tests";
        System.out.println(s);
    }

    @Test
    public static test1() {
        Assertions.assertTrue(1 == 1);
    }
}

