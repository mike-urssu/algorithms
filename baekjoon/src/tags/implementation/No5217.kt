package tags.implementation

/**
 * https://www.acmicpc.net/problem/5217
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val pairs = getPairs(n)
        println("Pairs for $n: ${pairs.joinToString(", ") { (a, b) -> "$a $b" }}")
    }
}

private fun getPairs(n: Int) =
    (1 until (n + 1) / 2).map { i -> i to n - i }
