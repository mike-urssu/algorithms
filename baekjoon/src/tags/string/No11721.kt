package tags.string

/**
 * https://www.acmicpc.net/problem/11721
 */
fun main() {
    var word = readln()
    while (word.isNotEmpty()) {
        println(word.take(10))
        word = word.drop(10)
    }
}
