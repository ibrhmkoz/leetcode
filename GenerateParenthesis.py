import typing
from dataclasses import field, dataclass
from typing import List


@dataclass(frozen=True)
class Parenthesis:
    o_num: int = 0
    c_num: int = 0
    seq: typing.Tuple = field(default_factory=tuple)

    def increase_opening(self):
        return Parenthesis(
            self.o_num + 1,
            self.c_num,
            self.seq + ('(',)
        )

    def increase_closing(self):
        return Parenthesis(
            self.o_num,
            self.c_num + 1,
            self.seq + (')',)
        )

    def __str__(self):
        return ''.join(self.seq)


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        wfp = []

        def expand(p):
            if p.o_num == n and p.c_num == n:
                wfp.append(str(p))
                return

            if p.o_num == n and p.o_num > p.c_num:
                expand(p.increase_closing())
            if n > p.o_num == p.c_num:
                expand(p.increase_opening())
            if n > p.o_num > p.c_num:
                expand(p.increase_opening())
                expand(p.increase_closing())

        p = Parenthesis()
        expand(p)
        return wfp
