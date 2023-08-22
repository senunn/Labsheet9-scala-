object Q3 extends App {
  val l: List[Int] = List(1, 2, 3, 4, 5, 6)
  val n:List[Int] = List(2,3,4,5,6,7)

  def negetingList(l:List[Int],n:List[Int]):Unit = {
    val combinedList = l.zip(n)
    val result = combinedList.map { case (x, y) => (-x.toDouble / y).toString }
    result.foreach(println)
  }

  negetingList(l, n)


}
