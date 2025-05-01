package tags.binary_search

/**
 * https://www.acmicpc.net/problem/16566
 */
import java.util.StringTokenizer

private var m = 0
private lateinit var blue: IntArray
private lateinit var parents: IntArray

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[1]
    val k = input[2]
    blue = IntArray(m)
    var tokens = StringTokenizer(readln())
    for (i in 0 until m) {
        blue[i] = tokens.nextToken().toInt()
    }
    blue.sort()

    parents = IntArray(m + 1) { it }

    val output = StringBuilder()
    tokens = StringTokenizer(readln())
    for (i in 0 until k) {
        val index = find(binarySearch(tokens.nextToken().toInt()))
        output.append("${blue[index]}\n")
        unionFind(index, index + 1)
    }
    println(output)
}

private fun binarySearch(n: Int): Int {
    var low = -1
    var high = m
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (blue[mid] > n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun find(n: Int): Int {
    if (n != parents[n]) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}

private fun unionFind(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)

    if (parentA != parentB) {
        parents[parentA] = parentB
    }
}
