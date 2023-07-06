package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2386
 */
fun main() {
    while (true) {
        val line = readln()
        if (line == "#") {
            break
        }

        val alphabet = line[0]
        val sentence = line.substring(2).lowercase()
        println("$alphabet ${sentence.count { it == alphabet }}")
    }
}
