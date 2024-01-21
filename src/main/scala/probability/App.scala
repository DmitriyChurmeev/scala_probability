package probability

import java.util.Random

object App {


  def main(args: Array[String]): Unit = {

    val count = 1000000
    val countOfBlackBalls = 3
    val countOfWhiteBalls = 3
    val random = new Random()
    val probabilityExperiments: List[ProbabilityExperiment] = List.fill(count)(new ProbabilityExperiment(countOfWhiteBalls, countOfBlackBalls, random))

    val countOfProbabilities = probabilityExperiments
      .count(experiment => experiment.isProbabilityWhiteColorIsFirstAndBlackColorIsSecond())

    val probability: Double = countOfProbabilities.toDouble / count
    println(f"Count of probability : ${probability}")

  }


}
