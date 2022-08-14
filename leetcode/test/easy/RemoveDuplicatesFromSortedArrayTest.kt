package easy

fun main() {
    isValid(intArrayOf(1, 1, 2), intArrayOf(1, 2))
    isValid(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), intArrayOf(0, 1, 2, 3, 4))
    isValid(intArrayOf(-1, 0, 0, 0, 0, 3), intArrayOf(-1, 0, 3))
}

private fun isValid(nums: IntArray, expectedNums: IntArray) {
    val removeDuplicatesFromSortedArray = RemoveDuplicatesFromSortedArray()
    val k = removeDuplicatesFromSortedArray.removeDuplicates(nums)
    assert(k == expectedNums.size)
    for (i in 0 until k)
        assert(nums[i] == expectedNums[i])
}