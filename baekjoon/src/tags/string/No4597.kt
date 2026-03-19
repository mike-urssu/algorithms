package tags.string

/**
 * https://www.acmicpc.net/problem/4597
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == "#") {
            break
        }

        val count = s.count { it == '1' }
        val v = if (s.last() == 'e') {
            if (count % 2 == 0) {
                s.dropLast(1) + '0'
            } else {
                s.dropLast(1) + '1'
            }
        } else {
            if (count % 2 == 0) {
                s.dropLast(1) + '1'
            } else {
                s.dropLast(1) + '0'
            }
        }
        println(v)
    }
}
