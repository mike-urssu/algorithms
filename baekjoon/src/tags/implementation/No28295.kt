package tags.implementation

/**
 * https://www.acmicpc.net/problem/28295
 */
fun main() {
    val directions = arrayOf('N', 'E', 'S', 'W')
    var index = 0
    repeat(10) {
        val t = readln().toInt()
        when (t) {
            1 -> index++
            2 -> index += 2
            3 -> index += 3
        }
    }
    println(directions[index % 4])
}
