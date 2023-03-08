package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2702
 */
fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        val (n1, n2) = readln().split(" ").map { it.toInt() }.sortedDescending()
        println("${getLCM(n1, n2)} ${getGCD(n1, n2)}")
    }
}

private fun getLCM(n1: Int, n2: Int) =
    n1 * n2 / getGCD(n1, n2)

private fun getGCD(n1: Int, n2: Int): Int {
    if (n2 == 0) {
        return n1
    }
    return getGCD(n2, n1 % n2)
}
