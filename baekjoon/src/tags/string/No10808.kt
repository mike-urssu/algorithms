package tags.string

/**
 * https://www.acmicpc.net/problem/10808
 */
fun main() {
    val characters = IntArray(26)
    readln().forEach { characters[it - 'a']++ }
    println(characters.joinToString(" "))
}
