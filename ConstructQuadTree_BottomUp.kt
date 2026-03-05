class Node(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}

class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        fun _construct(row: Int, col: Int, size: Int): Node {
            if (size == 1) {
                return Node(grid[row][col] == 1, true)
            }

            val half = size / 2

            val topLeft = _construct(row, col, half)
            val topRight = _construct(row, col + half, half)
            val bottomLeft = _construct(row + half, col, half)
            val bottomRight = _construct(row + half, col + half, half)

            val nodes = listOf(topLeft, topRight, bottomLeft, bottomRight)
            return if (nodes.all { it.isLeaf && it.`val` == nodes.first().`val` }) {
                Node(nodes.first().`val`, true)
            } else {
                Node(`val` = false, isLeaf = false).apply {
                    this.topLeft = topLeft
                    this.topRight = topRight
                    this.bottomLeft = bottomLeft
                    this.bottomRight = bottomRight
                }
            }
        }

        return _construct(0, 0, grid.size)
    }
}
