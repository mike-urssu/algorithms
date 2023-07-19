package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17626
 */
import kotlin.math.sqrt

fun main() {
    val numbers = BooleanArray(50001)
    (1..sqrt(50000.0).toInt()).forEach { i -> numbers[i * i] = true }

    val n = readln().toInt()
    var min = 4
    if (numbers[n]) {
        min = 1
    } else {
        val sqrtI = sqrt(n.toDouble()).toInt()
        for (i in sqrtI downTo 0) {
            if (numbers[n - i * i]) {
                min = 2
                break
            }
            val sqrtJ = sqrt((n - i * i).toDouble()).toInt()
            for (j in sqrtJ downTo 0) {
                if (numbers[n - i * i - j * j]) {
                    min = 3
                    break
                }
            }
        }
    }
    println(min)
}
