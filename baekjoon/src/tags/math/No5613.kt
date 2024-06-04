package tags.math

/**
 * https://www.acmicpc.net/problem/5613
 */
fun main() {
    var v = readln().toInt()
    while (true) {
        val c = readln()[0]
        if (c == '=') {
            break
        }
        val n = readln().toInt()
        when (c) {
            '+' -> v += n
            '-' -> v -= n
            '*' -> v *= n
            '/' -> v /= n
        }
    }
    println(v)
}
