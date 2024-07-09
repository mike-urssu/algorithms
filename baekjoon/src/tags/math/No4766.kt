package tags.math

/**
 * https://www.acmicpc.net/problem/4766
 */
fun main() {
    var temperature = readln().toDouble()
    while (true) {
        val t = readln().toDouble()
        if (t == 999.0) {
            break
        }
        println(String.format("%.2f", t - temperature))
        temperature = t
    }
}
