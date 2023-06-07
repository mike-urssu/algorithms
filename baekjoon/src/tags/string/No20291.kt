package tags.string

/**
 * https://www.acmicpc.net/problem/20291
 */
fun main() {
    val n = readln().toInt()
    val filenames = Array(n) { readln() }
    val groups = filenames.groupBy { it.substringAfter(".") }.toSortedMap()
    groups.forEach { (extension, filenames) -> println("$extension ${filenames.size}") }
}
