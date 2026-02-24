class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>().apply { add(root) }

        while (queue.isNotEmpty()) {
            result.add(queue.last().`val`)

            repeat(queue.size) {
                val node = queue.removeFirst()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }

        return result
    }
}
