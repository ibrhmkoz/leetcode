class Solution {
    fun rob(root: TreeNode?): Int {
        val cache = mutableMapOf<TreeNode, Int>()
        fun maxRob(cur: TreeNode?): Int {
            cur ?: return 0

            val grandkids = listOfNotNull(
                cur.left?.left, cur.left?.right, cur.right?.left, cur.right?.right
            )

            return cache.getOrPut(cur) {
                maxOf(
                    cur.`val` + grandkids.sumOf { maxRob(it) },
                    maxRob(cur.left) + maxRob(cur.right)
                )
            }
        }

        return maxRob(root)
    }
}
