package ProblemSolving

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the kaprekarNumbers function below.
fun kaprekarNumbers(p: Int, q: Int): Unit {

    var count =0

    for (num in p..q){

        if(isKaprekar(num.toLong())){
            print("$num ")
            count++
        }
    }

    if(count==0){
        print("INVALID RANGE")
    }


}

fun isKaprekar(num : Long) : Boolean{

    var sqNum : Long = num*num
    val d = num.toString().length

    while(sqNum.toString().length != 2*d && sqNum.toString().length != 2*d -1){
        sqNum *=sqNum
    }

    val sqNumString = sqNum.toString()
    val cutIndex = sqNumString.length - d
    var l = sqNumString.substring(0, cutIndex)

    if(l.isEmpty()){
        l ="0"
    }

    val r = sqNumString.substring(cutIndex)

    return l.toLong() + r.toLong() == num
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val p = scan.nextLine().trim().toInt()

    val q = scan.nextLine().trim().toInt()

    kaprekarNumbers(p, q)
}
