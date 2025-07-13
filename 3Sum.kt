class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val sortedNums = nums.sorted()

        var i = 0
        while (i <= nums.lastIndex) {
            var j = i + 1
            var k = sortedNums.lastIndex

            while (j < k) {
                val sum = sortedNums[i] + sortedNums[j] + sortedNums[k]
                if (sum == 0) {
                    result.add(listOf(sortedNums[i], sortedNums[j], sortedNums[k]))
                    do {
                        j++
                    } while (j < k && sortedNums[j] == sortedNums[j - 1])
                } else if (sum < 0) {
                    j++
                } else {
                    k--
                }
            }

            do {
                i++
            } while (i <= nums.lastIndex && sortedNums[i] == sortedNums[i - 1])
        }

        return result
    }
}
