class Solution {
    fun tribonacci(n: Int): Int {
        when (n) {
            0 -> return 0
            1, 2 -> return 1
        }

        var f = 0
        var s = 1
        var t = 1

        for (i in 3..n) {
            val sum = f + s + t
            f = s; s = t; t = sum
        }

        return t
    }
}
