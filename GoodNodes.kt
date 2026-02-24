class Solution {
    fun goodNodes(root: TreeNode?): Int {
        var count = 0
        fun dfs(node: TreeNode?, max: Int) {
            if (node == null) {
                return
            }

            if (node.`val` >= max) {
                count++
            }

            val newMax = maxOf(node.`val`, max)
            dfs(node.left, newMax)
            dfs(node.right, newMax)
        }

        dfs(root, Int.MIN_VALUE)
        return count
    }
}
