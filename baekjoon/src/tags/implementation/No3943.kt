package tags.implementation

/**
 * https://www.acmicpc.net/problem/3943
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(getMax(n))
    }
}

private fun getMax(n: Int): Int {
    var v = n
    var max = v
    while (v != 1) {
        if (v % 2 == 1) {
            v = v * 3 + 1
            max = max.coerceAtLeast(v)
        } else {
            v /= 2
        }
    }
    return max
}
