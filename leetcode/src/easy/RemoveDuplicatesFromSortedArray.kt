package easy

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var currentIndex = 0
        var currentNumber = Int.MIN_VALUE

        for (index in nums.indices) {
            if (currentNumber != nums[index]) {
                currentNumber = nums[index]
                nums[currentIndex++] = nums[index]
            }
        }

        return currentIndex
    }
}
