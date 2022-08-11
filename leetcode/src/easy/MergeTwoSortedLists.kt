package easy

class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return if (list1 == null)
            list2
        else if (list2 == null)
            list1
        else {
            if (list1.`val` < list2.`val`) {
                list1.next = mergeTwoLists(list1.next, list2)
                list1
            } else {
                list2.next = mergeTwoLists(list1, list2.next)
                list2
            }
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}