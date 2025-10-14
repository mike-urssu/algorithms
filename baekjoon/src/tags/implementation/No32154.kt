package tags.implementation

/**
 * https://www.acmicpc.net/problem/32154
 */
fun main() {
    val teams = arrayOf(
        charArrayOf(),
        charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'L', 'M'),
        charArrayOf('A', 'C', 'E', 'F', 'G', 'H', 'I', 'L', 'M'),
        charArrayOf('A', 'C', 'E', 'F', 'G', 'H', 'I', 'L', 'M'),
        charArrayOf('A', 'B', 'C', 'E', 'F', 'G', 'H', 'L', 'M'),
        charArrayOf('A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'),
        charArrayOf('A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'),
        charArrayOf('A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'),
        charArrayOf('A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'),
        charArrayOf('A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'),
        charArrayOf('A', 'B', 'C', 'F', 'G', 'H', 'L', 'M'),
    )

    val n = readln().toInt()
    println(teams[n].size)
    println(teams[n].joinToString(" "))
}
