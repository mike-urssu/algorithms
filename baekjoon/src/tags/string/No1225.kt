package tags.string

/**
 * https://www.acmicpc.net/problem/1225
 */
fun main() {
    val (a, b) = readln().split(" ")
    var sum = 0L
    for (i in a) {
        for (j in b) {
            sum += i.digitToInt() * j.digitToInt()
        }
    }
    println(sum)
}
