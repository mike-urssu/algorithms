package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1980
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    val n = numbers[0].coerceAtLeast(numbers[1])
    val m = numbers[0].coerceAtMost(numbers[1])
    val t = numbers[2]

    for (i in 0..t) {
        val time = t - i
        for (j in 0..time / n) {
            for (k in 0..time / m) {
                if (j * n + k * m == time) {
                    println("${j + k} $i")
                    return
                }
            }
        }
    }
}
