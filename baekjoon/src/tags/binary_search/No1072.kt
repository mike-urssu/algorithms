package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1072
 */
fun main() {
    val (x, y) = readln().split(" ").map { it.toLong() }
    println(getGameCount(x, y))
}

private fun getGameCount(x: Long, y: Long): Int {
    val rate = y * 100 / x
    if (rate >= 99) {
        return -1
    }

    var low = 0
    var high = 1000000000
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (canChangeRate(rate, x, y, mid)) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun canChangeRate(rate: Long, x: Long, y: Long, count: Int) =
    (y + count) * 100 / (x + count) > rate

//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//
///**
// * https://www.acmicpc.net/problem/1072
// */
//private val reader = BufferedReader(InputStreamReader(System.`in`))
//private val writer = BufferedWriter(OutputStreamWriter(System.out))
//
//fun main() {
//    val (x, y) = reader.readLine().split(" ").map { it.toLong() }
//    val z = ((y * 100) / x).toInt()
//
//    if (z >= 99) {
//        writer.write("-1")
//    } else {
//        var low = 0
//        var high = 1000000000
//        while (low + 1 < high) {
//            val mid = (low + high) / 2
//            if ((y + mid) * 100 / (x + mid) > z) {
//                high = mid
//            } else {
//                low = mid
//            }
//        }
//
//        writer.write("$high")
//    }
//    writer.flush()
//}
