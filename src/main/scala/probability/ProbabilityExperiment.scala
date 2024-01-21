package probability

import java.util.Random
import scala.collection.mutable.ArrayBuffer

/**
 * Класс для вычисление по формуле вероятности для черно\белых шаров
 *
 * @param whiteBallCount кол-во белых шаров учавствующих в вычислении
 * @param blackBallCount кол-во черных шаров учавствующих в вычислении
 * @param random Рандомайзер для вычисления "случайности"
 */
class ProbabilityExperiment(val whiteBallCount: Int, val blackBallCount: Int, val random: Random) {

  /**
   * Список шаров в "корзине" доступные для вычисления
   * В процессе список будет меняться, если шар будет "выбран" {@link  selectRandomBall}
   * то выбранные шар удаляется мз списка а размер массива будет изменен.
   */
  val ballsBox: ArrayBuffer[Ball] = generateBasket(whiteBallCount, blackBallCount)

  def isProbabilityWhiteColorIsFirstAndBlackColorIsSecond(): Boolean = {
    val firstBall = selectRandomBall()
    val secondBall = selectRandomBall()
    firstBall.isWhiteColor() && secondBall.isBlackColor()
  }

  /**
   * Из списка доступных шаров {@link ballsBox} извлекается случайный шар.
   * "Случайность" вычисляется благодаря {@link random}
   * @return Ball случайный шар
   */
  def selectRandomBall(): Ball = {
    val basketSize = ballsBox.size - 1
    val randomIndex = random.nextInt(basketSize)
    val ball = ballsBox(randomIndex)
    ball.selected()
    ballsBox.remove(randomIndex)
    ballsBox.trimToSize()
    ball
  }

  private def generateBasket(whiteBallCount: Int, blackBallCount: Int): ArrayBuffer[Ball] = {
    val value: ArrayBuffer[Ball] = ArrayBuffer.fill(whiteBallCount)(new Ball(Ball.WHITE_COLOR, false))
      .addAll(ArrayBuffer.fill(blackBallCount)(new Ball(Ball.BLACK_COLOR, false)))
    scala.util.Random.shuffle(value)
  }
}

