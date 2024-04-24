class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val i = bisectLeft(nums, target)
        return if (i == nums.size) {
            -1
        } else {
            if (nums[i] == target) {
                i
            } else {
                -1
            }
        }
    }
}

fun bisectLeft(nums: IntArray, target: Int): Int {
    var lo = 0
    var hi = nums.size

    while (lo != hi) {
        val mid = lo + (hi - lo) / 2
        if (nums[mid] < target) {
            lo = mid + 1
        } else {
            hi = mid
        }
    }

    return lo
}
