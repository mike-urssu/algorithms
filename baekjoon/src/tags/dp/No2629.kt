package tags.dp

/**
 * https://www.acmicpc.net/problem/2629
 */
import kotlin.math.abs

fun main() {
    readln()
    val weights = readln().split(" ").map { it.toInt() }.toIntArray()
    readln()
    val marbles = readln().split(" ").map { it.toInt() }.toIntArray()

    val areMeasurable = areMeasurable(weights)
    marbles.forEach { marble ->
        if (areMeasurable[marble]) {
            print("Y ")
        } else {
            print("N ")
        }
    }
}

private fun areMeasurable(weights: IntArray): BooleanArray {
    val measurable = BooleanArray(40001)
    weights.forEach { weight ->
        val indices = mutableSetOf<Int>()
        (0..40000)
            .filter { i -> measurable[i] }
            .forEach { i ->
                if (abs(i - weight) >= 0) {
                    indices.add(abs(i - weight))
                }
                if (i + weight <= 40000) {
                    indices.add(i + weight)
                }
            }
        indices.forEach { i -> measurable[i] = true }
        measurable[weight] = true
    }
    return measurable
}
