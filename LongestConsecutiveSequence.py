class LCS:
    def __init__(self, nums):
        self.queried = {}
        self.nums = set(nums)

    def lcs(self, num):
        if num in self.queried:
            return self.queried[num]

        if num not in self.nums:
            return 0

        count = 1 + self.lcs(num + 1)
        self.queried[num] = count
        return count


class Solution:
    def longestConsecutive(self, nums) -> int:
        if nums is None or len(nums) == 0:
            return 0
        lcs = LCS(nums)
        return max(lcs.lcs(num) for num in nums)
