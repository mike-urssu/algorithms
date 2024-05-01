package tags.dp

/**
 * https://www.acmicpc.net/problem/13699
 */
fun main() {
    val t = getT()
    val n = readln().toInt()
    println(t[n])
}

private fun getT(): LongArray {
    val t = LongArray(36)
    t[0] = 1
    (1..35).forEach { i ->
        var l = 0
        var r = i - 1
        repeat(i) {
            t[i] += t[l++] * t[r--]
        }
    }
    return t
}
