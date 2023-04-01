package tags.string

/**
 * https://www.acmicpc.net/problem/11365
 */
fun main() {
    while (true) {
        val line = readln()
        if (line == "END") {
            break
        }
        println(line.reversed())
    }
}
