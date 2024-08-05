class MinNode:
    def __init__(self, val, prev):
        self.val = val
        self.prev = prev


class MinStack:
    def __init__(self):
        self.stack = []
        self.min_so_far = None

    def push(self, val: int) -> None:
        if self.min_so_far is None or val < self.min_so_far.val:
            self.min_so_far = MinNode(val, self.min_so_far)
            self.stack.append(self.min_so_far)
        else:
            min_node = MinNode(val, None)
            self.stack.append(min_node)

    def pop(self) -> None:
        el = self.stack.pop()
        if el == self.min_so_far:
            self.min_so_far = el.prev

    def top(self) -> int:
        return self.stack[-1].val

    def getMin(self) -> int:
        return self.min_so_far.val
