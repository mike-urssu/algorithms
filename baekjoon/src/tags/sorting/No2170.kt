package tags.sorting

/**
 * https://www.acmicpc.net/problem/2170
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = reader.readLine().toInt()
    val lines = getLines(n)
    println(getLength(n, lines))
}

private fun getLines(n: Int) =
    Array(n) {
        reader.readLine().split(" ")
            .map { it.toInt() }
            .toIntArray()
    }.sortedWith { it, other ->
        if (it[0] == other[0]) {
            it[1].compareTo(other[1])
        } else {
            it[0].compareTo(other[0])
        }
    }

private fun getLength(n: Int, lines: List<IntArray>): Int {
    var length = 0
    var from = lines[0][0]
    var to = lines[0][1]
    for (i in 1 until n) {
        if (to < lines[i][0]) {
            length += to - from
            from = lines[i][0]
            to = lines[i][1]
        } else if (to < lines[i][1]) {
            to = lines[i][1]
        }
    }
    length += to - from
    return length
}
