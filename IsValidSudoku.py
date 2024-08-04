class DuplicateChecker:
    def __init__(self):
        self.seen = set()

    def add(self, value):
        if value == '.':
            return False
        if value in self.seen:
            return True
        self.seen.add(value)
        return False

    def reset(self):
        self.seen.clear()


class RowIterator:
    def __init__(self, sudoku):
        self.row = 0
        self.sudoku = sudoku

    def __iter__(self):
        return self

    def __next__(self):
        if self.row >= 9:
            raise StopIteration
        row = self.sudoku[self.row]
        self.row += 1
        return row


class ColumnIterator:
    def __init__(self, sudoku):
        self.column = 0
        self.sudoku = sudoku

    def __iter__(self):
        return self

    def __next__(self):
        if self.column >= 9:
            raise StopIteration
        column = [row[self.column] for row in self.sudoku]
        self.column += 1
        return column


class BoxIterator:
    def __init__(self, sudoku):
        self.box = 0
        self.sudoku = sudoku

    def __iter__(self):
        return self

    def __next__(self):
        if self.box >= 9:
            raise StopIteration
        row = (self.box // 3) * 3
        col = (self.box % 3) * 3
        box = [self.sudoku[i][j] for i in range(row, row + 3) for j in range(col, col + 3)]
        self.box += 1
        return box


class Solution:
    def isValidSudoku(self, board) -> bool:
        checker = DuplicateChecker()

        for iterator in (RowIterator(board), ColumnIterator(board), BoxIterator(board)):
            for group in iterator:
                checker.reset()
                for el in group:
                    if checker.add(el):
                        return False

        return True
