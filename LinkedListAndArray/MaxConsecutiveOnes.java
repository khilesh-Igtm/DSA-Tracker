public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 0 };
        System.out.println(consecutive(nums));
    }

    private static int consecutive(int[] nums) {

        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(count, max);

        }
        return max;
    }
}
