package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2422
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val isInvalid = Array(201) { BooleanArray(201) }
    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() }.sorted()
        isInvalid[i][j] = true
        isInvalid[j][i] = true
    }

    var count = 0
    for (i in 1 until n - 1) {
        for (j in i + 1 until n) {
            for (k in j + 1..n) {
                if (!(isInvalid[i][j] || isInvalid[i][k] || isInvalid[j][k])) {
                    count++
                }
            }
        }
    }

    println(count)
}
