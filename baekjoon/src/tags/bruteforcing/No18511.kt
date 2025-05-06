package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/18511
 */
import kotlin.math.log

private var n = 0
private lateinit var array: IntArray
private lateinit var combination: IntArray
private var max = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    array = readln().split(" ").map { it.toInt() }.toIntArray()

    val size = log(n.toDouble(), 10.0).toInt() + 1
    combination = IntArray(size)
    combination(size, 1)
    combination(size, 0)
    println(max)
}

private fun combination(size: Int, r: Int) {
    if (r == size) {
        val v = combination.joinToString("").toInt()
        if (v <= n) {
            max = maxOf(max, v)
        }
        return
    }

    array.forEach {
        combination[r] = it
        combination(size, r + 1)
    }
}
