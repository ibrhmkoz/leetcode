class LRUCache(private val capacity: Int) {
    private val c = object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size > capacity
        }
    }

    fun get(key: Int): Int {
        return c.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        c[key] = value
    }
}
