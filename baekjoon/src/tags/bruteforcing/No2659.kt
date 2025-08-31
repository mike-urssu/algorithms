package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2659
 */
fun main() {
    val numbers = readln().split(" ").map { it[0].digitToInt() }.toIntArray()

    val max = cross(numbers[0] * 1000 + numbers[1] * 100 + numbers[2] * 10 + numbers[3])
    val count = (1111..max).count { isValid(it) }
    println(count)
}

private fun isValid(v: Int): Boolean {
    if (v.toString().any { it == '0' }) {
        return false
    }
    return cross(v) == v
}

private fun cross(v: Int): Int {
    var min = v
    var n = v
    (0 until 4).forEach { _ ->
        n = n / 1000 + (n % 1000) * 10
        min = minOf(min, n)
    }
    return min
}
