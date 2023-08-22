

object test2 extends App{
  class test(n:Int,m:Int){
    private def GCD(a:Int,b:Int):Int = if(b>a) GCD(b,a) else if (b==0) a else GCD(b,a%b)

    val GCDVal = GCD(n,m)
    var num = n/GCDVal
    val den = m/GCDVal

    println(s"this is it if you are pass $num and $den")
  }

  object test{
    def apply(n: Int, d: Int): test = new test(n, d)
  }

  test(4,9)

}
