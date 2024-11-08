package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1527
 */
private var count = 0

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    append(a, b, 4L)
    append(a, b, 7L)
    println(count)
}

private fun append(a: Long, b: Long, n: Long) {
    if (n > b) {
        return
    }

    if (n in a..b) {
        count++
    }

    append(a, b, n * 10 + 4)
    append(a, b, n * 10 + 7)
}
