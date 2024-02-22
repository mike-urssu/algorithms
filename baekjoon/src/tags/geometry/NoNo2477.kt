package tags.geometry

/**
 * https://www.acmicpc.net/problem/2477
 */
fun main() {
    val k = readln().toInt()
    val lengths = IntArray(6) { readln().split(" ").map { it.toInt() }[1] }
    println(k * getArea(lengths))
}

private fun getArea(lengths: IntArray): Int {
    val maxLength = lengths.max()
    val indexX = lengths.indexOf(maxLength)
    val indexY = if (lengths[(indexX - 1 + 6) % 6] > lengths[(indexX + 1 + 6) % 6]) {
        (indexX - 1 + 6) % 6
    } else {
        (indexX + 1 + 6) % 6
    }
    return lengths[indexX] * lengths[indexY] - (lengths[(indexX + 3) % 6] * lengths[(indexY + 3) % 6])
}
