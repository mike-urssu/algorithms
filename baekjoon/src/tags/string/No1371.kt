package tags.string

/**
 * https://www.acmicpc.net/problem/1371
 */
fun main() {
    val sentences = StringBuilder()
    while (true) {
        val s = readlnOrNull() ?: break
        sentences.append(s)
    }

    val counts = sentences
        .filter { it != ' ' }
        .groupingBy { it }.eachCount()
    val maxCount = counts.values.max()
    val letters = counts
        .filter { it.value == maxCount }
        .keys.sorted()
        .joinToString("")

    println(letters)
}
