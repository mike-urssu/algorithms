package tags.data_structures

/**
 * https://www.acmicpc.net/problem/13414
 */
private val reader = System.`in`.bufferedReader()
private val writer = System.out.bufferedWriter()

fun main() {
    val (k, l) = reader.readLine().split(" ").map { it.toInt() }
    val indices = mutableMapOf<String, Int>()
    repeat(l) { i ->
        val student = reader.readLine()
        indices[student] = i
    }

    val students = indices.toSortedMap { it, other -> indices[it]!!.compareTo(indices[other]!!) }
    students.keys.take(k)
        .forEach { writer.write("$it\n") }
    writer.flush()
}
