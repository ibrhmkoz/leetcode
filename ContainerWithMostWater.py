from typing import List


class Arear:
    def __init__(self, heights):
        self.heights = heights

    def area(self):
        lo, hi = 0, len(self.heights) - 1

        while lo < hi:
            width = hi - lo
            height = min(self.heights[lo], self.heights[hi])
            yield width * height
            if self.heights[lo] < self.heights[hi]:
                lo += 1
            else:
                hi -= 1


class Solution:
    def maxArea(self, heights: List[int]) -> int:
        arear = Arear(heights)
        return max(arear.area())
