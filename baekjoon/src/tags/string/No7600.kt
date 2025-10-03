package tags.string

/**
 * https://www.acmicpc.net/problem/7600
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == "#") {
            break
        }
        val count = s.lowercase().filter { it in 'a'..'z' }.toCharArray().distinct().size
        println(count)
    }
}
