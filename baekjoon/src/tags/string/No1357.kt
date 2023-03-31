package tags.string

/**
 * https://www.acmicpc.net/problem/1357
 */
fun main() {
    val (x, y) = readln().split(" ")
    println(rev(rev(x) + rev(y)))
}

private fun rev(x: Int) = rev(x.toString())

private fun rev(x: String) = x.reversed().toInt()
