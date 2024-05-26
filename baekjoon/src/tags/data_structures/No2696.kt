package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2696
 */
import java.util.PriorityQueue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val m = readln().toInt()
        val numbers = IntArray(m).apply {
            repeat((m + 9) / 10) { i ->
                val chunk = readln().split(" ").map { it.toInt() }.toIntArray()
                chunk.copyInto(this, i * 10)
            }
        }

        val medians = getMedians(numbers)
        println(medians.size)
        medians.chunked(10).forEach { println(it.joinToString(" ")) }
    }
}

private fun getMedians(numbers: IntArray): List<Int> {
    val medians = mutableListOf<Int>()
    val maxPriorityQueue = PriorityQueue<Int>(Comparator.reverseOrder())
    val minPriorityQueue = PriorityQueue<Int>()

    numbers.forEachIndexed { i, n ->
        if (i % 2 == 0) {
            if (minPriorityQueue.isNotEmpty() && n > minPriorityQueue.peek()) {
                val p = minPriorityQueue.poll()
                maxPriorityQueue.add(p)
                minPriorityQueue.add(n)
            } else {
                maxPriorityQueue.add(n)
            }
            medians.add(maxPriorityQueue.peek())
        } else {
            if (n < maxPriorityQueue.peek()) {
                val p = maxPriorityQueue.poll()
                minPriorityQueue.add(p)
                maxPriorityQueue.add(n)
            } else {
                minPriorityQueue.add(n)
            }
        }
    }
    return medians
}
