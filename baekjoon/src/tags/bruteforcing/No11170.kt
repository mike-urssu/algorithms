package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/11170
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val count = (n..m).sumOf { number -> number.toString().count { it == '0' } }
        println(count)
    }
}
