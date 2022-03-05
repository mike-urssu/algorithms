package level2

/**
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 */
class Tuple {
    fun solution(s: String): IntArray {
        val subS = s.substring(1, s.length - 1)
        val arrays = arrayListOf<List<Int>>()
        var startBraceIndex: Int
        var endBraceIndex = 0
        while (true) {
            startBraceIndex = subS.indexOf('{', endBraceIndex)
            endBraceIndex = subS.indexOf('}', endBraceIndex + 1)

            if (startBraceIndex == -1)
                break

            val numbers = subS.substring(startBraceIndex + 1, endBraceIndex).split(',').map { it.toInt() }
            arrays.add(numbers)
        }
        arrays.sortWith(compareBy { it.size })

        val size = s.count { c: Char -> c == '{' } - 1
        val answer = IntArray(size)
        var index = 0
        val set = HashSet<Int>()
        for (array in arrays) {
            for (number in array) {
                if (!set.contains(number)) {
                    set.add(number)
                    answer[index++] = number
                }
            }
        }
        return answer
    }
}

fun main() {
    val solution = Tuple()
    var s = "{{2},{2,1},{2,1,3},{2,1,3,4}}"
    for (number in solution.solution(s))
        print("$number ")
    println()

    s = "{{1,2,3},{2,1},{1,2,4,3},{2}}"
    for (number in solution.solution(s))
        print("$number ")
    println()

    s = "{{20,111},{111}}"
    for (number in solution.solution(s))
        print("$number ")
    println()

    s = "{{123}}"
    for (number in solution.solution(s))
        print("$number ")
    println()

    s = "{{4,2,3},{3},{2,3,4,1},{2,3}}"
    for (number in solution.solution(s))
        print("$number ")
    println()
}