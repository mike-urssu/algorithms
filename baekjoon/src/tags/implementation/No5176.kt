package tags.implementation

/**
 * https://www.acmicpc.net/problem/5176
 */
fun main() {
    val k = readln().toInt()
    repeat(k) {
        val (p, m) = readln().split(" ").map { it.toInt() }
        val seats = BooleanArray(m + 1)
        var count = 0
        repeat(p) {
            val n = readln().toInt()
            if (!seats[n]) {
                seats[n] = true
            } else {
                count++
            }
        }
        println(count)
    }
}
