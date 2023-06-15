package tags.string

/**
 * https://www.acmicpc.net/problem/1755
 */
fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val numbersInEnglish = getNumbersInEnglish(m, n)
    numbersInEnglish.entries.chunked(10)
        .map { entry -> entry.map { it.value }.joinToString(" ") }
        .forEach { println(it) }
}

private fun getNumbersInEnglish(m: Int, n: Int): Map<String, Int> {
    val numbers = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val numbersInEnglish = sortedMapOf<String, Int>()
    (m..n).forEach { i ->
        numbersInEnglish[i.toString().toCharArray().joinToString(" ") { numbers[it.digitToInt()] }] = i
    }
    return numbersInEnglish
}
