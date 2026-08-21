class Solution {
    fun trap(height: IntArray): Int {
        var l = 0
        var r = height.lastIndex

        var ans = 0
        var lMax = 0
        var rMax = 0
        while (l <= r) {
            if (lMax <= rMax) {
                ans += maxOf(lMax - height[l], 0)
                lMax = maxOf(lMax, height[l])
                l++
            } else {
                ans += maxOf(rMax - height[r], 0)
                rMax = maxOf(rMax, height[r])
                r--
            }
        }

        return ans
    }
}
