package easy

fun main() {
    val mergeTwoSortedLists = MergeTwoSortedLists()

    run {
        val list1 = ListNode(1)
        list1.next = ListNode(2)
        list1.next!!.next = ListNode(4)

        val list2 = ListNode(1)
        list2.next = ListNode(3)
        list2.next!!.next = ListNode(4)

        var mergedList = mergeTwoSortedLists.mergeTwoLists(list1, list2)

        var expectedList: ListNode? = ListNode(1)
        expectedList!!.next = ListNode(1)
        expectedList.next!!.next = ListNode(2)
        expectedList.next!!.next!!.next = ListNode(3)
        expectedList.next!!.next!!.next!!.next = ListNode(4)
        expectedList.next!!.next!!.next!!.next!!.next = ListNode(4)

        while (mergedList != null) {
            assert(mergedList.`val` == expectedList!!.`val`)
            mergedList = mergedList.next
            expectedList = expectedList.next
        }
    }

    assert(mergeTwoSortedLists.mergeTwoLists(null, null) == null)

    {
        var mergedList = mergeTwoSortedLists.mergeTwoLists(ListNode(0), null)
        var expectedList: ListNode? = ListNode(0)
        while (mergedList != null) {
            assert(mergedList!!.`val` == expectedList!!.`val`)
            mergedList = mergedList!!.next
            expectedList = expectedList!!.next
        }
    }
}