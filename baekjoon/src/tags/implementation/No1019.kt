package tags.implementation

/**
 * https://www.acmicpc.net/problem/1019
 */
private val counts = IntArray(10)

fun main() {
    val n = readln().toInt()
    var start = 1
    var end = n
    var c = 1
    while (start <= end) {
        while (start % 10 != 0 && start <= end) {
            count(start, c)
            start++
        }

        if (start > end) {
            break
        }

        while (end % 10 != 9 && start <= end) {
            count(end, c)
            end--
        }

        (0..9).forEach { i -> counts[i] += (end / 10 - start / 10 + 1) * c }

        start /= 10
        end /= 10
        c *= 10
    }
    println(counts.joinToString(" "))
}

private fun count(n: Int, c: Int) {
    var v = n
    while (v > 0) {
        counts[v % 10] += c
        v /= 10
    }
}
