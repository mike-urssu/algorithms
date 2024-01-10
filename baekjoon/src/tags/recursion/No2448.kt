package tags.recursion

/**
 * https://www.acmicpc.net/problem/2448
 */
private lateinit var stars: Array<CharArray>

fun main() {
    val n = readln().toInt()
    stars = Array(n) { CharArray(2 * n - 1) { ' ' } }
    setStars(n, 0, n - 1)
    stars.forEach { println(it.joinToString("")) }
}

private fun setStars(n: Int, x: Int, y: Int) {
    if (n == 3) {
        stars[x][y] = '*'
        stars[x + 1][y - 1] = '*'
        stars[x + 1][y + 1] = '*'
        (y - 2..y + 2).forEach { j -> stars[x + 2][j] = '*' }
        return
    }

    setStars(n / 2, x, y)
    setStars(n / 2, x + n / 2, y - n / 2)
    setStars(n / 2, x + n / 2, y + n / 2)
}
