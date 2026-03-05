class Node(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}

class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        fun isLeaf(row: Int, column: Int, size: Int): Boolean? {
            val first = grid[row][column]
            for (i in row..<row + size) {
                for (j in column..<column + size) {
                    if (first != grid[i][j]) {
                        return null
                    }
                }
            }

            return first != 0
        }

        fun _construct(row: Int, column: Int, size: Int): Node {
            val isLeaf = isLeaf(row, column, size)
            return if (isLeaf != null) {
                Node(isLeaf, true)
            } else {
                val half = size / 2
                Node(`val` = false, isLeaf = false).apply {
                    this.topLeft = _construct(row, column, half)
                    this.topRight = _construct(row, column + half, half)
                    this.bottomLeft = _construct(row + half, column, half)
                    this.bottomRight = _construct(row + half, column + half, half)
                }
            }
        }

        return _construct(0, 0, grid.size)
    }
}
