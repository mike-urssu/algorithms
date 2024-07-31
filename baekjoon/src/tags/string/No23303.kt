package tags.string

/**
 * https://www.acmicpc.net/problem/23303
 */
fun main() {
    val s = readln()
    val d2 = if (s.contains("D2") || s.contains("d2")) {
        "D2"
    } else {
        "unrated"
    }
    println(d2)
}
