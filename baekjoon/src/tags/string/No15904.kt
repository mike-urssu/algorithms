package tags.string

/**
 * https://www.acmicpc.net/problem/15904
 */
fun main() {
    val characters = charArrayOf('U', 'C', 'P', 'C')
    var index = 0

    val s = readln()
    for (c in s) {
        if (c == characters[index]) {
            index++
        }
        if (index == 4) {
            break
        }
    }

    if (index == 4) {
        println("I love UCPC")
    } else {
        println("I hate UCPC")
    }
}
