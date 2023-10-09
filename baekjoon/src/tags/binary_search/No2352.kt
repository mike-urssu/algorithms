package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2352
 */
fun main() {
    readln()
    val ports = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getMaxConnections(ports))
}

private fun getMaxConnections(ports: IntArray): Int {
    val connections = mutableListOf<Int>()
    ports.forEach { port ->
        val index = getLowerBound(connections, port)
        if (index == -1 || index == connections.size) {
            connections.add(port)
        } else {
            connections[index] = port
        }
    }
    return connections.size
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
