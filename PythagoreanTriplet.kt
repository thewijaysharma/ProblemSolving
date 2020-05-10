package ProblemSolving

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.sqrt

fun main() {
    var ans : String = isPythagoreanTripllet(arrayOf(8,25,6,4,1,11))
    print(ans)
}

fun isPythagoreanTripllet(arr: Array<Int>): String {

    val dic = HashMap<Double, Int>()

    for (num in arr){
        dic[num.toDouble()] = 1
    }

    for(i in 0 until arr.size){
        for(j in 0 until arr.size){
            val x = sqrt(((arr[i]*arr[i]) + (arr[j]*arr[j])).toDouble())

            if(dic[x]!=null){
                return "Yes"
            }
        }
    }

    return "No"

}
