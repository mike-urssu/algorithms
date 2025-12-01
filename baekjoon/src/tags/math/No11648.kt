package tags.math

/**
 * https://www.acmicpc.net/problem/11648
 */
fun main() {
    var s = readln()
    var stage = 0
    while (s.length > 1) {
        var mul = 1
        s.forEach { mul *= it.digitToInt() }
        s = mul.toString()
        stage++
    }
    println(stage)
}
