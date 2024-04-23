class Never : Throwable()
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var i = 0
        var j = nums.lastIndex

        val sn = nums.withIndex().sortedBy { it.value }

        while (i < j) {
            val sum = sn[i].value + sn[j].value
            if (sum == target) {
                return intArrayOf(sn[i].index, sn[j].index)
            } else if (sum > target) {
                j--
            } else {
                i++
            }
        }

        throw Never()
    }
}
