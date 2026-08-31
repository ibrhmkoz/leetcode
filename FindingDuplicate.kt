/**
 * GRAPH PERSPECTIVE & INTUITION:
 * 
 * 1. Setup (Nodes 1..n -> Graph F):
 *    If we temporarily ignore index 0, the rest of the array forms a directed graph F 
 *    with n nodes and n edges (i -> nums[i]). Having equal edges and nodes guarantees 
 *    that every component contains at least one cycle. F can contain at most one node 
 *    with in-degree >= 2 (the duplicate value), which serves as a cycle entrance.
 * 
 * 2. Incorporating Index 0 (Graph G):
 *    Reintroducing index 0 merges it with F to form graph G. Because values in nums are 
 *    in the range [1, n], no element points to index 0, giving it an in-degree of 0. 
 *    Node 0 acts strictly as the starting head of a tail that leads into the cycle.
 * 
 * 3. Phase 1 (Locating the Collision Point):
 *    Moving `slow` by 1 step and `fast` by 2 steps guarantees they will meet inside 
 *    the cycle at a collision point.
 *      - F = Distance from node 0 to the cycle entrance
 *      - C = Cycle length
 *      - a = Distance from cycle entrance to collision point
 * 
 *    At collision: Distance(Fast) = 2 * Distance(Slow)
 *      => 2(F + a) = F + a + nC
 *      => F + a = nC
 *      => F = (n - 1)C + (C - a)
 * 
 * 4. Phase 2 (Finding the Cycle Entrance):
 *    If we make both pointers take exactly F steps:
 *      - Pointer A (starting at node 0) takes F steps to land directly on the 
 *        cycle entrance by definition.
 *      - Pointer B (starting at the collision point) takes F steps, broken down as:
 *          * (C - a) steps to reach the cycle entrance for the first time.
 *          * (n - 1)C steps completing (n - 1) full laps around the cycle,
 *            ending up right back at the entrance.
 * 
 *    Because Pointer B also ends up at the entrance after F steps, advancing both 
 *    pointers 1 step at a time from node 0 and the collision point guarantees that 
 *    their very first meeting point will be the cycle entrance (the duplicate integer).
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
