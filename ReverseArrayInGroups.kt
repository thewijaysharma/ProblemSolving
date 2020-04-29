package ProblemSolving

fun main() {

    val k = 2
    val arr = arrayOf(10,20,30,40,50,60)

    arr.forEach { print("$it \t") }
    print("\n")

    var start = 0
    var end = k-1

    while (start < arr.size-1){

        reverseArray(arr, start, end)
        start += k
        end += k

        if(end > arr.size-1){
            end = arr.size-1
        }

    }

    arr.forEach { print("$it \t") }

}
