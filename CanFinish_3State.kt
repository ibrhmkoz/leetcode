/*
                    +------------------+
                    |    Unvisited     |
                    |  vis[n] unset    |
                    +------------------+
                        /            \
        re-entered     /              \  unwinds
        mid-visit     /                \  cleanly
        (call before /                  \ (no re-call)
        unwind)     /                    \
                   v                      v
          +----------------+      +------------------+
     +--->|     Cycle      |      |     No cycle     |<---+
     |    |  return true   |      |  return false    |    |
     +----+----------------+      +------------------+----+
       called again                      called again
 */

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val g = mutableMapOf<Int, MutableSet<Int>>()

        for ((u, v) in prerequisites) {
            g.getOrPut(u) { mutableSetOf() }.add(v)
        }

        val vis = mutableMapOf<Int, Int>()
        fun hasCycle(n: Int): Boolean {
            when (vis[n]) {
                1 -> return true
                2 -> return false
            }

            vis[n] = 1
            val has = (g[n] ?: emptySet()).any { hasCycle(it) }
            vis[n] = 2
            return has
        }

        return g.keys.none { hasCycle(it) }
    }
}
