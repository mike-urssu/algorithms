package tags.math

/**
 * https://www.acmicpc.net/problem/16968Ω
 */
fun main() {
    val lp = readln().toCharArray()

    val counts = IntArray(lp.size)
    counts[0] = if (lp[0] == 'c') {
        26
    } else {
        10
    }
    (1 until lp.size).forEach { i ->
        if (lp[i] == 'c') {
            counts[i] = if (lp[i] == lp[i - 1]) {
                25
            } else {
                26
            }
        } else {
            counts[i] = if (lp[i] == lp[i - 1]) {
                9
            } else {
                10
            }
        }
    }

    val count = counts.fold(1) { it, acc -> it * acc }
    println(count)
}
