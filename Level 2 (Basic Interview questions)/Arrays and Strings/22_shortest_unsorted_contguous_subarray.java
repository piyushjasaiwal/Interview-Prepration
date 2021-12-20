class shortest_unsorted_contguous_subarray {
    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                left = i-1;
                break;
            }
        }

        int right = -1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                right = i+1;
                break;
            }
        }

        if(left == -1 || right == -1){
            return 0;
        }
        return right-left+1;
    }
}