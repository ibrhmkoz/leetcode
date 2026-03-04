class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        root ?: return null

        if (key == root.`val`) {
            if (root.right == null) {
                return root.left
            }
            if (root.left == null) {
                return root.right
            }

            var cur = root.right!!
            while (cur.left != null) {
                cur = cur.left!!
            }

            cur.left = root.left
            return root.right
        }

        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else {
            root.right = deleteNode(root.right, key)
        }

        return root
    }
}
