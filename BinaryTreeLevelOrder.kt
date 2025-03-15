class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()

        val queue = ArrayDeque<TreeNode>().apply { add(root) }
        val result = mutableListOf<List<Int>>()
        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            val currentLevel = mutableListOf<Int>()

            repeat(levelSize) {
                val node = queue.removeFirst()
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }

                currentLevel.add(node.`val`)
            }

            result.add(currentLevel)
        }

        return result
    }
}
