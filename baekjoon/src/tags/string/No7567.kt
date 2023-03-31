package tags.string

/**
 * https://www.acmicpc.net/problem/7567
 */
fun main() {
    var previous = ' '
    val height = readln().sumOf {
        if (it == previous) {
            5
        } else {
            previous = it
            10
        }.toInt()
    }
    println(height)
}
