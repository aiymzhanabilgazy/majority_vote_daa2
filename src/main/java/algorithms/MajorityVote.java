package algorithms;
 import metrics.MajorityMetrics;

public class MajorityVote {

    public int majorityElement(int[] nums) {
        return majorityElement(nums, new metrics.MajorityMetrics());
    }
  

    public int majorityElement(int[] nums, MajorityMetrics metrics) {

        if (metrics == null){
            metrics = new MajorityMetrics();
        }

        if (nums == null || nums.length == 0){
            return 0;
        }

        int candidate = 0;
        int count = 0;

        for (int element : nums) {
            metrics.incrementArrayAccesses();//reading an element
            metrics.incrementComparisons(); //compare count==0

            if(count == 0){
                candidate = element;
            }

            metrics.incrementComparisons(); //compare element==candidate
            count +=(element == candidate ? 1 : -1);
        }
        return candidate;
    }
}
