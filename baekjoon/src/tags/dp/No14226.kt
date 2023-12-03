package tags.dp

/**
 * https://www.acmicpc.net/problem/14226
 */
fun main() {
    val s = readln().toInt()
    println(getTimes()[s])
}

private fun getTimes(): IntArray {
    val times = IntArray(1003)
    (2..1002).forEach { i -> times[i] = i }
    for (i in 2..1000) {
        var j = 2
        while (i * j <= 1002) {
            times[i * j] = times[i * j].coerceAtMost(times[i] + j)
            times[i * j - 1] = times[i * j - 1].coerceAtMost(times[i * j] + 1)
            j++
        }
    }
    return times
}
