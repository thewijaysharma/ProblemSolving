package ProblemSolving

fun main() {

    val str  = arrayOf('a','a','a','a','b','b','a','a')
    printLongestPalindromeString(str)

}

fun printLongestPalindromeString(str: Array<Char>) {

    var maxLeftMost = 0
    var maxRightMost = 0

    for(i in 0 until str.size){

        var l = i
        var r = str.size-1

        val leftmost = l
        var rightmost = r

        while(l <= r){

            if(str[l] ==  str[r]){

                if(l == r || l+1 ==r){

                    if((rightmost-leftmost) > (maxRightMost-maxLeftMost)){
                        maxLeftMost = leftmost
                        maxRightMost = rightmost
                    }

                }

                l++
                r--

            }else{

                //reset left and right pointers
                l = i

                rightmost--
                r = rightmost


            }

        }



    }

    for(index in maxLeftMost..maxRightMost){
        print(str[index])
    }

}



