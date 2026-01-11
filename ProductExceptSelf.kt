/*
Algorithm: Two-pass approach to compute product of all elements except self

1. Left products pass:
   - leftProduct[i] represents the product of all elements to the left of index i
   - Formula: leftProduct[i] = leftProduct[i-1] * nums[i-1]
   - We store these directly in the result array

2. Right products pass:
   - We maintain a running right product variable instead of creating a separate array
   - As we traverse right-to-left, we multiply the already-stored left product 
     with the current right product to get the final answer
   - Formula: result[i] = leftProduct[i] * rightProduct[i]

This approach achieves O(n) time complexity with O(1) extra space (output array doesn't count).
*/

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }

        // First pass: build left products in result array
        for (i in 1..nums.lastIndex) {
            result[i] = nums[i - 1] * result[i - 1]
        }

        // Second pass: multiply by right products on the fly
        var right = 1
        for (i in nums.lastIndex - 1 downTo 0) {
            val newRight = nums[i + 1] * right
            result[i] = result[i] * newRight
            right = newRight
        }

        return result
    }
}
