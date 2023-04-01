package tags.string

/**
 * https://www.acmicpc.net/problem/5635
 */
fun main() {
    val n = readln().toInt()
    val students = sortedSetOf<List<String>>(Comparator { it, other ->
        if (it[3] == other[3]) {
            if (it[2] == other[2]) {
                it[1].toInt() - other[1].toInt()
            } else {
                it[2].toInt() - other[2].toInt()
            }
        } else {
            it[3].toInt() - other[3].toInt()
        }
    })
    repeat(n) { students.add(readln().split(" ")) }

    println(students.last()[0])
    println(students.first()[0])
}
