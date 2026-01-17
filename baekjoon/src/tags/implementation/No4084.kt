package tags.implementation

/**
 * https://www.acmicpc.net/problem/4084
 */
import kotlin.math.abs

fun main() {
    while (true) {
        var (a, b, c, d) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0 && c == 0 && d == 0) {
            break
        }

        var count = 0
        while (true) {
            if (a == b && b == c && c == d) {
                break
            }
            val prevA = a
            val prevB = b
            val prevC = c
            val prevD = d
            a = abs(prevA - prevB)
            b = abs(prevB - prevC)
            c = abs(prevC - prevD)
            d = abs(prevD - prevA)
            count++
        }
        println(count)
    }
}
