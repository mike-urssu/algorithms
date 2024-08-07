package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17088
 */
private var n = 0
private lateinit var numbers: List<Int>
private var min = Int.MAX_VALUE

fun main() {
    n = readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }

    if (n <= 2) {
        min = 0
    } else {
        val (n1, n2, n3) = (-1..1).map { numbers[0] + it }
        val (m1, m2, m3) = (-1..1).map { numbers[1] + it }
        expectValue(2, m1, m1 - n1, 2)
        expectValue(2, m2, m2 - n1, 1)
        expectValue(2, m3, m3 - n1, 2)
        expectValue(2, m1, m1 - n2, 1)
        expectValue(2, m2, m2 - n2, 0)
        expectValue(2, m3, m3 - n2, 1)
        expectValue(2, m1, m1 - n3, 2)
        expectValue(2, m2, m2 - n3, 1)
        expectValue(2, m3, m3 - n3, 2)
        if (min == Int.MAX_VALUE) {
            min = -1
        }
    }
    println(min)
}

private fun expectValue(index: Int, v: Int, d: Int, count: Int) {
    if (index == n) {
        min = min.coerceAtMost(count)
        return
    }

    when (v - numbers[index] + d) {
        1 -> expectValue(index + 1, numbers[index] + 1, d, count + 1)
        0 -> expectValue(index + 1, numbers[index], d, count)
        -1 -> expectValue(index + 1, numbers[index] - 1, d, count + 1)
    }
}
