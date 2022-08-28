package easy

import utils.ListNode
import java.math.BigInteger

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        val sum = getSumFromNodeList(l1) + getSumFromNodeList(l2)
        return getNodeListFromNumber(sum)
    }

    private fun getSumFromNodeList(listNode: ListNode?): BigInteger {
        var sum = BigInteger.ZERO
        var mul = BigInteger.ONE
        var currentNode = listNode

        while (currentNode != null) {
            sum = sum.plus(BigInteger.valueOf(currentNode.`val`.toLong()).multiply(mul))
            mul = mul.multiply(BigInteger.TEN)
            currentNode = currentNode.next
        }

        return sum
    }

    private fun getNodeListFromNumber(number: BigInteger): ListNode {
        val listNode = ListNode(number.mod(BigInteger.TEN).toInt())
        var currentNode = listNode

        var division = BigInteger.TEN
        while (number.divide(division) != BigInteger.ZERO) {
            val nextNode = ListNode(number.divide(division).mod(BigInteger.TEN).toInt())
            currentNode.next = nextNode
            currentNode = nextNode
            division = division.multiply(BigInteger.TEN)
        }

        return listNode
    }
}