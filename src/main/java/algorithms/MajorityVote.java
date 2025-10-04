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
        //checking if majority candidate occurs more than n/2 times  by formula
        int countCheck = 0;
        for (int element : nums) {
            if (element == candidate) {
                countCheck++;
            }
        }
        if (countCheck > nums.length/ 2) {
            return candidate;
        }
        return -1;
    }
}
