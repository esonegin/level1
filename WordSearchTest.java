import org.junit.*;
import java.util.Arrays;


public class WordSearchTest {

    @BeforeClass
    public static void globalSetUp() {

    }


    @Before
    public void setUp() {

    }

    @Test
    public void whenWordSearchIntWithoutProbel() throws Exception {
        WordSearch first = new WordSearch();
        int[] actual = first.wordSearch(3, "12345", "123");
        int[] expected = {1,0};
        Assert.assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void whenWordSearchStringWithProbel() throws Exception {
        WordSearch first = new WordSearch();
        int[] actual = first.wordSearch(12, "1) строка разбивается на набор строк через выравнивание по заданной ширине.", "строк");
        int[] expected = {0,0,0,1,0,0,0};
        Assert.assertTrue(Arrays.equals(actual, expected));
    }
}
