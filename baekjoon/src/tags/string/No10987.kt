package tags.string

/**
 * https://www.acmicpc.net/problem/10987
 */
fun main() {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val line = readln()
    println(line.count { it in vowels })
}
