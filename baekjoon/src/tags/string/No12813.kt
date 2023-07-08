package tags.string

/**
 * https://www.acmicpc.net/problem/12813
 */
fun main() {
    val a = readln()
    val b = readln()
    println(and(a, b))
    println(or(a, b))
    println(xor(a, b))
    println(not(a))
    println(not(b))
}

private fun and(a: String, b: String): String {
    val and = StringBuilder()
    for (i in a.indices) {
        if (a[i] == '1' && b[i] == '1') {
            and.append('1')
        } else {
            and.append('0')
        }
    }
    return and.toString()
}

private fun or(a: String, b: String): String {
    val or = StringBuilder()
    for (i in a.indices) {
        if (a[i] == '1' || b[i] == '1') {
            or.append('1')
        } else {
            or.append('0')
        }
    }
    return or.toString()
}

private fun xor(a: String, b: String): String {
    val xor = StringBuilder()
    for (i in a.indices) {
        if (a[i] != b[i]) {
            xor.append('1')
        } else {
            xor.append('0')
        }
    }
    return xor.toString()
}

private fun not(a: String): String {
    val not = StringBuilder()
    for (i in a.indices) {
        if (a[i] == '1') {
            not.append('0')
        } else {
            not.append('1')
        }
    }
    return not.toString()
}
