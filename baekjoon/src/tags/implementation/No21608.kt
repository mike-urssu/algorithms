package tags.implementation

/**
 * https://www.acmicpc.net/problem/21608
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var seats: Array<BooleanArray>
private val students = mutableMapOf<Int, List<Int>>()

fun main() {
    n = readln().toInt()
    graph = Array(n) { IntArray(n) }

    repeat(n * n) {
        val input = readln().split(" ").map { it.toInt() }
        val student = input[0]
        val group = input.subList(1, 5)

        fillGraph(student, group)
        students[student] = group
    }

    println(sumSatisFaction())
}

private fun fillGraph(student: Int, students: List<Int>) {
    seats = Array(n) { BooleanArray(n) { true } }
    filter1(students)

    if (getValidSeats() > 1) {
        filter2()

        if (getValidSeats() > 1) {
            var row = 0
            var col = 0
            for (i in n - 1 downTo 0) {
                for (j in n - 1 downTo 0) {
                    if (seats[i][j]) {
                        row = i
                        col = j
                    }
                }
            }
            graph[row][col] = student
        } else {
            val (row, col) = getCoordinates()
            graph[row][col] = student
        }
    } else {
        val (row, col) = getCoordinates()
        graph[row][col] = student
    }
}

private fun getValidSeats() =
    seats.sumOf { row -> row.count { it } }

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun filter1(students: List<Int>) {
    val favoredSeats = getFavoredSeats(students)
    val max = favoredSeats.maxOf { it.max() }
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] != 0 || favoredSeats[i][j] != max) {
                seats[i][j] = false
            }
        }
    }
}

private fun getFavoredSeats(students: List<Int>): Array<IntArray> {
    val seats = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 0) {
                for (k in 0 until 4) {
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY) && graph[nextX][nextY] in students) {
                        seats[i][j]++
                    }
                }
            }
        }
    }
    return seats
}

private fun filter2() {
    val emptySeats = getEmptySeats()
    val max = emptySeats.maxOf { it.max() }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (emptySeats[i][j] != max) {
                seats[i][j] = false
            }
        }
    }
}

private fun getEmptySeats(): Array<IntArray> {
    val emptySeats = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (seats[i][j]) {
                for (k in 0 until 4) {
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
                        emptySeats[i][j]++
                    }
                }
            }
        }
    }
    return emptySeats
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n

private fun getCoordinates(): Pair<Int, Int> {
    var row = 0
    var col = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (seats[i][j]) {
                row = i
                col = j
            }
        }
    }
    return row to col
}

private fun sumSatisFaction(): Int {
    val satisfaction = Array(n) { IntArray(n) }
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            students[graph[i][j]]?.let {
                for (k in 0 until 4) {
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY) && graph[nextX][nextY] in it) {
                        satisfaction[i][j]++
                    }
                }
            }
        }
    }

    var sum = 0
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            sum += when (satisfaction[i][j]) {
                1 -> 1
                2 -> 10
                3 -> 100
                4 -> 1000
                else -> 0
            }
        }
    }
    return sum
}
