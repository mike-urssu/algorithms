package tags.string

/**
 * https://www.acmicpc.net/problem/17863
 */
fun main() {
    val s = readln()
    val prefixNumber = s.substring(0, 3)
    if (prefixNumber == "555") {
        println("YES")
    } else {
        println("NO")
    }
}
