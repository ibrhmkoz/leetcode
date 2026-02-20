class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        val queue = ArrayDeque<TreeNode>().apply {
            add(root)
        }

        val result = mutableListOf<List<Int>>()
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            repeat(queue.size) {
                val element = queue.removeFirst()
                element.left?.let {
                    queue.add(it)
                }
                element.right?.let {
                    queue.add(it)
                }
                level.add(element.`val`)
            }
            result.add(level)
        }

        return result
    }
}
