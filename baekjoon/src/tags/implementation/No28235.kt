package tags.implementation

/**
 * https://www.acmicpc.net/problem/28235
 */
fun main() {
    val input = readln()
    val output = when (input) {
        "SONGDO" -> "HIGHSCHOOL"
        "CODE" -> "MASTER"
        "2023" -> "0611"
        else -> "CONTEST"
    }
    println(output)
}
