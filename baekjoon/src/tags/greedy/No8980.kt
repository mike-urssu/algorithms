package tags.greedy

/**
 * https://www.acmicpc.net/problem/8980
 */
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val boxes = Array(m) {
        val (src, dst, box) = readln().split(" ").map { it.toInt() }
        Triple(src, dst, box)
    }
    boxes.sortWith(comparator)

    println(getDeliveredBoxes(n, c, boxes))
}

private val comparator = Comparator<Triple<Int, Int, Int>> { it, other ->
    var comparison = it.second.compareTo(other.second)
    if (comparison == 0) {
        comparison = it.first.compareTo(other.first)
    }
    comparison
}

private fun getDeliveredBoxes(n: Int, c: Int, boxes: Array<Triple<Int, Int, Int>>): Int {
    val capacities = IntArray(n) { c }
    var sum = 0
    boxes.forEachIndexed { i, (src, dst, box) ->
        val min = minOf(box, (src until dst).minOf { capacities[it] })
        (src until dst).forEach { j -> capacities[j] -= min }
        sum += min
    }
    return sum
}
