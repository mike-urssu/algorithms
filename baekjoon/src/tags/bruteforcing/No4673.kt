package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/4673
 */
fun main() {
    val selfNumbers = sortedSetOf<Int>()
    for (i in 1..9973) {
        selfNumbers.add(getD(i))
    }

    (1..10000)
        .filter { !selfNumbers.contains(it) }
        .forEach { println(it) }
}

private fun getD(number: Int) = number + number.toString().toCharArray().sumOf { it.digitToInt() }
