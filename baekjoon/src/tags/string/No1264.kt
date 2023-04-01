package tags.string

/**
 * https://www.acmicpc.net/problem/1264
 */
fun main() {
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u')
    while (true) {
        val line = readln()
        if (line == "#") {
            break
        }
        println(line.lowercase().count { it in vowels })
    }
}
