package tags.implementation

/**
 * https://www.acmicpc.net/problem/18917
 */
private val reader = System.`in`.bufferedReader()

fun main() {
    val m = reader.readLine().toInt()
    var sum = 0L
    var xor = 0L
    val str = StringBuilder()
    repeat(m) {
        val query = reader.readLine().split(" ").map { it.toInt() }
        when (query[0]) {
            1 -> {
                sum += query[1]
                xor = xor xor query[1].toLong()
            }

            2 -> {
                sum -= query[1]
                xor = xor xor query[1].toLong()
            }

            3 -> str.append("$sum\n")
            4 -> str.append("$xor\n")
        }
    }
    println(str)
}
