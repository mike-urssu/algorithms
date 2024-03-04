package tags.math

/**
 * https://www.acmicpc.net/problem/10707
 */
fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()
    val p = readln().toInt()

    val cost1 = p * a
    val cost2 = if (p <= c) {
        b
    } else {
        b + (p - c) * d
    }
    println(minOf(cost1, cost2))
}
