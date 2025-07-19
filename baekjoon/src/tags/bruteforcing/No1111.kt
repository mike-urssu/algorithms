package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1111
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    val v = if (n == 1) {
        "A"
    } else if (n == 2) {
        if (numbers[0] == numbers[1]) {
            "${numbers[0]}"
        } else {
            "A"
        }
    } else {
        val (a, b) = if (numbers[0] == numbers[1]) {
            1 to 0
        } else {
            val a = (numbers[1] - numbers[2]) / (numbers[0] - numbers[1])
            val b = (-(numbers[1] * numbers[1]) + numbers[0] * numbers[2]) / (numbers[0] - numbers[1])
            a to b
        }
        if (isValid(n, numbers, a, b)) {
            numbers.last() * a + b
        } else {
            "B"
        }
    }
    println(v)
}

private fun isValid(n: Int, numbers: IntArray, a: Int, b: Int): Boolean {
    for (i in 0 until n - 1) {
        val n1 = numbers[i]
        val n2 = numbers[i + 1]
        if (n2 != n1 * a + b) {
            return false
        }
    }
    return true
}
