package tags.implementation

/**
 * https://www.acmicpc.net/problem/10157
 */
fun main() {
    val (c, r) = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()
    if (k > r * c) {
        println(0)
    } else {
        val (x, y) = getCoordinates(r, c, k)
        println("$x $y")
    }
}

private fun getCoordinates(r: Int, c: Int, k: Int): Pair<Int, Int> {
    var num = 1
    repeat((minOf(r, c) + 1) / 2) { n ->
        for (i in n until r - 1 - n) {
            if (num++ == k) {
                return n + 1 to i + 1
            }
        }
        for (j in n until c - 1 - n) {
            if (num++ == k) {
                return j + 1 to r - n
            }
        }
        for (i in r - 1 - n downTo 1 + n) {
            if (num++ == k) {
                return c - n to i + 1
            }
        }
        for (j in c - 1 - n downTo 1 + n) {
            if (num++ == k) {
                return j + 1 to n + 1
            }
        }
    }
    return c / 2 + 1 to r / 2 + 1
}
