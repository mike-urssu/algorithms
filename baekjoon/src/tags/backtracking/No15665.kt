package tags.backtracking

/**
 * https://www.acmicpc.net/problem/15665
 */
import java.io.BufferedWriter
import java.io.OutputStreamWriter

private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var numbers: IntArray
private lateinit var combination: IntArray

fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    numbers = readln().split(" ").map { it.toInt() }.distinct().sorted().toIntArray()
    combination = IntArray(m)
    combination(numbers.size, m, 0)
    writer.flush()
}

private fun combination(n: Int, r: Int, index: Int) {
    if (r == index) {
        writer.write("${combination.joinToString(" ")}\n")
        return
    }

    for (i in 0 until n) {
        combination[index] = numbers[i]
        combination(n, r, index + 1)
    }
}
