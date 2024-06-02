package tags.math

/**
 * https://www.acmicpc.net/problem/10179
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val price = readln().toDouble()
        println(String.format("$%.2f", price * 0.8))
    }
}
