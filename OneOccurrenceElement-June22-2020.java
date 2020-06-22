class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0; // bits that occurred once
        int twos = 0; // bits that occurred twice
        int threes;   // bits that occurred thrice
        for(int i = 0; i < nums.length ; i++){
            twos = twos | (ones & nums[i]);
            ones = ones ^ nums[i];
            threes = ones & twos ;
            ones = ones & ~(threes); // unset bits that occurred thrice in ones
            twos = twos & ~(threes); // unset bits that occurred thrice in twos
        }
        // bits that occurred once
        return ones;
    }
}