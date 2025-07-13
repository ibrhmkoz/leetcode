object Solution {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    nums.toSet.size != nums.length
  }
}