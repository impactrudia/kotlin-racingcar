package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10, 20])
    internal fun `자동차가 N대 생성된다`(carCount: Int) {
        val racingGame = RacingGame(carCount)
        assertThat(racingGame.cars.size).isEqualTo(carCount)
    }
}