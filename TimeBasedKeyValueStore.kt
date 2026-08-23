/*
 * BINARY SEARCH MENTAL MODEL: ARRAY PARTITIONING (RIGHT BISECT)
 * -------------------------------------------------------------
 * We divide the sorted array into two contiguous partitions based on a predicate:
 *   - LEFT PARTITION  (Valid):   [timestamp <= target]
 *   - RIGHT PARTITION (Invalid): [timestamp > target]
 *
 * INVARIANTS:
 *   1. 'lo' always converges to the FIRST INDEX of the RIGHT PARTITION.
 *   2. 'lo - 1' always points to the LAST INDEX of the LEFT PARTITION (our answer).
 *   3. 'hi' starts at 'list.size' because if all elements are valid (<= target),
 *      the Right Partition logically begins one past the last element (at list.size).
 *
 * EXECUTION FLOW:
 *   - If list[mid] <= target: 'mid' is still in the Left Partition, so the Right Partition
 *     must start somewhere to the right. We advance 'lo = mid + 1'.
 *   - If list[mid] > target: 'mid' is in the Right Partition. We shrink 'hi = mid' to pull
 *     the upper bound down to 'mid'.
 *
 * TERMINATION:
 *   When lo == hi, 'lo' is definitively the starting index of the Right Partition.
 *   - If lo == 0, the Left Partition is empty (no elements are <= target) -> return ""
 *   - Otherwise, 'lo - 1' gives the largest valid timestamp <= target.
 */

class TimeMap() {
    data class StampedValue(val value: String, val timestamp: Int)

    private val items = mutableMapOf<String, MutableList<StampedValue>>()

    fun set(key: String, value: String, timestamp: Int) {
        items.getOrPut(key) { mutableListOf() }.add(StampedValue(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        val list = items[key] ?: return ""

        var lo = 0
        var hi = list.size

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (list[mid].timestamp <= timestamp) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return if (lo - 1 < 0) {
            ""
        } else {
            list[lo - 1].value
        }
    }
}
