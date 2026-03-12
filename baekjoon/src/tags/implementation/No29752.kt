package tags.implementation

/**
 * https://www.acmicpc.net/problem/29752
 */
fun main() {
    val n = readln().toInt()
    val solved = readln().split(" ").map { it.toInt() }.toIntArray()
    var max = 0
    var c = 0
    for (i in 0 until n) {
        if (solved[i] > 0) {
            c++
            max = maxOf(max, c)
        } else {
            c = 0
        }
    }
    println(max)
}
