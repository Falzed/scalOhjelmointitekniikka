

object stuff1 extends App {
  {
    val lista = for (i <- 1 to 5; j <- i to 5; if i*j%2 != 0) yield(i*j)
    lista.foreach(println)
  }
  {
    println
    println("b")
    println
  
    val l = List(1,2,3,4,5)
    val m = Array(5,6,7,8,9)
    var a = 0; var b = 0
    l.foreach(x => {m(b)+=x; b+=1})
    m.foreach(println _)
  }
  {
    println
    println("c")
    println
  
    val a=1; val b=2; val c=3;
    { val b=4; val c=5;
      { val c=6;
        println(a +"/"+ b +"/"+ c);
      }
    println(a +"/"+ b +"/"+ c);
    }
  println(a +"/"+ b +"/"+ c)
  }
  {
    println
    println("d")
    println
    
    def f(n: String, i: Int)  {println(n + ": " + i)}
    def g(n: String)(i: Int) =  {println(n + ": " + i)}
    f("Funktio f", 100)
    g("Funktio g")(200)
  }
}