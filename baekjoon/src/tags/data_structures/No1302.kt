package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1302
 */
import java.util.SortedMap

fun main() {
    val n = readln().toInt()
    val books = getBooks(n)
    val max = books.values.max()
    val names = books.filter { it.value == max }.keys
    println(names.first())
}

private fun getBooks(n: Int): SortedMap<String, Int> {
    val names = sortedMapOf<String, Int>()
    repeat(n) {
        val name = readln()
        names[name] = (names[name] ?: 0) + 1
    }
    return names
}
