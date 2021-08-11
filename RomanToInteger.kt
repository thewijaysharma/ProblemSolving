class RomanToInteger {

    fun romanToInt(s: String): Int {

        val map = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

        var outputValue = 0
        var prevChar : Char? = null

        for(currentChar in s){
            val currentCharValue = map[currentChar] ?: 0

            prevChar?.let{
                val preCharValue = map[it] ?: 0

                if(preCharValue >= currentCharValue){
                    outputValue += currentCharValue
                }else{
                    outputValue = outputValue - 2 * preCharValue + currentCharValue
                }

            } ?: run {
                outputValue += currentCharValue
            }
            prevChar = currentChar
        }

        return outputValue
    }

}