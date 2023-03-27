package tags.string

/**
 * https://www.acmicpc.net/problem/2941
 */
fun main() {
    val alphabets = setOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var index = 0
    var count = 0
    val line = readln()

    while (index < line.length) {
        val substring = line.substring(index)
        index += alphabets.firstOrNull { substring.startsWith(it) }?.length ?: 1
        count++
    }
    println(count)
}
