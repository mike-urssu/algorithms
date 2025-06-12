package tags.string

/**
 * https://www.acmicpc.net/problem/29766
 */
fun main() {
    val s = readln()
    val count = (0 until s.length - 3).count { s.substring(it, it + 4) == "DKSH" }
    println(count)
}
