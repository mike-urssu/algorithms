package easy

import java.util.Arrays.sort

fun main() {
    isValid(intArrayOf(3, 2, 2, 3), 3, intArrayOf(2, 2))
    isValid(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2, intArrayOf(0, 1, 4, 0, 3).sortedArray())

    isValid(intArrayOf(), 3, intArrayOf())
    isValid(intArrayOf(0, 0, 0), 3, intArrayOf(0, 0, 0))
    isValid(intArrayOf(2), 3, intArrayOf(2))
    isValid(intArrayOf(3, 3), 3, intArrayOf())
}

private fun isValid(nums: IntArray, `val`: Int, expectedNums: IntArray) {
    val removeElement = RemoveElement()

    val k = removeElement.removeElement(nums, `val`)
    assert(k == expectedNums.size)

    sort(nums, 0, k)

    for (i in 0 until k)
        assert(nums[i] == expectedNums[i])
}