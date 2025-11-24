package tags.math

/**
 * https://www.acmicpc.net/problem/9417
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val numbers = readln().split(" ").map { it.toInt() }.sortedDescending()
        var max = 1
        for (i in numbers.indices) {
            for (j in numbers.indices) {
                if (i == j) {
                    continue
                }
                max = maxOf(max, gcd(numbers[i], numbers[j]))
            }
        }
        println(max)
    }
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}
