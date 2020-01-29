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

/*
 * Complete the 'taumBday' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER b
 *  2. INTEGER w
 *  3. INTEGER bc
 *  4. INTEGER wc
 *  5. INTEGER z
 */

fun taumBday(b: Long, w: Long, bc: Long, wc: Long, z: Long): Long {
    // Write your code here

    if(bc==wc){
        return (b*bc + w*wc).toLong()
    }else if(bc > wc){        //cost of black gift is more so we will convert white to black
        if((b*wc + w*wc + b*z) < (b*bc +w*wc)){
            return (b*wc + w*wc + b*z).toLong()
        }else{
            return (b*bc +w*wc).toLong()
        }
    }else{                  //cost of white gift is more
        if((w*bc + b*bc + w*z) < (b*bc +w*wc)){
            return (w*bc + b*bc + w*z).toLong()
        }else{
            return (b*bc +w*wc).toLong()
        }
    }

}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val b = first_multiple_input[0].toInt()

        val w = first_multiple_input[1].toInt()

        val second_multiple_input = readLine()!!.trimEnd().split(" ")

        val bc = second_multiple_input[0].toInt()

        val wc = second_multiple_input[1].toInt()

        val z = second_multiple_input[2].toInt()

        val result = taumBday(b.toLong(), w.toLong(), bc.toLong(), wc.toLong(), z.toLong())

        println(result)
    }
}

