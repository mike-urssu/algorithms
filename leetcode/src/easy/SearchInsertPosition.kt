package easy

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (target > nums.last())
            return nums.size
        else if (target < nums.first())
            return 0

        var low = 0
        var high = nums.size - 1
        var mid = (low + high) / 2

        while (low + 1 < high) {
            if (target < nums[mid])
                high = mid
            else
                low = mid
            mid = (low + high) / 2
        }

        return if (nums[mid] == target) mid else mid + 1
    }
}