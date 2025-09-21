package tags.dp

/**
 * https://www.acmicpc.net/problem/2410
 */
fun main() {
    val cases = IntArray(1_000_001)
    cases[1] = 1
    (2..1_000_000).forEach { i ->
        cases[i] = cases[i - 1]
        if (i % 2 == 0) {
            cases[i] = (cases[i] + cases[i / 2]) % 1_000_000_000
        }
    }

    val n = readln().toInt()
    println(cases[n])
}
