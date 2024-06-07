package tags.implementation

/**
 * https://www.acmicpc.net/problem/14467
 */
fun main() {
    val cows = IntArray(11) { -1 }
    var count = 0
    val n = readln().toInt()
    repeat(n) {
        val (i, p) = readln().split(" ").map { it.toInt() }
        if (cows[i] == -1) {
            cows[i] = p
        } else {
            if (cows[i] != p) {
                cows[i] = p
                count++
            }
        }
    }
    println(count)
}
