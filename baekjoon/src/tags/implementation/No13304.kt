package tags.implementation

/**
 * https://www.acmicpc.net/problem/13304
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val students = getStudents(n)
    var rooms = (students[1].sum() + students[2].sum() + k - 1) / k
    rooms += (students[3][0] + students[4][0] + k - 1) / k
    rooms += (students[3][1] + students[4][1] + k - 1) / k
    rooms += (students[5][0] + students[6][0] + k - 1) / k
    rooms += (students[5][1] + students[6][1] + k - 1) / k
    println(rooms)
}

private fun getStudents(n: Int): Array<IntArray> {
    val students = Array(7) { IntArray(2) }
    repeat(n) {
        val (s, y) = readln().split(" ").map { it.toInt() }
        students[y][s]++
    }
    return students
}
