package ProblemSolving

fun main() {

    printNonRepeatingCharacters("aac")

}

fun printNonRepeatingCharacters(str : String){

    var lastNonRepeatingChar : Char? = null


    val map = HashMap<Char, Int>()

    for (char in str){

        val count = map[char] ?:  0

        //char occurred already
        if(count > 0){
            lastNonRepeatingChar = null
        }else{  //char occurred previously

            if(lastNonRepeatingChar==null){
                lastNonRepeatingChar = char
            }
        }

        map[char] = count+1

        if(lastNonRepeatingChar == null){
          print("-1\t")
        }else{
            print("$lastNonRepeatingChar\t")
        }

    }


}