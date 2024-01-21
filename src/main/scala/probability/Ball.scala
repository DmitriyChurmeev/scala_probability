package probability

import probability.Ball.{BLACK_COLOR, WHITE_COLOR}

/**
 * Шар для вычисления случайности
 *
 * @param color цвет щара
 * @param isSelected признак
 */
class Ball(color: String, var isSelected: Boolean) {

  def selected() {
    isSelected = false
  }

  def isBlackColor(): Boolean = {
    color == BLACK_COLOR
  }

  def isWhiteColor(): Boolean = {
    color == WHITE_COLOR
  }

}

object Ball{
  val BLACK_COLOR = "BLACK"
  val WHITE_COLOR = "WHITE"
}
