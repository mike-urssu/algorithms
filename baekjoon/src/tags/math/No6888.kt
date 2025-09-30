package tags.math

/**
 * https://www.acmicpc.net/problem/6888
 */
fun main() {
    val x = readln().toInt()
    val y = readln().toInt()
    (x..y step 60).forEach { println("All positions change in year $it") }
}
