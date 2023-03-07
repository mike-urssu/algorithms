package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1773
 */
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val time = IntArray(2000001)

    repeat(n) {
        val period = readln().toInt()
        for (i in 1..c) {
            if (i % period == 0) {
                time[i] = 1
            }
        }
    }

    println(time.sum())
}
