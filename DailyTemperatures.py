from typing import List


class Pair:
    def __init__(self, value, index):
        self.value = value
        self.index = index


class SmartStack:
    def __init__(self, capacity: int):
        self.s = []
        self.r = [0] * capacity

    def push(self, pair):
        while self.s and pair.value > self.s[-1].value:
            lp = self.s.pop()
            self.r[lp.index] = pair.index - lp.index
        self.s.append(pair)

    def result(self):
        return self.r


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ss = SmartStack(len(temperatures))
        for i, t in enumerate(temperatures):
            ss.push(Pair(t, i))

        return ss.result()
