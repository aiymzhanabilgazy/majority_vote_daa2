package algorithms;
 import metrics.MajorityMetrics;
public class MajorityVote {
    public int majorityElement(int[] nums, MajorityMetrics metrics) {
        if (metrics == null){
            metrics = new MajorityMetrics();
        }

        int candidate = 0;
        int count = 0;

        for (int element : nums) {
            metrics.incrementArrayAccesses();  //reading an element

            if(count == 0){
                candidate = element;
            }

            metrics.incrementComparisons(); //compare element==candidate
            if(element == candidate){
                count++;
            }else{
                count--;
            }
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
        if (countCheck > nums.length/ 2) {
            return candidate;
        }
        return -1;
    }
}
