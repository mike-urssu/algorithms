package tags.math

/**
 * https://www.acmicpc.net/problem/17294
 */
fun main() {
    val k = readln()
    val s = if (k.length == 1 || isCute(k)) {
        "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!"
    } else {
        "흥칫뿡!! <(￣ ﹌ ￣)>"
    }
    println(s)
}

private fun isCute(k: String): Boolean {
    val diff = k[1].digitToInt() - k[0].digitToInt()
    return (1 until k.length).all { diff == k[it].digitToInt() - k[it - 1].digitToInt() }
}
