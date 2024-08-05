class ParenthesesValidator:
    def __init__(self):
        self.pars = []

    def add(self, par):
        if par in ('}', ')', ']'):
            try:
                last = self.pars.pop()
            except IndexError:
                return False
            if (last, par) in [
                ('{', '}'),
                ('[', ']'),
                ('(', ')')
            ]:
                return True
            else:
                return False
        else:
            self.pars.append(par)

        return True

    def is_empty(self):
        return len(self.pars) == 0


class Solution:
    def isValid(self, s: str) -> bool:
        pv = ParenthesesValidator()
        for par in s:
            if not pv.add(par):
                return False

        return pv.is_empty()


