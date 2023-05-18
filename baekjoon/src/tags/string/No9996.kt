package tags.string

/**
 * https://www.acmicpc.net/problem/9996
 */
fun main() {
    val n = readln().toInt()
    val pattern = Regex("^${readln().replace("*", ".*")}$")
    repeat(n) {
        val s = readln()
        if (s.matches(pattern)) {
            println("DA")
        } else {
            println("NE")
        }
    }
}
