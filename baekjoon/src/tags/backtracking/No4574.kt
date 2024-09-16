package tags.backtracking

/**
 * https://www.acmicpc.net/problem/4574
 */
import java.util.SortedSet

private val writer = System.out.bufferedWriter()
private lateinit var graph: Array<IntArray>
private lateinit var validNumbers: Array<Array<BooleanArray>>
private lateinit var zeros: SortedSet<Pair<Int, Int>>
private lateinit var puzzles: MutableSet<Pair<Int, Int>>
private var puzzle = 1

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }
        init(n)
        fillSudoku()
        printPuzzle()
    }
    writer.flush()
}

private val rows = 'A'..'I'

private fun init(n: Int) {
    graph = Array(9) { IntArray(9) }
    puzzles = mutableSetOf()
    repeat(n) {
        val (n1, p1, n2, p2) = readln().split(" ")
        graph[rows.indexOf(p1[0])][p1[1].digitToInt() - 1] = n1.toInt()
        graph[rows.indexOf(p2[0])][p2[1].digitToInt() - 1] = n2.toInt()

        puzzles.add(n1.toInt() to n2.toInt())
        puzzles.add(n2.toInt() to n1.toInt())
    }
    readln().split(" ").forEachIndexed { i, v ->
        graph[rows.indexOf(v[0])][v[1].digitToInt() - 1] = i + 1
    }

    validNumbers = Array(3) { Array(3) { BooleanArray(10) { true } } }
    (0 until 3).forEach { i ->
        (0 until 3).forEach { j ->
            getNumbers(i, j).forEach { v ->
                validNumbers[i][j][v] = false
            }
        }
    }

    zeros = sortedSetOf(Comparator { it, other ->
        val c1 = it.first.compareTo(other.first)
        if (c1 == 0) {
            it.second.compareTo(other.second)
        } else {
            c1
        }
    })
    (0 until 9).forEach { i ->
        (0 until 9).forEach { j ->
            if (graph[i][j] == 0) {
                zeros.add(i to j)
            }
        }
    }
}

private fun getNumbers(x: Int, y: Int): List<Int> {
    val numbers = mutableListOf<Int>()
    (x * 3 until x * 3 + 3).forEach { i ->
        (y * 3 until y * 3 + 3).forEach { j ->
            numbers.add(graph[i][j])
        }
    }
    return numbers
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun fillSudoku(): Boolean {
    if (zeros.isEmpty()) {
        return true
    }

    val (x, y) = zeros.first()
    (0 until 4).forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
            if (fill(x, y, nextX, nextY)) {
                return true
            }
        }
    }
    return false
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until 9 && y in 0 until 9

private fun fill(x: Int, y: Int, nextX: Int, nextY: Int): Boolean {
    val indices1 = (1..9).filter { validNumbers[x / 3][y / 3][it] }
    val indices2 = (1..9).filter { validNumbers[nextX / 3][nextY / 3][it] }

    for (i in indices1) {
        for (j in indices2) {
            if (i != j && isValid(x, y, i) && isValid(nextX, nextY, j)) {
                if (puzzles.contains(i to j) || puzzles.contains(j to i)) {
                    continue
                }
                graph[x][y] = i
                graph[nextX][nextY] = j
                puzzles.add(i to j)
                puzzles.add(j to i)

                zeros.remove(x to y)
                zeros.remove(nextX to nextY)
                if (fillSudoku()) {
                    return true
                }
                graph[nextX][nextY] = 0
                graph[x][y] = 0
                puzzles.remove(i to j)
                puzzles.remove(j to i)
                zeros.add(x to y)
                zeros.add(nextX to nextY)
            }
        }
    }
    return false
}

private fun isValid(x: Int, y: Int, v: Int): Boolean {
    if ((0 until 9).any { i -> graph[i][y] == v }) {
        return false
    }

    if ((0 until 9).any { j -> graph[x][j] == v }) {
        return false
    }

    (x / 3 * 3 until x / 3 * 3 + 3).forEach { i ->
        (y / 3 * 3 until y / 3 * 3 + 3).forEach { j ->
            if (graph[i][j] == v) {
                return false
            }
        }
    }

    return true
}

private fun printPuzzle() {
    writer.write("Puzzle $puzzle\n")
    graph.forEach { row -> writer.write("${row.joinToString("")}\n") }
    puzzle++
}
