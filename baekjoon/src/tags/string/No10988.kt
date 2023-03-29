package tags.string

/**
 * https://www.acmicpc.net/problem/10988
 */
fun main() {
    val s = readln()
    if (s == s.reversed()) {
        println(1)
    } else {
        println(0)
    }
}
