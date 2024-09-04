package tags.backtracking

/**
 * https://www.acmicpc.net/problem/16936
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toLong() }.toLongArray()

    val array = LongArray(n)
    array[0] = findX(numbers)
    (1 until n).forEach { i ->
        val v = array[i - 1]
        array[i] = if (numbers.indexOf(v * 2) != -1) {
            v * 2
        } else {
            v / 3
        }
    }

    println(array.joinToString(" "))
}

private fun findX(numbers: LongArray): Long {
    var x = -1L
    var two = Int.MAX_VALUE
    var three = -1
    numbers.forEach {
        var v = it
        var c1 = 0
        var c2 = 0
        while (v % 2 == 0L) {
            c1++
            v /= 2
        }
        while (v % 3 == 0L) {
            c2++
            v /= 3
        }

        if (c1 <= two && three <= c2) {
            x = it
            two = c1
            three = c2
        }
    }
    return x
}
