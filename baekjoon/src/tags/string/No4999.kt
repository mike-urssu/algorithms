package tags.string

/**
 * https://www.acmicpc.net/problem/4999
 */
fun main() {
    val s1 = readln()
    val s2 = readln()
    if (s1.endsWith(s2)) {
        println("go")
    } else {
        println("no")
    }
}
