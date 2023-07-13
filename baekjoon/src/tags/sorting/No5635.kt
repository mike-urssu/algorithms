package tags.sorting

/**
 * https://www.acmicpc.net/problem/5635
 */
fun main() {
    val n = readln().toInt()
    val namesAndBirthdays = Array(n) { readln().split(" ").toTypedArray() }
    val names = sortByBirthday(namesAndBirthdays).map { it[0] }
    println(names.first())
    println(names.last())
}

private fun sortByBirthday(namesAndBirthdays: Array<Array<String>>) =
    namesAndBirthdays.sortedArrayWith { it, other ->
        val d1 = it[1].toInt()
        val m1 = it[2].toInt()
        val y1 = it[3].toInt()
        val d2 = other[1].toInt()
        val m2 = other[2].toInt()
        val y2 = other[3].toInt()
        if (y1 == y2) {
            if (m1 == m2) {
                -d1.compareTo(d2)
            } else {
                -m1.compareTo(m2)
            }
        } else {
            -y1.compareTo(y2)
        }
    }
