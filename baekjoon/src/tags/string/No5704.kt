package tags.string

/**
 * https://www.acmicpc.net/problem/5704
 */
fun main() {
    while (true) {
        val s = readln().lowercase()
        if (s == "*") {
            break
        }
        if (('a'..'z').all { it in s }) {
            println("Y")
        } else {
            println("N")
        }
    }
}
