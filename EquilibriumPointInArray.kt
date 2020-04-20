package ProblemSolving

fun main() {

    val arr = arrayOf(5,1,3,4,0,2)
    val eq = getEquilibriumPoint(arr)
    print("Equilibrium point is $eq")

}

fun getEquilibriumPoint(array: Array<Int>) : Int{

    val leftSum = IntArray(array.size)
    val rightSum = IntArray(array.size)

    var sum = 0
    for (i in 0 until array.size){
        sum += array[i]
        leftSum[i] = sum
    }

    sum = 0
    for (i in array.size-1 downTo  0){
        sum += array[i]
        rightSum[i] = sum
    }

    for(i in 1 until array.size-1){
        if(leftSum[i-1] == rightSum[i+1]){
            return i
        }
    }

    return -1

}