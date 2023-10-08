package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2776
 */
import java.io.BufferedWriter
import java.io.OutputStreamWriter

private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val numbers1 = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
        readln()
        val numbers2 = readln().split(" ").map { it.toInt() }
        numbers2.forEach {
            val lowerBound = getLowerBound(numbers1, it)
            if (lowerBound == n || numbers1[lowerBound] != it) {
                writer.write("0\n")
            } else {
                writer.write("1\n")
            }
        }
        writer.flush()
    }
}

private fun getLowerBound(numbers: IntArray, n: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (numbers[mid] >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
