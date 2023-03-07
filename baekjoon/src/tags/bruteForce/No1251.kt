package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1251
 */
fun main() {
    val word = readln()
    val words = sortedSetOf<String>()

    for (i in 1 until word.length - 1) {
        for (j in i + 1 until word.length) {
            val newWord = listOf(
                word.substring(0, i).reversed(),
                word.substring(i, j).reversed(),
                word.substring(j).reversed()
            ).joinToString("")
            words.add(newWord)
        }
    }

    println(words.first())
}
