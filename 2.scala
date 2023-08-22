object Q2 extends App{
  class rational(n:Int,m:Int){

    require(m!= 0, message = "denominator can't be zero")

    def GCD(n:Int,m:Int):Int = m match {
      case  0 => n
      case x if x > n => GCD(x,n)
      case x if x <= n => GCD(x,n%x)
    }

    val gcdval = GCD(n.abs,m.abs)

    val numer = n/gcdval
    val denom = m/gcdval

    def sub(that:rational):rational = {
      new rational(numer * that.denom - that.numer * denom, denom * that.denom)
    }
      override def toString: String = s"$numer/$denom"



  }
  object rational{
    def apply(n:Int,m:Int):rational = new rational(n,m)
  }

  val x = rational(3, 4)
  val y = rational(5, 8)
  val z = rational(2, 7)

  var result = x.sub(y).sub(z)
//  var result2 = result.sub(z)

  println(result)



}