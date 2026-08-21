class Solution {
    fun trap(height: IntArray): Int {
        val n = height.size
        val L = IntArray(n)
        val R = IntArray(n)

        L[0] = 0
        for (i in 1..<n) {
            L[i] = maxOf(L[i - 1], height[i - 1])
        }

        R[n - 1] = 0
        for (i in n - 2 downTo 0) {
            R[i] = maxOf(R[i + 1], height[i + 1])
        }

        return height.indices.sumOf { minOf(L[it], R[it]) - height[it] }
    }
}
