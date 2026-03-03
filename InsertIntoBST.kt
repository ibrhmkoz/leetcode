class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }

        var cur: TreeNode = root
        while (true) {
            if (`val` < cur.`val`) {
                val left = cur.left
                if (left == null) {
                    cur.left = TreeNode(`val`)
                    break
                } else {
                    cur = left
                }
            } else {
                val right = cur.right
                if (right == null) {
                    cur.right = TreeNode(`val`)
                    break
                } else {
                    cur = right
                }
            }
        }

        return root
    }
}
