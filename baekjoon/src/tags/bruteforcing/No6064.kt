package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/6064
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (m, n, x, y) = readln().split(" ").map { it.toInt() }
        println(getK(m, n, x, y))
    }
}

private fun getK(m: Int, n: Int, x: Int, y: Int): Int {
    var k = x
    var nextY = getNextY(x, n)

    while (k <= getLCM(m, n)) {
        if (nextY == y) {
            return k
        }
        nextY = getNextY(nextY + m, n)
        k += m
    }

    return -1
}

private fun getNextY(y: Int, n: Int): Int {
    var nextY = y % n
    if (nextY == 0) {
        nextY = n
    }
    return nextY
}

private fun getLCM(m: Int, n: Int) =
    m * n / getGCD(m, n)

private fun getGCD(m: Int, n: Int): Int {
    return if (n == 0) {
        m
    } else {
        getGCD(n, m % n)
    }
}
