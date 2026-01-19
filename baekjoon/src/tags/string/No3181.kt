package tags.string

/**
 * https://www.acmicpc.net/problem/3181
 */
private val filters = arrayOf("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili")

fun main() {
    val s = readln()
    val words = s.split(" ")
    val shortenedWord = StringBuilder()
    shortenedWord.append(words[0][0])
    (1 until words.size).forEach { i ->
        val word = words[i]
        if (word !in filters) {
            shortenedWord.append(word[0])
        }
    }
    println(shortenedWord.toString().uppercase())
}
