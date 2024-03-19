package tags.implementation

/**
 * https://www.acmicpc.net/problem/2331
 */
import kotlin.math.pow
import kotlin.system.exitProcess

fun main() {
    val (a, p) = readln().split(" ").map { it.toInt() }
    val numbers = mutableListOf<Int>().apply { this.add(a) }
    val group = mutableSetOf<Int>().apply { this.add(a) }
    while (true) {
        val n = numbers.last()
        val nextN = getNextNumber(n, p)
        if (group.contains(nextN)) {
            println(numbers.indexOf(nextN))
            exitProcess(0)
        } else {
            numbers.add(nextN)
            group.add(nextN)
        }
    }
}

private fun getNextNumber(n: Int, p: Int): Int {
    var sum = 0
    var current = n
    while (current != 0) {
        sum += (current % 10).toDouble().pow(p).toInt()
        current /= 10
    }
    return sum
}
