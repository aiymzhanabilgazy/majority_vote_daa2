package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MajorityVoteTest {
    private final MajorityVote majorityVote = new MajorityVote();

    @Test
    void testEmptyArray(){
        int result = majorityVote.majorityElement(new int[]{});
        assertEquals(0,result);
    }
    @Test
    void testOneElementArray(){
        int result = majorityVote.majorityElement(new int[]{16});
        assertEquals(16,result);
    }
    @Test
    void testWithDuplicates(){
        int result = majorityVote.majorityElement(new int[]{2,1,4,1,1,7,1});
        assertEquals(1,result);
    }
    @Test
    void testSortedArray(){
        int result = majorityVote.majorityElement(new int[]{1,2,3,4,5,6,7,8});
        assertTrue(java.util.Arrays.stream(new int[]{1,2,3,4,5,6,7,8}).anyMatch(x -> x == result));
    }
    @Test
    void testUnsortedArray(){
        int result = majorityVote.majorityElement(new int[]{8,7,6,5,4,3,2,1});
        assertTrue(java.util.Arrays.stream(new int[]{8,7,6,5,4,3,2,1}).anyMatch(x -> x == result));
    }
}
