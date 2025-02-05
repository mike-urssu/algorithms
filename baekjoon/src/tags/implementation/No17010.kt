package tags.implementation

/**
 * https://www.acmicpc.net/problem/17010
 */
fun main() {
    val l = readln().toInt()
    repeat(l) {
        val (n, c) = readln().split(" ")
        println(c.repeat(n.toInt()))
    }
}
