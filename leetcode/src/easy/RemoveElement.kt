package easy

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0

        for (i in nums.indices) {
            if (nums[i] != `val`)
                nums[index++] = nums[i]
        }

        return index
    }
}
