package tags.implementation

/**
 * https://www.acmicpc.net/problem/23235
 */
fun main() {
    var t = 1
    while (true) {
        val n = readln().split(" ").map { it.toInt() }.first()
        if (n == 0) {
            break
        }
        println("Case ${t++}: Sorting... done!")
    }
}
