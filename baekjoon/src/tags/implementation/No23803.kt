package tags.implementation

/**
 * https://www.acmicpc.net/problem/23803
 */
fun main() {
    val n = readln().toInt()
    val s = "@".repeat(n)
    repeat(4) {
        repeat(n) {
            println(s)
        }
    }
    repeat(n) {
        println(s.repeat(5))
    }
}
