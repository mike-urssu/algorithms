package tags.string

/**
 * https://www.acmicpc.net/problem/2608
 */
fun main() {
    val s1 = readln()
    val s2 = readln()

    val sum = parseToInt(s1) + parseToInt(s2)
    println(sum)
    println(parseToRome(sum))
}

private val units = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

private fun parseToInt(s: String): Int {
    var sum = 0
    var index = 0
    while (index < s.length) {
        if (index + 1 == s.length) {
            sum += units[s[index]]!!
            break
        }
        if (units[s[index]]!! < units[s[index + 1]]!!) {
            sum += -units[s[index]]!! + units[s[index + 1]]!!
            index += 2
        } else {
            sum += units[s[index]]!!
            index++
        }
    }
    return sum
}

private fun parseToRome(n: Int): String {
    val rome = StringBuilder()
    var n = n

    rome.append("M".repeat(n / 1000))
    n %= 1000

    if (n / 100 == 9) {
        rome.append("CM")
    } else if (n / 100 >= 5) {
        rome.append("D")
        rome.append("C".repeat((n - 500) / 100))
    } else if (n / 100 == 4) {
        rome.append("CD")
    } else {
        rome.append("C".repeat(n / 100))
    }
    n %= 100

    if (n / 10 == 9) {
        rome.append("XC")
    } else if (n / 10 >= 5) {
        rome.append("L")
        rome.append("X".repeat((n - 50) / 10))
    } else if (n / 10 == 4) {
        rome.append("XL")
    } else {
        rome.append("X".repeat(n / 10))
    }
    n %= 10

    if (n == 9) {
        rome.append("IX")
    } else if (n >= 5) {
        rome.append("V")
        rome.append("I".repeat(n - 5))
    } else if (n == 4) {
        rome.append("IV")
    } else {
        rome.append("I".repeat(n))
    }
    return rome.toString()
}
