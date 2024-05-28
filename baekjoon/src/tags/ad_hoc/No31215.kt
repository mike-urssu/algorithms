package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/31215
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        if (n <= 2) {
            println(1)
        } else {
            println(3)
        }
    }
}
