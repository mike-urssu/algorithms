package easy

fun main() {
    val searchInsertPosition = SearchInsertPosition()
    assert(searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 0) == 0)
    assert(searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 1) == 0)
    assert(searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 2) == 1)
    assert(searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 3) == 1)
    assert(searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 4) == 2)
    assert(searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 5) == 2)
    assert(searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 6) == 3)
    assert(searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 7) == 4)
}