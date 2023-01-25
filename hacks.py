class Matrix:
    def __init__(self, matrix):
        self.matrix = matrix

    def __str__(self):
        output = ""
        for row in self.matrix:
            for cell in row:
                output += f"{cell if cell == -1 else hex(cell)} "
            output += "\n"
        return output

    def reverse(self):
        output = ""
        for i in range(len(self.matrix)-1, -1, -1):
            for j in range(len(self.matrix[i])-1, -1, -1):
                output += f"{self.matrix[i][j] if self.matrix[i][j] == -1 else hex(self.matrix[i][j])} "
            output += "\n"
        return output

    @staticmethod
    def keypad():
        return [[1, 2, 3], [4, 5, 6], [7, 8, 9], [-1, 0, -1]]

    @staticmethod
    def numbers():
        return [[0, 1], [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]]


if __name__ == "__main__":
    m0 = Matrix(Matrix.keypad())
    print("Keypad:")
    print(m0)
    print(m0.reverse())

    m1 = Matrix(Matrix.numbers())
    print("Numbers Systems:")
    print(m1)
    print(m1.reverse())
