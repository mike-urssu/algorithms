package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2798
 */
fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }

    var sum = 0
    for (i in 0 until numbers.size - 2) {
        for (j in i + 1 until numbers.size - 1) {
            for (k in j + 1 until numbers.size) {
                val s = numbers[i] + numbers[j] + numbers[k]
                if (s <= m) {
                    sum = sum.coerceAtLeast(s)
                }
            }
        }
    }

    println(sum)
}
