package tags.implementation

/**
 * https://www.acmicpc.net/problem/2490
 */
fun main() {
    repeat(3) {
        val count = readln().split(" ").map { it.toInt() }.count { it == 0 }
        println(Char('A'.code + (4 + count) % 5))
    }
}
