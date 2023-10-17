package tags.math

/**
 * https://www.acmicpc.net/problem/4375
 */
fun main() {
    while (true) {
        val n = (readlnOrNull() ?: break).toInt()
        println(getLength(n))
    }
}

private fun getLength(n: Int): Int {
    var length = 0
    var value = 0
    while (true) {
        length++
        value = (value * 10 + 1) % n
        if (value == 0) {
            break
        }
    }
    return length
}
