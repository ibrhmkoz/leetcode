class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        fun isSame(n: TreeNode?, m: TreeNode?): Boolean {
            if (n == null && m == null) {
                return true
            }
            return n?.`val` == m?.`val` && isSame(n?.left, m?.left) && isSame(n?.right, m?.right)
        }

        // the following is necessary because 
        // return isSame(root, subRoot) || isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
        // makes access safe but doesn't remove infinite recursion because it resolves into null and keeps going without stop
        if (root == null) return subRoot == null
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
}
