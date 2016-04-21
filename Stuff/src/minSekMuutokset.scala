object MinSek extends App{
	class MinSek(sekunnitArg: Int) {
		var sekunnit = sekunnitArg%60
		var minuutit = sekunnitArg/60
		def this(minuutitArg: Int, sekunnitArg: Int) {
			this(minuutitArg*60+sekunnitArg)
		}
		def this() {
			this(0)
		}
		def +(toinen:MinSek): MinSek = {
			val uusi = new MinSek((minuutit+toinen.getMinuutit), (sekunnit + toinen.getSekunnit))
			return uusi
		}
		def -(toinen:MinSek): MinSek = {
			val uusi = new MinSek((minuutit-toinen.getMinuutit), (sekunnit - toinen.getSekunnit))
			return uusi
		}
		def *(kerroin:Int): MinSek = {
			val uusi = new MinSek(minuutit*kerroin, sekunnit*kerroin)
			return uusi
		}
		def /(nimittaja:Int): MinSek = {
			val uusi = new MinSek((minuutit*60+sekunnit)/nimittaja)
			return uusi
		}
		def getSekunnit: Int = {
			sekunnit	
		}
		def getMinuutit: Int = {
			minuutit
		}
		def unary_- :MinSek = {
			val uusi = new MinSek(-minuutit, -sekunnit)
			return uusi
		}
		def +=(toinen:MinSek) = {
		  val total = (minuutit+toinen.getMinuutit)*60+sekunnit+toinen.getSekunnit
			minuutit=total/60
			sekunnit=total%60
		}
		def -=(toinen:MinSek) = {
		  val total = (minuutit-toinen.getMinuutit)*60+sekunnit-toinen.getSekunnit
			minuutit=total/60
			sekunnit=total%60
		}
		def +=(lisays:Int) = {
		  val total = minuutit*60+sekunnit+lisays
			minuutit=total/60
			sekunnit=total%60
		}
		def -=(lisays:Int) = {
		  val total = minuutit*60+sekunnit-lisays
			minuutit=total/60
			sekunnit=total%60
		}
		def *=(kerroin:Int) = {
		  val total = minuutit*60*kerroin+sekunnit*kerroin;
			minuutit=total/60
			sekunnit=total%60
		}
		def /=(nimittaja:Int)= {
			val total = (minuutit*60+sekunnit)/nimittaja
			minuutit=total/60
			sekunnit=total%60
		}
		def equals(verrattava: MinSek): Boolean= {
			(sekunnit==verrattava.sekunnit && minuutit==verrattava.minuutit)
		}
		override def toString(): String = {
			var string = ""
			if(minuutit<0 || sekunnit<0) string += "-"
			string += minuutit.abs.toString + ":"
			if(sekunnit.abs<10) string+="0"
			string += sekunnit.abs.toString
			return string
		}
	}	
	override def main(args: Array[String]) {
		var taltio = new Taltio
		var t1 = new Tallenne("Laa, laa, laulukappale", new MinSek(232))
		var t2 = new Tallenne("Soo, soo soittojuttu", new MinSek(220))
		var t3 = new Tallenne("Kissanviikset pakkasessa huurtuu", new MinSek(159))
		var t4 = new Tallenne("Noo oonkos tullut keesäää", new MinSek(236))
		var t5 = new Tallenne("Noo oonkos tullut keesäää", new MinSek(209))
		
	  taltio.lisaaTallenne(t1)
	  taltio.lisaaTallenne(t2)
	  taltio.lisaaTallenne(t3)
	  taltio.lisaaTallenne(t4)
	  taltio.lisaaTallenne(t5)
		println(taltio.toString)
	}
}