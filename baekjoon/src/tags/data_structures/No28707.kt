package tags.data_structures

/**
 * https://www.acmicpc.net/problem/28707
 */
import java.util.PriorityQueue

fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toLong() }.toLongArray()
    val m = readln().toInt()
    val costs = Array(m) {
        val (l, r, c) = readln().split(" ").map { it.toInt() }
        intArrayOf(l - 1, r - 1, c)
    }

    val sortedNumbers = numbers.sortedArray()
    if (numbers.contentEquals(sortedNumbers)) {
        println(0)
        return
    }

    val queue = PriorityQueue<Pair<LongArray, Int>> { it, other -> it.second.compareTo(other.second) }
    queue.add(numbers to 0)
    val isVisited = mutableMapOf<Long, Int>()
    isVisited[parse(numbers)] = 0

    var min = Int.MAX_VALUE
    while (queue.isNotEmpty()) {
        val (array, sum) = queue.poll()
        if (array.contentEquals(sortedNumbers)) {
            min = minOf(min, sum)
            continue
        }

        for ((l, r, c) in costs) {
            val newArray = swap(array, l, r)
            val v = parse(newArray)
            if (!isVisited.contains(v) || sum + c < isVisited[v]!!) {
                queue.add(newArray to sum + c)
                isVisited[v] = sum + c
            }
        }
    }

    if (min == Int.MAX_VALUE) {
        min = -1
    }
    println(min)
}

private fun parse(numbers: LongArray): Long {
    return numbers.joinToString("").toLong()
}

private fun swap(array: LongArray, l: Int, r: Int): LongArray {
    val copy = array.copyOf()
    val temp = copy[l]
    copy[l] = copy[r]
    copy[r] = temp
    return copy
}
