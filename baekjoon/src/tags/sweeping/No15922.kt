package tags.sweeping

/**
 * https://www.acmicpc.net/problem/15922
 */
fun main() {
    val n = readln().toInt()
    var sum = 0
    var (prevX, prevY) = readln().split(" ").map { it.toInt() }
    repeat(n - 1) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        if (prevY >= x) {
            prevY = maxOf(prevY, y)
        } else {
            sum += prevY - prevX
            prevX = x
            prevY = y
        }
    }
    sum += prevY - prevX
    println(sum)
}
