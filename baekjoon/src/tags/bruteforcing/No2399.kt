package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2399
 */
import kotlin.math.abs

fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }
    var sum = 0L
    for (i in numbers.indices) {
        for (j in numbers.indices) {
            sum += abs(numbers[i] - numbers[j])
        }
    }
    println(sum)
}
