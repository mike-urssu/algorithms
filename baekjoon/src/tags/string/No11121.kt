package tags.string

/**
 * https://www.acmicpc.net/problem/11121
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (input, output) = readln().split(" ")
        if (input == output) {
            println("OK")
        } else {
            println("ERROR")
        }
    }
}
