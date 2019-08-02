import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import parser.massParser.AliexpressMassParser;

public class TestParser {
    @Rule
 public Timeout timeout= Timeout.seconds(3600);
    @Test()
    public void testWithTimeout() {
        AliexpressMassParser massParser = new AliexpressMassParser();
        massParser.massParse(10);
    }
}
