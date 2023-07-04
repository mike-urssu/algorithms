package tags.string

/**
 * https://www.acmicpc.net/problem/2386
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == "#") {
            break
        }
        val alphabet = s[0]
        val sentence = s.substring(2).lowercase()
        println("$alphabet ${sentence.count { it == alphabet }}")
    }
}
