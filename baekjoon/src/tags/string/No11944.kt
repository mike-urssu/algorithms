package tags.string

/**
 * https://www.acmicpc.net/problem/11944
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val s = n.toString().repeat(n)
    if (s.length > m) {
        println(s.substring(0, m))
    } else {
        println(s)
    }
}
