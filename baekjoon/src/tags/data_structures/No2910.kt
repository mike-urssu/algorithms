package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2910
 */
fun main() {
    val (_, _) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }

    val counts = mutableMapOf<Int, Int>()
    val orders = mutableMapOf<Int, Int>()

    var order = 1
    numbers.forEach { v ->
        if (!counts.contains(v)) {
            orders[v] = order++
        }
        counts[v] = (counts[v] ?: 0) + 1
    }

    val sortedEntries = counts.entries.sortedWith { it, other ->
        if (it.value == other.value) {
            orders[it.key]!!.compareTo(orders[other.key]!!)
        } else {
            -it.value.compareTo(other.value)
        }
    }

    val sequence = StringBuilder()
    sortedEntries.forEach { entry ->
        repeat(entry.value) {
            sequence.append("${entry.key} ")
        }
    }
    println(sequence)
}
