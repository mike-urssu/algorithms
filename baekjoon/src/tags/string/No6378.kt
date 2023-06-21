package tags.string

/**
 * https://www.acmicpc.net/problem/6378
 */
fun main() {
    while (true) {
        val n = readln()
        if (n == "0") {
            break
        }
        var sum = n.sumOf { it.digitToInt() }.toString()
        while (sum.length != 1) {
            sum = sum.sumOf { it.digitToInt() }.toString()
        }
        println(sum)
    }
}
