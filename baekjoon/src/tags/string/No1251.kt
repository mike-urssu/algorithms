package tags.string

/**
 * https://www.acmicpc.net/problem/1251
 */
fun main() {
    val s = readln()
    println(func(s))
}

private fun func(s: String): String {
    val sortedWords = sortedSetOf<String>()
    for (i in 1 until s.lastIndex) {
        for (j in i + 1 until s.length) {
            val word = s.substring(0, i).reversed() + s.substring(i, j).reversed() + s.substring(j).reversed()
            sortedWords.add(word)
        }
    }
    return sortedWords.first()
}
