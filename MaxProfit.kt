class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        var buy = prices.first()

        var maxProfit = 0

        for (i in 1..prices.lastIndex) {
            if (prices[i] <= buy) {
                buy = prices[i]
            } else {
                val profit = prices[i] - buy
                maxProfit = maxOf(maxProfit, profit)
            }
        }

        return maxProfit
    }
}
