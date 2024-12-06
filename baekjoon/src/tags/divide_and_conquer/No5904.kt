package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/5904
 */
fun main() {
    val n = readln().toInt()
    val (k, l) = lengthide(n, 0, 3)
    println(moo(n, k, l))
}

private fun lengthide(n: Int, k: Int, l: Int): Pair<Int, Int> {
    if (n <= l) {
        return k to l
    }
    return lengthide(n, k + 1, l * 2 + k + 4)
}

private fun moo(n: Int, k: Int, l: Int): Char {
    if (k == 0) {
        return if (n == 1) {
            'm'
        } else {
            'o'
        }
    }

    val length = (l - (k + 3)) / 2
    return if (n in 1..length) {
        moo(n, k - 1, length)
    } else if (n in length + 1..length + k + 3) {
        if (n == length + 1) {
            'm'
        } else {
            'o'
        }
    } else {
        moo(n - (k + 3) - length, k - 1, length)
    }
}
