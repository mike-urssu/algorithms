package level2

import kotlin.math.ceil

/**
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 */
class Solution {
    fun solution(w: Int, h: Int): Long {
        val gcd = getGCD(w, h)
        val x = (w / gcd).toLong()
        val y = (h / gcd).toLong()

        var squaresInMinimumRectangle = 0L
        for (i in 1 until x) {
            val dy = (ceil((y * i) / x.toDouble())).toInt()
            squaresInMinimumRectangle += (y - dy)
        }
        squaresInMinimumRectangle *= gcd

        var rectangles = 0L
        for (i in gcd - 1 downTo 1)
            rectangles += x * y * i.toLong()

        return (squaresInMinimumRectangle + rectangles) * 2
    }

    private fun getGCD(w: Int, h: Int): Int {
        var num1 = w
        var num2 = h
        while (num2 != 0) {
            val remainder = num1 % num2
            num1 = num2
            num2 = remainder
        }
        return num1
    }
}

fun main() {
    val solution = Solution()
    println(solution.solution(8, 12) == 80L)
    println(solution.solution(100000000, 99999999) == 9999999700000004L)
}