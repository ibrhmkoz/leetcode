from typing import List


class PolishNotationEvaluator:
    def __init__(self):
        self.stack = []

    def add_token(self, token):
        if token in "+-*/":
            t1 = self.stack.pop()
            t2 = self.stack.pop()

            match token:
                case "+":
                    r = t2 + t1
                case "-":
                    r = t2 - t1
                case "/":
                    r = int(t2 / t1)
                case "*":
                    r = t2 * t1

            self.stack.append(r)
        else:
            self.stack.append(int(token))

    def result(self):
        return self.stack[-1]


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        pne = PolishNotationEvaluator()

        for token in tokens:
            pne.add_token(token)

        return pne.result()
