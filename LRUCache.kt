data class Node(var key: Int, var value: Int = 0, var prev: Node? = null, var next: Node? = null)

typealias Key = Int

class LRUCache(private val capacity: Int) {
    var m = mutableMapOf<Key, Node>()
    private var h = Node(key = 0, value = 0)
    private var t = Node(key = 0, value = 0)

    init {
        h.prev = t
        t.next = h
    }

    fun get(key: Int): Int {
        val n = m[key]
        if (n == null) {
            return -1
        } else {
            moveToHead(n)
            return n.value
        }
    }

    fun put(key: Int, value: Int) {
        val fn = m[key]

        val n: Node = fn ?: Node(key = key)

        n.value = value
        moveToHead(n)
        m[key] = n

        if (m.size > capacity) {
            t.next?.let { remove(it) }
        }
    }

    private fun moveToHead(node: Node) {
        ripOff(node)
        addBefore(h, node)
    }

    private fun ripOff(node: Node) {
        val p = node.prev
        val n = node.next

        n?.prev = p
        p?.next = n

        node.next = null
        node.prev = null
    }

    private fun remove(node: Node) {
        ripOff(node)
        m.remove(node.key)
    }

    private fun addBefore(node: Node, newNode: Node) {
        val p = node.prev

        p?.next = newNode
        node.prev = newNode

        newNode.next = node
        newNode.prev = p
    }
}

