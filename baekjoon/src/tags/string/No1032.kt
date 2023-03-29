package tags.string

/**
 * https://www.acmicpc.net/problem/1032
 */
fun main() {
    val n = readln().toInt()
    val filenames = Array(n) { readln() }

    val pattern = StringBuilder()
    val filename = filenames.first()
    for (i in filename.indices) {
        if (filenames.all { it[i] == filename[i] }) {
            pattern.append(filename[i])
        } else {
            pattern.append('?')
        }
    }
    println(pattern.toString())
}
