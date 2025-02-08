package tags.implementation

/**
 * https://www.acmicpc.net/problem/30224
 */
fun main() {
    val s = readln()
    val n = s.toInt()
    val value = if (s.none { it == '7' }) {
        if (n % 7 != 0) {
            0
        } else {
            1
        }
    } else {
        if (n % 7 != 0) {
            2
        } else {
            3
        }
    }
    println(value)
}
