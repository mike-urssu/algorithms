package tags.implementation

/**
 * https://www.acmicpc.net/problem/5523
 */
fun main() {
    val n = readln().toInt()
    var countA = 0
    var countB = 0
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a > b) {
            countA++
        } else if (a < b) {
            countB++
        }
    }
    println("$countA $countB")
}
