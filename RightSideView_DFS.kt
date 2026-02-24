class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val result = mutableListOf<Int>()
        fun dfs(node: TreeNode?, depth: Int) {
            if (node == null) {
                return
            }

            if (depth == result.size) {
                result.add(node.`val`)
            }

            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)
        }


        dfs(root, 0)
        return result
    }
}
