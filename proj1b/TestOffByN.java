import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

public class TestOffByN {
    OffByN offByFive = new OffByN(5);
    @Test
    public void testEqualChars() {
        assertTrue(offByFive.equalChars('a', 'f'));
        assertFalse(offByFive.equalChars('a', 'b'));
        assertTrue(offByFive.equalChars('c', 'h'));
        assertTrue(offByFive.equalChars('q', 'v'));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(offByFive.isPalindrome("acqmvhf"));
        assertFalse(offByFive.isPalindrome("racecar"));
        assertTrue(offByFive.isPalindrome("a"));
        assertTrue(offByFive.isPalindrome(""));
    }
}
