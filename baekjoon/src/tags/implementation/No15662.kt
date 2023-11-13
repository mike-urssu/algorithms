package tags.implementation

/**
 * https://www.acmicpc.net/problem/15662
 */
private lateinit var gears: Array<IntArray>

fun main() {
    val t = readln().toInt()
    gears = Array(t) { readln().map { it.digitToInt() }.toIntArray() }

    val k = readln().toInt()
    repeat(k) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        rotateGears(t, n, m)
    }

    val count = gears.count { it[0] == 1 }
    println(count)
}

private fun rotateGears(t: Int, n: Int, m: Int) {
    if (n < t) {
        var isCounterWise = -m == 1
        var pole = gears[n - 1][2]
        for (i in n until t) {
            if (pole == gears[i][6]) {
                break
            }

            pole = gears[i][2]
            if (isCounterWise) {
                rotateClockWise(i)
            } else {
                rotateCounterClockWise(i)
            }
            isCounterWise = !isCounterWise
        }
    }

    if (n > 1) {
        var isCounterWise = -m == 1
        var pole = gears[n - 1][6]
        for (i in n - 2 downTo 0) {
            if (pole == gears[i][2]) {
                break
            }

            pole = gears[i][6]
            if (isCounterWise) {
                rotateClockWise(i)
            } else {
                rotateCounterClockWise(i)
            }
            isCounterWise = !isCounterWise
        }
    }

    if (m == 1) {
        rotateClockWise(n - 1)
    } else {
        rotateCounterClockWise(n - 1)
    }
}

private fun rotateClockWise(n: Int) {
    val pole = gears[n][7]
    (7 downTo 1).forEach { i -> gears[n][i] = gears[n][i - 1] }
    gears[n][0] = pole
}

private fun rotateCounterClockWise(n: Int) {
    val pole = gears[n][0]
    (0..6).forEach { i -> gears[n][i] = gears[n][i + 1] }
    gears[n][7] = pole
}
