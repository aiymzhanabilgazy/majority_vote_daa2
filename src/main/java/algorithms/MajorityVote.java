package algorithms;
 import metrics.MajorityMetrics;
public class MajorityVote {

    public int majorityElement(int[] nums) {
        return majorityElement(nums, new MajorityMetrics());
    }

    public int majorityElement(int[] nums, MajorityMetrics metrics) {
        if (metrics == null){
            metrics = new MajorityMetrics();
        }

        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            metrics.incrementArrayAccesses();
            return nums[0];
        }

        int candidate = 0;
        int count = 0;

        for (int element : nums) {
            metrics.incrementArrayAccesses();  //reading an element

            if(count == 0){
                candidate = element;
            }

            metrics.incrementComparisons(); //compare element==candidate
            count +=(element == candidate ? 1 : -1);
        }

        //checking if majority candidate occurs more than n/2 times
        int countCheck = 0;
        for (int element : nums) {
            metrics.incrementArrayAccesses();
            metrics.incrementComparisons();
            if (element == candidate) {
                countCheck++;
            }
        }
        metrics.incrementComparisons();
        return (countCheck > nums.length/ 2) ? candidate : -1 ;

    }
}
