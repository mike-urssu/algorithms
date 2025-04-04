package tags.math

/**
 * https://www.acmicpc.net/problem/2527
 */
fun main() {
    repeat(4) {
        val numbers = readln().split(" ").map { it.toInt() }
        val cord1 = numbers.take(4).toIntArray()
        val cord2 = numbers.takeLast(4).toIntArray()
        val code = if (isD(cord1, cord2) || isD(cord2, cord1)) {
            'd'
        } else if (isC(cord1, cord2) || isC(cord2, cord1)) {
            'c'
        } else if (isB(cord1, cord2) || isB(cord2, cord1)) {
            'b'
        } else {
            'a'
        }
        println(code)
    }
}

private fun isB(cord1: IntArray, cord2: IntArray): Boolean {
    val (x, y, p, q) = cord1
    val (x2, y2, _, q2) = cord2

    if (y == q2 && x2 in x..p) {
        return true
    }
    if (p == x2) {
        if (y2 in y..q || q2 in y..q || q in y2..q2) {
            return true
        }
    }
    if (q == y2 && x2 in x..p) {
        return true
    }
    return false
}

private fun isC(cord1: IntArray, cord2: IntArray): Boolean {
    val (x, _, p, q) = cord1
    val (x2, y2, p2, _) = cord2
    return (p == x2 && q == y2) || (y2 == q && x == p2)
}

private fun isD(cord1: IntArray, cord2: IntArray): Boolean {
    val (_, y, p, q) = cord1
    val (x2, y2, _, q2) = cord2
    return q2 < y || q < y2 || p < x2
}
