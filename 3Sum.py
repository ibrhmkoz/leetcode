from typing import List


class ThreeSumAcc:
    def __init__(self):
        self.triplets = set()

    def add(self, triplet):
        self.triplets.add(triplet)

    def all_triplets(self):
        return [list(t) for t in self.triplets]


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()

        tsa = ThreeSumAcc()

        for i in range(len(nums) - 2):
            j = i + 1
            k = len(nums) - 1

            _target = 0 - nums[i]

            while j < k:
                _sum = nums[j] + nums[k]
                if _sum == _target:
                    # Tuples are hashable, whereas lists are not, this is why we send triplets in the form of tuples.
                    tsa.add((nums[i], nums[j], nums[k]))
                    j += 1
                    k -= 1
                elif _sum < _target:
                    j += 1
                else:
                    k -= 1

        return tsa.all_triplets()
