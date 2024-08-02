package tags.string

/**
 * https://www.acmicpc.net/problem/18409
 */
fun main() {
    val vowels = charArrayOf('a', 'e', 'i', 'o', 'u')
    readln()
    val s = readln()
    println(s.count { it in vowels })
}
