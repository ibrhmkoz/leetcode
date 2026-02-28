class BoundedArrayDeque<T>(private val bound: Int) {
    private val deque = ArrayDeque<T>()

    fun add(element: T) {
        if (deque.size >= bound) deque.removeFirst()
        deque.addLast(element)
    }

    fun unwrap() = this.deque
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
        val candidates = PriorityQueue<Pair<Tweet, Iterator<Tweet>>>(compareByDescending { it.first.timestamp })
        for (f in followees) {
            val tweets = userTweets[f]?.unwrap() ?: emptyList()
            val iter = tweets.asReversed().iterator()
            if (iter.hasNext()) {
                candidates.add(iter.next() to iter)
            }
        }
        return buildList {
            while (candidates.isNotEmpty() && size < k) {
                val (tweet, iter) = candidates.remove()
                add(tweet.id)
                if (iter.hasNext()) candidates.add(iter.next() to iter)
            }
        }
    }

    fun follow(followerId: Int, followeeId: Int) {
        followeesOf(followerId).add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followeesOf(followerId).remove(followeeId)
    }

    private fun followeesOf(userId: Int) =
        userFollowees.getOrPut(userId) { mutableSetOf(userId) }
}
