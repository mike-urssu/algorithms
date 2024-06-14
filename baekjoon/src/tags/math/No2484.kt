package tags.math

/**
 * https://www.acmicpc.net/problem/2484
 */
fun main() {
    val n = readln().toInt()
    val max = (1..n).maxOf {
        val eyes = IntArray(7)
        val numbers = readln().split(" ").map { it.toInt() }
        numbers.forEach { eyes[it]++ }
        val m = eyes.max()
        if (m == 4) {
            50000 + eyes.indexOf(m) * 5000
        } else if (m == 3) {
            10000 + eyes.indexOf(m) * 1000
        } else if (eyes.count { it == 2 } == 2) {
            2000 + (1..6).filter { eyes[it] == 2 }.sum() * 500
        } else if (m == 2) {
            1000 + eyes.indexOf(m) * 100
        } else {
            numbers.max() * 100
        }
    }
    println(max)
}
