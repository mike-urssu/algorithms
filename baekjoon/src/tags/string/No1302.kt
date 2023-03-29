package tags.string

/**
 * https://www.acmicpc.net/problem/1302
 */
fun main() {
    val n = readln().toInt()
    val books = sortedMapOf<String, Int>()
    repeat(n) {
        val name = readln()
        books[name] = books.getOrDefault(name, 0) + 1
    }

    val max = books.values.max()
    println(books.keys.first { books[it] == max })
}
