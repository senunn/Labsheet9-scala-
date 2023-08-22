object Q1 extends App {

  def GCD(a: Int, b: Int): Int = b match {
    case 0 => a
    case x if x > a => GCD(x, a)
    case x if x < a => GCD(x, a % x)
  }

  class Rational(numer: Int, denom: Int) {
    require(denom != 0, "Denominator msute be nonzero")
    val gcdval = GCD(numer.abs, denom.abs)
    val n = numer / gcdval
    val d = denom / gcdval

    def neg: Rational = new Rational(-n, d)

    override def toString: String = s"$n/$d"


  }

  object Rational {

  def apply(n: Int, d: Int): Rational = new Rational(n, d)
}

  val x = Rational(3,4)
  val negX = x.neg

  println(x)
  println(negX)
}