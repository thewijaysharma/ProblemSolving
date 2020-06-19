package ProblemSolving

fun main() {

    val n1 = Node(1)
    val n2 = Node(2)
    val n3 = Node(3)
    val n4 = Node(4)
    val n5 = Node(5)
    val n6 = Node(6)
    val n7 = Node(7)
    val n8 = Node(8)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6
    n6.next = n7
    n7.next = n8

    printLinkedList(n1)
    print("\n")

    val newHead = reverseLinkedList(n1)

    printLinkedList(newHead)

}


fun reverseLinkedList(headNode : Node) : Node{

    var current : Node? = headNode
    var prev : Node? = null

    while(current != null){
        val next =  current.next
        current.next = prev

        prev = current
        current = next

    }

    return prev!!


}

fun printLinkedList(headNode: Node ){

    var current : Node? =  headNode

    while (current!=null){
        print(" ${current.data}\t")
        current = current.next
    }
}