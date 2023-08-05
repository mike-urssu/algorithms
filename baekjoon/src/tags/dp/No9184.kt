package tags.dp

/**
 * https://www.acmicpc.net/problem/9184
 */
fun main() {
    val w = getW()
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) {
            break
        }
        val value = if (a <= 0 || b <= 0 || c <= 0) {
            1
        } else if (a > 20 || b > 20 || c > 20) {
            w[20][20][20]
        } else {
            w[a][b][c]
        }
        println("w($a, $b, $c) = $value")
    }
}

private fun getW(): Array<Array<IntArray>> {
    val w = Array(21) { Array(21) { IntArray(21) } }
    for (a in 0..20) {
        for (b in 0..20) {
            for (c in 0..20) {
                w[a][b][c] = if (a == 0 || b == 0 || c == 0) {
                    1
                } else if (b in a + 1 until c) {
                    w[a][b][c - 1] + w[a][b - 1][c - 1] - w[a][b - 1][c]
                } else {
                    w[a - 1][b][c] + w[a - 1][b - 1][c] + w[a - 1][b][c - 1] - w[a - 1][b - 1][c - 1]
                }
            }
        }
    }
    return w
}
