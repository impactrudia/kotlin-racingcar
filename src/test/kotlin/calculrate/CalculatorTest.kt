package calculrate

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 Null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String?) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            Operator.of("!")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource("2 + 3,5", "2 + 3 + 3,8", "2 + 3 + 10,15")
    fun `덧셈`(input: String, expected: Int?) {
        val actual = Calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("10 - 2 - 3,5", "2 - 2,0")
    fun `뺄셈`(input: String, expected: Int?) {
        val actual = Calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2 * 2 * 2,8", "3 * 3,9", "2 * 3 * 4,24")
    fun `곱셈`(input: String, expected: Int?) {
        val actual = Calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("10 / 2,5", "20 / 4 / 5,1")
    fun `나눗셈`(input: String, expected: Int?) {
        val actual = Calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("10 * 2 + 2 - 5,17", "2 + 3 - 1 / 2,2", "20 + 1 - 11 / 2,5")
    fun `사칙 연신을 모두 포함하는 기능 구현`(input: String, expected: Int?) {
        val actual = Calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }
}
