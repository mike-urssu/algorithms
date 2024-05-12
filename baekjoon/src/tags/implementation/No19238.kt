package tags.implementation

/**
 * https://www.acmicpc.net/problem/19238
 */
import java.util.PriorityQueue
import kotlin.system.exitProcess

private var n = 0
private var m = 0
private var fuel = 0

private lateinit var graph: Array<IntArray>
private lateinit var passengers: BooleanArray
private lateinit var sources: Array<Pair<Int, Int>?>
private lateinit var destinations: Array<Pair<Int, Int>?>

private var taxiX = 0
private var taxiY = 0

fun main() {
    var input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    fuel = input[2]

    graph = getGraph()
    passengers = BooleanArray(m + 1)

    input = readln().split(" ").map { it.toInt() }
    taxiX = input[0]
    taxiY = input[1]

    sources = arrayOfNulls(m + 1)
    destinations = arrayOfNulls(m + 1)
    (1..m).forEach { i ->
        val (srcX, srcY, dstX, dstY) = readln().split(" ").map { it.toInt() }
        sources[i] = srcX to srcY
        destinations[i] = dstX to dstY
    }

    repeat(m) {
        var (index, d) = getClosestPassenger(taxiX, taxiY)
        val (srcX, srcY) = sources[index]!!
        moveTaxi(srcX, srcY, d)

        val (dstX, dstY) = destinations[index]!!
        d = getDistance(taxiX, taxiY, dstX, dstY)
        moveTaxi(dstX, dstY, d)

        fuel += d * 2
    }

    println(fuel)
}

private fun getGraph(): Array<IntArray> {
    val graph = Array(n + 1) { IntArray(n + 1) }
    (1..n).forEach { i -> readln().split(" ").map { it.toInt() }.toIntArray().copyInto(graph[i], 1) }
    return graph
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getClosestPassenger(taxiX: Int, taxiY: Int): Pair<Int, Int> {
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other ->
        val d = it.third.compareTo(other.third)
        if (d == 0) {
            val r = it.first.compareTo(other.first)
            if (r == 0) {
                it.second.compareTo(other.second)
            } else {
                r
            }
        } else {
            d
        }
    }
    val isVisited = Array(n + 1) { BooleanArray(n + 1) }

    queue.add(Triple(taxiX, taxiY, 0))
    isVisited[taxiX][taxiY] = true

    while (queue.isNotEmpty()) {
        val (x, y, d) = queue.poll()
        for (i in 1..m) {
            val (srcX, srcY) = sources[i]!!
            if (srcX == x && srcY == y && !passengers[i]) {
                if (fuel < d) {
                    println(-1)
                    exitProcess(0)
                }

                passengers[i] = true
                return i to d
            }
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 0) {
                isVisited[nextX][nextY] = true
                queue.add(Triple(nextX, nextY, d + 1))
            }
        }
    }

    println(-1)
    exitProcess(0)
}

private fun getDistance(srcX: Int, srcY: Int, dstX: Int, dstY: Int): Int {
    var distance = -1
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }
    val isVisited = Array(n + 1) { BooleanArray(n + 1) }
    queue.add(Triple(srcX, srcY, 0))
    isVisited[srcX][srcY] = true

    while (queue.isNotEmpty()) {
        val (x, y, d) = queue.poll()
        if (x == dstX && y == dstY) {
            distance = d
            break
        }
        (0 until 4).forEach { i ->
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 0) {
                isVisited[nextX][nextY] = true
                queue.add(Triple(nextX, nextY, d + 1))
            }
        }
    }

    if (distance == -1 || fuel < distance) {
        println(-1)
        exitProcess(0)
    }

    return distance
}

private fun moveTaxi(x: Int, y: Int, distance: Int) {
    taxiX = x
    taxiY = y
    fuel -= distance
}

private fun isInBoundary(x: Int, y: Int) =
    x in 1..n && y in 1..n
