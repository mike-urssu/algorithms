package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2110
 */
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val houses = IntArray(n) { readln().toInt() }.sorted().toIntArray()
    println(getMaxDistance(n, c, houses))
}

private fun getMaxDistance(n: Int, c: Int, houses: IntArray): Int {
    var low = 0
    var high = 1000000000
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        val count = getCount(houses, n, c, mid)
        if (c <= count) {
            low = mid
        } else {
            high = mid
        }
    }
    return high
}

private fun getCount(houses: IntArray, n: Int, c: Int, distance: Int): Int {
    var count = 1
    var min = houses[0]
    for (i in 0 until n - 1) {
        if (houses[i + 1] - min > distance) {
            min = houses[i + 1]
            count++
        }
    }
    return count
}

//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//
///**
// * https://www.acmicpc.net/problem/2110
// */
//private val reader = BufferedReader(InputStreamReader(System.`in`))
//private val writer = BufferedWriter(OutputStreamWriter(System.out))
//
//private lateinit var houses: List<Int>
//private lateinit var numbers: Set<Int>
//
//fun main() {
//    val (n, c) = reader.readLine().split(" ").map { it.toInt() }
//    houses = IntArray(n) { reader.readLine().toInt() }.sorted()
//    numbers = houses.toSortedSet()
//
//    var low = 1
//    var high = houses.last()
//    while (low + 1 < high) {
//        val distance = (low + high) / 2
//        if (getCount(distance) >= c) {
//            low = distance
//        } else {
//            high = distance
//        }
//    }
//
//    writer.write("$low")
//    writer.flush()
//}
//
//private fun getCount(distance: Int): Int {
//    var count = 1
//    var currentNumber = houses.first()
//
//    while (true) {
//        val nextIndex = getNextIndex(currentNumber + distance)
//        if (nextIndex == houses.size) {
//            break
//        }
//        currentNumber = houses[nextIndex]
//        count++
//    }
//
//    return count
//}
//
//private fun getNextIndex(number: Int) =
//    if (numbers.contains(number)) {
//        houses.binarySearch(number)
//    } else {
//        -houses.binarySearch(number) - 1
//    }
