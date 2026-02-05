package tags.string

/**
 * https://www.acmicpc.net/problem/18698
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val s = readln()
        var count = 0
        var i = 0
        while (i < s.length && s[i] == 'U') {
            count++
            i++
        }
        println(count)
    }
}
