package tags.implementation

/**
 * https://www.acmicpc.net/problem/12790
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln().split(" ").map { it.toInt() }
        val hp = (input[0] + input[4]).coerceAtLeast(1)
        val mp = (input[1] + input[5]).coerceAtLeast(1)
        val attack = (input[2] + input[6]).coerceAtLeast(0)
        val defense = input[3] + input[7]
        println(hp + 5 * mp + 2 * attack + 2 * defense)
    }
}
