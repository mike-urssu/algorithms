package tags.string

/**
 * https://www.acmicpc.net/problem/30402
 */
fun main() {
    val picture = Array(15) { readln().split(" ").map { it[0] }.toCharArray() }
    val name = if (picture.any { it.any { it == 'w' } }) {
        "chunbae"
    } else if (picture.any { it.any { it == 'b' } }) {
        "nabi"
    } else {
        "yeongcheol"
    }
    println(name)
}
