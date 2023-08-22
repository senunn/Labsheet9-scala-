object rational extends App{
  def GCD(a: Int, b: Int): Int = b match {
    case 0 => a
    case x if x > a => GCD(x, a)
    case x if x < a => GCD(x, a % x)
  }

  class Rational(numer: Int, denom: Int) {
    require(denom != 0, "Denominator must be nonzero")
    val gcdval = GCD(numer.abs, denom.abs)
    val n = numer / gcdval
    val d = denom / gcdval

    def neg: Rational = new Rational(-n, d)

    println(s"$n/$d")


  }

  object Rational {

    def apply(n: Int, d: Int): Rational = new Rational(n, d)
  }

  val x = Rational(3, 4)
  x.neg


}
