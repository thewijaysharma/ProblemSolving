package ProblemSolving

fun main() {
    val maxSum : Int = getMaxSumSubarray(arrayOf(-2,1,4,-19,2,3,-2,5,-7))
    print(maxSum)
}

private fun getMaxSumSubarray(arr: Array<Int>): Int {

    var maxSum = arr[0]
    var calculatedSum = arr[0]

    for(i in 1 until arr.size) {

        if(arr[i] > (calculatedSum + arr[i])){
            calculatedSum = arr[i]
        }else{
            calculatedSum += arr[i]
        }

        if(calculatedSum > maxSum){
            maxSum = calculatedSum
        }

    }


    return maxSum

}