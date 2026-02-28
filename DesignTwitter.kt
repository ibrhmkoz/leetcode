class BoundedPriorityQueue<T>(
    private val bound: Int,
    comparator: Comparator<T>
) : PriorityQueue<T & Any>(comparator) {
    override fun offer(e: T?): Boolean {
        val isOffered = super.offer(e)
        if (size > bound) {
            poll()
        }
        return isOffered
    }
}

class BoundedArrayDeque<T>(private val bound: Int) : Iterable<T> {
    private val deque = ArrayDeque<T>()

    fun add(element: T) {
        if (deque.size >= bound) deque.removeFirst()
        deque.addLast(element)
    }

    override fun iterator() = deque.iterator()
}

data class Tweet(val id: Int, val timestamp: Int, val userId: Int)

class Twitter {
    private val userTweets = mutableMapOf<Int, BoundedArrayDeque<Tweet>>()
    private val userFollowees = mutableMapOf<Int, MutableSet<Int>>()
    private val k = 10
    private var timestamp = 0


    fun postTweet(userId: Int, tweetId: Int) {
        userTweets.getOrPut(userId) { BoundedArrayDeque(k) }.add(Tweet(tweetId, timestamp++, userId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val followees = userFollowees.getOrPut(userId) { mutableSetOf(userId) }
        val feed = BoundedPriorityQueue<Tweet>(k) { t1, t2 -> t1.timestamp - t2.timestamp }
        followees.asSequence().mapNotNull { userTweets[it] }.flatMap { it }.toCollection(feed)
        return feed.sortedByDescending { it.timestamp }.map { it.id }
    }

    fun follow(followerId: Int, followeeId: Int) {
        userFollowees.getOrPut(followerId) { mutableSetOf(followerId) }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        userFollowees.getOrPut(followerId) { mutableSetOf(followerId) }.remove(followeeId)
    }
}
