package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/6889
 */
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val adjectives = Array(n) { readln() }
    val nouns = Array(m) { readln() }

    adjectives.forEach { adjective ->
        nouns.forEach { noun ->
            println("$adjective as $noun")
        }
    }
}
