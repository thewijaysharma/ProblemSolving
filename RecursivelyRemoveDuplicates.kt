package ProblemSolving

fun main() {

    val str = "acaaabbbacdddd"
    val resultString = getDuplicatesRemovedString(str)
    print(resultString)
}

fun getDuplicatesRemovedString(str :String) : String{

    var last = str[0]
    var resultantString = ""

    var prevFoundPairs = false

    for(i in 1 until str.length){
        if(str[i] != last  && !prevFoundPairs){
            resultantString += last
        }

        prevFoundPairs = str[i] == last

        last = str[i]
    }

    //extra check for the boundary condition i.e the last char of the string
    if(str[str.lastIndex] != str[str.lastIndex-1]){
        resultantString+=str[str.lastIndex]
    }


    return resultantString

}