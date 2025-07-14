package tags.implementation

/**
 * https://www.acmicpc.net/problem/13015
 */
fun main() {
    val n = readln().toInt()
    val top = top(n)
    val mid = "${" ".repeat(n - 1)}*${" ".repeat(n - 2)}*${" ".repeat(n - 2)}*"
    top.forEach { println(it) }
    println(mid)
    top.reversed().forEach { println(it) }
}

private fun top(n: Int): List<String> {
    val lines = mutableListOf<String>()
    lines.add("${"*".repeat(n)}${" ".repeat(2 * n - 3)}${"*".repeat(n)}")
    (1 until n - 1).forEach { i ->
        lines.add("${" ".repeat(i)}*${" ".repeat(n - 2)}*${" ".repeat(2 * n - 3 - i * 2)}*${" ".repeat(n - 2)}*")
    }
    return lines
}
