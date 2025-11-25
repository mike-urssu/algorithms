package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/20528
 */
fun main() {
    readln()
    val words = readln().split(" ")
    if (words.distinctBy { it[0] }.count() == 1) {
        println(1)
    } else {
        println(0)
    }
}
