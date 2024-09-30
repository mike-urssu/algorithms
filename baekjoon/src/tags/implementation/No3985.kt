package tags.implementation

/**
 * https://www.acmicpc.net/problem/3985
 */
fun main() {
    val l = readln().toInt()
    val cake = IntArray(l + 1)
    var expected = 0
    var expectedMax = 0

    val n = readln().toInt()
    (1..n).forEach { i ->
        val (src, dst) = readln().split(" ").map { it.toInt() }
        if (dst - src + 1 > expectedMax) {
            expected = i
            expectedMax = dst - src + 1
        }

        (src..dst).forEach { j ->
            if (cake[j] == 0) {
                cake[j] = i
            }
        }
    }

    val counts = IntArray(l + 1)
    (1..l)
        .filter { i -> cake[i] != 0 }
        .forEach { i -> counts[cake[i]]++ }
    val actualMax = counts.max()
    val actual = counts.indexOf(actualMax)

    println(expected)
    println(actual)
}
