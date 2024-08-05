class AlphanumericIterator:
    def __init__(self, s):
        self.s = s
        self.i = 0

    def __iter__(self):
        return self

    def __next__(self):
        while self.i < len(self.s):
            c = self.s[self.i]
            self.i += 1

            if c.isalnum():
                return c.lower(), self.i - 1
        else:
            raise StopIteration


class AlphanumericReverseIterator:
    def __init__(self, s):
        self.s = s
        self.i = len(s) - 1

    def __iter__(self):
        return self

    def __next__(self):
        while self.i >= 0:
            c = self.s[self.i]
            self.i -= 1

            if c.isalnum():
                return c.lower(), self.i + 1
        else:
            raise StopIteration


class Solution:
    def isPalindrome(self, s: str) -> bool:
        for i1, i2 in zip(AlphanumericIterator(s), AlphanumericReverseIterator(s)):
            if i1[1] > i2[1]:
                return True

            if i1[0] != i2[0]:
                return False

        return True
