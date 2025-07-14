class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        var buy = prices.first()
        var maxProfit = 0
        for (p in prices.asSequence().drop(1)) {
            if (p <= buy) {
                buy = p
            } else {
                val profit = p - buy
                maxProfit = maxOf(maxProfit, profit)
            }
        }

        return maxProfit
    }
}
