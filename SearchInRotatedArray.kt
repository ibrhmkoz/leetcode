fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
    var lo = start
    var hi = end
    while (lo < hi) {
        val mid = lo + (hi - lo) / 2
        if (nums[mid] < target) {
            lo = mid + 1
        } else {
            hi = mid
        }
    }
    return if (nums[lo] == target) lo else -1
}

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.lastIndex

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (nums[mid] > nums[hi]) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return if (lo - 1 >= 0 && target in nums.first()..nums[lo - 1]) {
            binarySearch(nums, 0, lo - 1, target)
        } else {
            binarySearch(nums, lo, nums.lastIndex, target)
        }
    }
}
