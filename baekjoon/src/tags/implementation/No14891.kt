package tags.implementation

/**
 * https://www.acmicpc.net/problem/14891
 */
private lateinit var gears: Array<IntArray>
private lateinit var isRotatable: BooleanArray
private lateinit var isClockWise: BooleanArray

fun main() {
    gears = Array(4) { readln().map { it.digitToInt() }.toIntArray() }

    val k = readln().toInt()
    repeat(k) {
        val input = readln().split(" ").map { it.toInt() }
        val n = input[0] - 1
        isRotatable = isRotatable(n)
        isClockWise = isClockWise(n, input[1] == 1)

        (0 until 4).forEach { i ->
            if (isRotatable[i]) {
                if (isClockWise[i]) {
                    spinClockWise(i)
                } else {
                    spinCounterClockWise(i)
                }
            }
        }
    }

    val sum = (0 until 4).sumOf { i ->
        if (gears[i][0] == 1) {
            gears[i][0] shl i
        } else {
            0
        }
    }
    println(sum)
}

private fun isRotatable(n: Int): BooleanArray {
    val isRotatable = BooleanArray(4).apply { this[n] = true }

    var index = n
    for (i in n - 1 downTo 0) {
        if (gears[index][6] == gears[i][2]) {
            break
        }
        isRotatable[i] = true
        index = i
    }

    index = n
    for (i in n + 1 until 4) {
        if (gears[index][2] == gears[i][6]) {
            break
        }
        isRotatable[i] = true
        index = i
    }

    return isRotatable
}

private fun isClockWise(n: Int, direction: Boolean): BooleanArray {
    val isClockWise = BooleanArray(4).apply { this[n] = direction }

    for (i in n - 1 downTo 0) {
        if (isRotatable[i]) {
            isClockWise[i] = !isClockWise[i + 1]
        }
    }

    for (i in n + 1 until 4) {
        if (isRotatable[i]) {
            isClockWise[i] = !isClockWise[i - 1]
        }
    }

    return isClockWise
}

private fun spinClockWise(n: Int) {
    val temp = gears[n][7]
    (7 downTo 1).forEach { i -> gears[n][i] = gears[n][i - 1] }
    gears[n][0] = temp
}

private fun spinCounterClockWise(n: Int) {
    val temp = gears[n][0]
    (0..6).forEach { i -> gears[n][i] = gears[n][i + 1] }
    gears[n][7] = temp
}
