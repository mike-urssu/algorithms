package tags.string

/**
 * https://www.acmicpc.net/problem/2789
 */
fun main() {
    val forbidden = arrayOf('C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E')
    val str = readln().filter { it !in forbidden }
    println(str)
}
