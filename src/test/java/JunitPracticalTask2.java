import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

public class JunitPracticalTask2 {
    private static Logger LOGGER = Logger.getLogger(JunitPracticalTask2.class.getName());

    @BeforeAll
    public static void beforeAll() {
        LOGGER.info("@BeforeAll is started");
    }

    @BeforeEach
    public void beforeEach() {
        LOGGER.info("@BeforeEach is started");
    }

    @AfterAll
    public static void afterAll() {
        LOGGER.info("@AfterAll is started");
    }

    @AfterEach
    public void afterEach() {
        LOGGER.info("@AfterEach is started");
    }

    @Test
    public void test1() {
        LOGGER.info("Test1 is started");
        Assertions.assertTrue(2 < 1);
    }

    @Test
    public void test2() {
        LOGGER.info("Test2 is started");
        Assertions.assertEquals(1, 1);
    }
}

