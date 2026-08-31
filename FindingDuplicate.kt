/**
 * GRAPH PERSPECTIVE & INTUITION:
 * 
 * 1. Setup (Nodes 1..n -> Graph F):
 *    Ignoring index 0 for a moment, the remaining array represents a directed graph 
 *    F with n nodes and n edges (i -> nums[i]). Because total edges equal total nodes, 
 *    every component in F must contain at least one cycle. F can contain at most 
 *    one node with in-degree >= 2 (the duplicate value). If such a node exists, 
 *    it acts as the entrance to a cycle, creating a "tail" leading into it.
 * 
 * 2. Incorporating Index 0 (Graph G):
 *    Reintroducing index 0 merges it with F to form graph G. Since no element in 
 *    nums can equal 0 (values are in range [1, n]), node 0 has an in-degree of 0. 
 *    It serves strictly as the starting head of the main tail leading toward the 
 *    cycle entrance.
 * 
 * 3. Phase 1 (Finding the Collision Point):
 *    We place two pointers (slow and fast) at node 0. Moving slow by 1 step and fast 
 *    by 2 steps guarantees they will collide inside the cycle. Let F be the tail 
 *    length (distance from node 0 to the entrance), C be the cycle length, and 'a' 
 *    be the distance from the entrance to the collision point.
 * 
 * 4. Phase 2 (Finding the In-Degree >= 2 Node):
 *    At collision: Distance(Fast) = 2 * Distance(Slow)
 *      => 2(F + a) = F + a + nC  =>  F = (n - 1)C + (C - a)
 * 
 *    Algebraically:
 *    - Pointer A starting at node 0 reaches the entrance in exactly F steps.
 *    - Pointer B starting at the collision point takes (C - a) steps to reach 
 *      the entrance for the first time, plus (n - 1) full C-length laps.
 * 
 *    Therefore, taking F steps from the collision point also lands Pointer B back 
 *    at the cycle entrance. Resetting slow to node 0 and advancing both pointers 
 *    1 step at a time guarantees they will first intersect at step F— pinpointing 
 *    the cycle entrance (the duplicate integer).
 */

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        slow = 0
        do {
            slow = nums[slow]
            fast = nums[fast]
        } while (slow != fast)

        return slow
    }
}
