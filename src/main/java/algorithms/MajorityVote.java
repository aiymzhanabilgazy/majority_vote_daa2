package algorithms;

public class MajorityVote {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int element : nums) {
            if (count == 0) {
                candidate = element;
            }
            if (element == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
