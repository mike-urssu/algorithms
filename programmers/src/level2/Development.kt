package level2

import java.util.Stack
import kotlin.math.ceil

class Development {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val workingDays = IntArray(progresses.size) { i -> ceil((100 - progresses[i]) / speeds[i].toDouble()).toInt() }
        val deployCounts = arrayListOf<Int>()
        val stack = Stack<Int>()

        var maxWorkingDay = 0
        for (workingDay in workingDays) {
            if (stack.isEmpty()) {
                stack.push(workingDay)
                maxWorkingDay = workingDay
            } else {
                if (maxWorkingDay < workingDay) {
                    deployCounts.add(stack.size)
                    stack.removeAllElements()
                    maxWorkingDay = workingDay
                }
                stack.push(workingDay)
            }
        }
        if (stack.size != 0)
            deployCounts.add(stack.size)
        return deployCounts.toIntArray()
    }
}

fun main() {
    val development = Development()
    var progresses = intArrayOf(93, 30, 55)
    var speeds = intArrayOf(1, 30, 5)
    println(development.solution(progresses, speeds).contentEquals(intArrayOf(2, 1)))

    progresses = intArrayOf(95, 90, 99, 99, 80, 99)
    speeds = intArrayOf(1, 1, 1, 1, 1, 1)
    println(development.solution(progresses, speeds).contentEquals(intArrayOf(1, 3, 2)))

    progresses = intArrayOf(20, 99, 93, 30, 55, 10)
    speeds = intArrayOf(5, 10, 1, 1, 30, 5)
    println(development.solution(progresses, speeds).contentEquals(intArrayOf(3, 3)))

    progresses = intArrayOf(96, 99, 98, 97)
    speeds = intArrayOf(1, 1, 1, 1)
    println(development.solution(progresses, speeds).contentEquals(intArrayOf(4)))

    progresses = intArrayOf(40, 93, 30, 55, 60, 65)
    speeds = intArrayOf(60, 1, 30, 5, 10, 7)
    println(development.solution(progresses, speeds).contentEquals(intArrayOf(1, 2, 3)))

    progresses = intArrayOf(93, 30, 55, 60, 40, 65)
    speeds = intArrayOf(1, 30, 5, 10, 60, 7)
    println(development.solution(progresses, speeds).contentEquals(intArrayOf(2, 4)))
}
