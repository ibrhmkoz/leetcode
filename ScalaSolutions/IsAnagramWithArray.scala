object Solution {
  def isAnagram(s: String, t: String): Boolean = {
    val charCount = new Array[Int](26)

    for (c <- s) {
      charCount(c - 'a') += 1
    }

    for (c <- t) {
      charCount(c - 'a') -= 1
    }

    charCount.forall(_ == 0)
  }
}
