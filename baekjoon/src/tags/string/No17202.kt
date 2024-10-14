package tags.string

/**
 * https://www.acmicpc.net/problem/17202
 */
fun main() {
    val s1 = readln()
    val s2 = readln()

    var numbers = IntArray(16)
    s1.indices.forEach { i -> numbers[i * 2] = s1[i].digitToInt() }
    s2.indices.forEach { i -> numbers[i * 2 + 1] = s2[i].digitToInt() }

    while (numbers.size > 2) {
        val temp = IntArray(numbers.size - 1)
        temp.indices.forEach { i ->
            temp[i] = (numbers[i] + numbers[i + 1]) % 10
        }
        numbers = temp
    }

    println(numbers.joinToString(""))
}
