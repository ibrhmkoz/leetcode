fun TreeNode?.inorder(): Sequence<TreeNode> = sequence {
    if (this@inorder == null) return@sequence
    yieldAll(left.inorder())
    yield(this@inorder)
    yieldAll(right.inorder())
}

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int =
        root.inorder().take(k).last().`val`
}
