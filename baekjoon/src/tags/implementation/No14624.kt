package tags.implementation

/**
 * https://www.acmicpc.net/problem/14624
 */
fun main() {
    val n = readln().toInt()
    if (n % 2 == 0) {
        println("I LOVE CBNU")
    } else {
        println("*".repeat(n))
        val symbol = Array((n + 1) / 2) { CharArray(n) { ' ' } }
        for (i in 0 until (n + 1) / 2) {
            symbol[i][n / 2 - i] = '*'
            symbol[i][n / 2 + i] = '*'
        }
        symbol.forEach { println(it.joinToString("").trimEnd()) }
    }
}
