package tags.sorting

/**
 * https://www.acmicpc.net/problem/9946
 */
fun main() {
    var index = 1
    while (true) {
        val s1 = readln()
        val s2 = readln()
        if (s1 == "END" && s2 == "END") {
            break
        }
        if (isValid(s1, s2)) {
            println("Case ${index++}: same")
        } else {
            println("Case ${index++}: different")
        }
    }
}

private fun isValid(s1: String, s2: String) =
        IntArray(26).apply {
            s1.forEach { this[it - 'a']++ }
            s2.forEach { this[it - 'a']-- }
        }.all { it == 0 }
