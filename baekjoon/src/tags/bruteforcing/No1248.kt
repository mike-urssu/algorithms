package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1248
 */
import kotlin.math.sign
import kotlin.system.exitProcess

private lateinit var matrix: Array<IntArray>
private lateinit var signs: IntArray
private lateinit var sequence: IntArray

fun main() {
    val n = readln().toInt()
    val s = readln()

    matrix = getMatrix(n, s)
    signs = IntArray(n) { i -> matrix[i][i] }
    sequence = IntArray(n)

    getBoundary(signs[0]).forEach { i ->
        sequence[0] = i
        combination(n, 1)
    }
}

private fun getMatrix(n: Int, s: String): Array<IntArray> {
    val matrix = Array(n) { IntArray(n) }
    var from = 0
    var to = n
    var length = n - 1
    for (i in 0 until n) {
        s.substring(from, to)
            .map {
                when (it) {
                    '+' -> 1
                    '0' -> 0
                    else -> -1
                }
            }
            .toIntArray().copyInto(matrix[i], i)
        from = to
        to += length--
    }
    return matrix
}

private fun getBoundary(sign: Int): IntRange {
    return when (sign) {
        1 -> (1..10)
        0 -> (0..0)
        else -> (-10..-1)
    }
}

private fun combination(n: Int, index: Int) {
    if (index == n) {
        println(sequence.joinToString(" "))
        exitProcess(0)
    }

    getBoundary(signs[index]).forEach { i ->
        sequence[index] = i
        if (isValid(index)) {
            combination(n, index + 1)
        }
    }
}

private fun isValid(index: Int): Boolean {
    for (i in 0..index) {
        var sum = 0
        for (j in i..index) {
            sum += sequence[j]
            if (sum.sign != matrix[i][j].sign) {
                return false
            }
        }
    }
    return true
}
