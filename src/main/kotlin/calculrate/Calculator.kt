package calculrate

object Calculator {

    private const val isRemainderEven = 0
    private const val isRemainderOdd = 1

    fun calculate(expression: String?): Int {
        require(!expression.isNullOrBlank())

        val splits = expression.split(" ")
        val numbers = splits.filterIndexed { index, _ -> isEvenOrOdd(index, isRemainderEven) }.map { it.toInt() }
        val operators = splits.filterIndexed { index, _ -> isEvenOrOdd(index, isRemainderOdd) }.map { Operator.of(it) }

        return calculate(numbers, operators.toMutableList())
    }

    private fun isEvenOrOdd(index: Int, remainNumber: Int) = index % 2 == remainNumber

    private fun calculate(numbers: List<Int>, operators: MutableList<Operator>): Int {
        return numbers.reduce { first, second ->
            val operator = operators.removeFirst()
            operator.operation(first, second)
        }
    }
}
