package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/30455
 */
fun main() {
    val n = readln().toInt()
    val s = if (n % 2 == 0) {
        "Duck"
    } else {
        "Goose"
    }
    println(s)
}
