package level2

/**
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 */
class SpinningMatrixBorder {
    private lateinit var minimumNumbers: IntArray
    private lateinit var matrix: Array<IntArray>

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        minimumNumbers = IntArray(queries.size)
        matrix = setMatrix(rows, columns)

        var index = 0
        for (query in queries)
            matrix = spinMatrix(index++, query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1)

        return minimumNumbers
    }

    private fun setMatrix(rows: Int, columns: Int): Array<IntArray> {
        val graph = Array(rows) { IntArray(columns) }
        for (row in 0 until rows) {
            for (col in 0 until columns)
                graph[row][col] = row * columns + col + 1
        }
        return graph
    }

    private fun spinMatrix(index: Int, y1: Int, x1: Int, y2: Int, x2: Int): Array<IntArray> {
        var minimumNumber = Int.MAX_VALUE
        val newMatrix = Array(matrix.size) { i ->
            IntArray(matrix[i].size) { j -> matrix[i][j] }
        }

        // shift (x1, y1) -> (x2, y1)
        for (i in x1 + 1..x2) {
            val number = matrix[y1][i - 1]
            newMatrix[y1][i] = number
            minimumNumber = minimumNumber.coerceAtMost(number)
        }

        // shift (x2, y1) -> (x2, y2)
        for (i in y1 + 1..y2) {
            val number = matrix[i - 1][x2]
            newMatrix[i][x2] = number
            minimumNumber = minimumNumber.coerceAtMost(number)
        }

        // shift (x2, y2) -> (x1, y2)
        for (i in x1 until x2) {
            val number = matrix[y2][i + 1]
            newMatrix[y2][i] = number
            minimumNumber = minimumNumber.coerceAtMost(number)
        }

        // shift (x1, y2) -> (x1, y1)
        for (i in y1 until y2) {
            val number = matrix[i + 1][x1]
            newMatrix[i][x1] = number
            minimumNumber = minimumNumber.coerceAtMost(number)
        }
        minimumNumbers[index] = minimumNumber

        return newMatrix
    }
}

fun main() {
    val matrix = SpinningMatrixBorder()
    var rows = 6
    var columns = 6
    var queries = Array(3) { i ->
        when (i) {
            0 -> intArrayOf(2, 2, 5, 4)
            1 -> intArrayOf(3, 3, 6, 6)
            2 -> intArrayOf(5, 1, 6, 3)
            else -> intArrayOf(0)
        }
    }
    println(matrix.solution(rows, columns, queries).contentEquals(intArrayOf(8, 10, 25)))

    rows = 3
    columns = 3
    queries = Array(4) { i ->
        when (i) {
            0 -> intArrayOf(1, 1, 2, 2)
            1 -> intArrayOf(1, 2, 2, 3)
            2 -> intArrayOf(2, 1, 3, 2)
            else -> intArrayOf(2, 2, 3, 3)
        }
    }
    println(matrix.solution(rows, columns, queries).contentEquals(intArrayOf(1, 1, 5, 3)))
}
