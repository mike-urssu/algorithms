package tags.implementation

/**
 * https://www.acmicpc.net/problem/4740
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == "***") {
            break
        }
        println(s.reversed())
    }
}
