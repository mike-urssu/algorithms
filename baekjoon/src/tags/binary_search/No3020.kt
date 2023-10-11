package tags.binary_search

/**
 * https://www.acmicpc.net/problem/3020
 */
fun main() {
    val (n, h) = readln().split(" ").map { it.toInt() }
    val obstacles = IntArray(n) { readln().toInt() }

    val obstaclesToDestroy = findObstaclesToDestroy(n, h, obstacles)
    val min = obstaclesToDestroy.min()
    println("$min ${obstaclesToDestroy.count { it == min }}")
}

private fun findObstaclesToDestroy(n: Int, h: Int, obstacles: IntArray): IntArray {
    val evenObstaclesToDestroy = getEvenObstaclesToDestroy(n, h, obstacles)
    val oddObstaclesToDestroy = getOddObstaclesToDestroy(n, h, obstacles)
    return IntArray(h) { i -> evenObstaclesToDestroy[i] + oddObstaclesToDestroy[i] }
}

private fun getEvenObstaclesToDestroy(n: Int, h: Int, obstacles: IntArray): IntArray {
    val o = obstacles.filterIndexed { i, _ -> i % 2 == 0 }.sorted()
    return IntArray(h) { i -> n / 2 - getLowerBound(o, i + 1) }
}

private fun getOddObstaclesToDestroy(n: Int, h: Int, obstacles: IntArray): IntArray {
    val o = obstacles.filterIndexed { i, _ -> i % 2 != 0 }.sorted()
    return IntArray(h) { i -> n / 2 - getLowerBound(o, h - i) }
}

private fun getLowerBound(numbers: List<Int>, n: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (numbers[mid] >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
