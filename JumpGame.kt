class Solution {
    fun canJump(nums: IntArray): Boolean {
        var obj = nums.lastIndex

        for (i in obj - 1 downTo 0) {
            if (i + nums[i] >= obj) {
                obj = i
            }
        }
        
        return obj == 0
    }
}
