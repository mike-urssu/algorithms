package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/5618
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    val gcd = if (n == 2) {
        getGCD(numbers[0], numbers[1])
    } else {
        getGCD(getGCD(numbers[0], numbers[1]), numbers[2])
    }

    (1..gcd)
        .filter { gcd % it == 0 }
        .forEach { println(it) }
}

private fun getGCD(num1: Int, num2: Int): Int {
    if (num2 == 0) {
        return num1
    }
    return getGCD(num2, num1 % num2)
}
