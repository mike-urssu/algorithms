package tags.implementation

/**
 * https://www.acmicpc.net/problem/17618
 */
fun main() {
    val n = readln().toInt()
    val count = (1..n).count { isMysteriousNumber(it) }
    println(count)
}

private fun isMysteriousNumber(n: Int): Boolean {
    val sum = n.toString().sumOf { it.digitToInt() }
    return n % sum == 0
}
