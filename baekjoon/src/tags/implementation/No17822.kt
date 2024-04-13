package tags.implementation

/**
 * https://www.acmicpc.net/problem/17822
 */
private var n = 0
private var m = 0
private lateinit var disks: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    val t = input[2]
    disks = getDisks(n, m)

    repeat(t) {
        val (x, d, k) = readln().split(" ").map { it.toInt() }
        rotateDisks(x, d, k)
        if (isAdjacentNumberExist()) {
            removeAdjacentNumbers()
        } else {
            updateDisks()
        }
    }

    val sum = disks.sumOf { it.sum() }
    println(sum)
}

private fun getDisks(n: Int, m: Int): Array<IntArray> {
    val disks = Array(n + 1) { IntArray(m) }
    (1..n).forEach { i ->
        disks[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    return disks
}

private fun rotateDisks(x: Int, d: Int, k: Int) {
    if (d == 0) {
        (x..n step x).forEach { rotateClockWise(it, k) }
    } else {
        (x..n step x).forEach { rotateCounterClockWise(it, k) }
    }
}

private fun rotateClockWise(n: Int, k: Int) {
    val disk = disks[n]
    repeat(k) {
        val temp = disk[m - 1]
        (m - 1 downTo 1).forEach { i -> disk[i] = disk[i - 1] }
        disk[0] = temp
    }
}

private fun rotateCounterClockWise(n: Int, k: Int) {
    val disk = disks[n]
    repeat(k) {
        val temp = disk[0]
        (0..m - 2).forEach { i -> disk[i] = disk[i + 1] }
        disk[m - 1] = temp
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun isAdjacentNumberExist(): Boolean {
    for (i in 1..n) {
        for (j in 0 until m) {
            if (disks[i][j] != 0) {
                for (k in 0 until 4) {
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY) && disks[i][j] == disks[nextX][nextY]) {
                        return true
                    }
                }
            }
        }
    }
    return false
}

private fun removeAdjacentNumbers() {
    val coordinates = mutableSetOf<Pair<Int, Int>>()
    for (i in 1..n) {
        for (j in 0 until m) {
            if (disks[i][j] != 0) {
                for (k in 0 until 4) {
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY) && disks[i][j] == disks[nextX][nextY]) {
                        coordinates.add(i to j)
                        coordinates.add(nextX to nextY)
                    }
                }
            }
        }
    }

    for (i in 1..n) {
        if (disks[i][0] == disks[i][m - 1]) {
            coordinates.add(i to 0)
            coordinates.add(i to m - 1)
        }
    }

    coordinates.forEach { (i, j) -> disks[i][j] = 0 }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 1..n && y in 0 until m

private fun updateDisks() {
    val average = average()
    (1..n).forEach { i ->
        (0 until m).forEach { j ->
            if (disks[i][j] != 0) {
                if (disks[i][j].toDouble() > average) {
                    disks[i][j]--
                } else if (disks[i][j].toDouble() < average) {
                    disks[i][j]++
                }
            }
        }
    }
}

private fun average(): Double {
    val sum = disks.sumOf { it.sum() }.toDouble()
    val count = disks.sumOf { row -> row.count { it != 0 } }
    return sum / count
}
