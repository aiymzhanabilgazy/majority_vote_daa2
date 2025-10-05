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


        int candidate = 0;
        int count = 0;

        for (int element : nums) {
            metrics.incrementArrayAccesses();//reading an element
            metrics.incrementComparisons(); //compare count==0

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
        return candidate;
    }
}
