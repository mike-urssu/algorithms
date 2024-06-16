package tags.implementation

/**
 * https://www.acmicpc.net/problem/2774
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val x = readln().toCharArray()
        println(x.distinct().size)
    }
}
