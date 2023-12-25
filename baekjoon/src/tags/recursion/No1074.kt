package tags.recursion

/**
 * https://www.acmicpc.net/problem/1074
 */
import kotlin.math.pow

fun main() {
    val (n, r, c) = readln().split(" ").map { it.toInt() }
    val length = getLength(n, r, c)
    println(getArea(length, r, c))
}

private fun getLength(n: Int, r: Int, c: Int): Int {
    val max = (r * r).coerceAtLeast(c * c)
    var length = 0
    var mul = 2
    for (i in 1..n) {
        if (max < mul * mul) {
            length = i
            break
        }
        mul *= 2
    }
    return length - 1
}

private fun getArea(n: Int, r: Int, c: Int): Int {
    val length = 2.0.pow(n).toInt()
    var area = countSquare(r, c, length) * (length * length)
    if (n != 0) {
        area += getArea(n - 1, r % length, c % length)
    }
    return area
}

private fun countSquare(r: Int, c: Int, length: Int) =
    r / length * 2 + c / length
