package tags.recursion

/**
 * https://www.acmicpc.net/problem/10994
 */
fun main() {
    val n = readln().toInt()
    val heads = mutableListOf<String>()
    val tails = mutableListOf<String>()

    val lastIndex = (n - 1) shl 2
    val stars1 = CharArray(lastIndex + 1) { '*' }
    val stars2 = CharArray(lastIndex + 1) { ' ' }

    var step1 = 1
    var step2 = 0
    for (i in 0..(n - 1) * 2) {
        val line = if (i % 2 == 0) {
            if (i != 0) {
                stars1[step1] = ' '
                stars1[lastIndex - step1] = ' '
                step1 += 2
            }
            stars1.joinToString("")
        } else {
            stars2[step2] = '*'
            stars2[lastIndex - step2] = '*'
            step2 += 2
            stars2.joinToString("")
        }
        heads.add(line)
        tails.add(line)
    }

    heads.forEach { println(it) }
    tails.removeLast()
    tails.reversed().forEach { println(it) }
}
