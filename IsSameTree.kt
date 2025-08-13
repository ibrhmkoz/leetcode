class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        fun isSame(n1: TreeNode?, n2: TreeNode?): Boolean =
            if (n1 == null && n2 == null) {
                true
            } else {
                n1?.`val` == n2?.`val`
                        && isSame(n1?.left, n2?.left)
                        && isSame(n1?.right, n2?.right)
            }

        return isSame(p, q)
    }
}
