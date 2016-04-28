import swing._
import event._
import scala.collection.mutable.HashMap

object Roomalaislaskin extends SimpleSwingApplication {
	var hash = new HashMap[Char, Int]
	hash += ('I' -> 1)
	hash += ('V' -> 5)
	hash += ('X' -> 10)
	hash += ('L' -> 50)
	hash += ('C' -> 100)
	hash += ('D' -> 500)
	hash += ('M' -> 1000)

  def top = new MainFrame {
    title = "Roomalaislaskin"
    object laskettava1 extends TextField { columns = 5 }
    object laskettava2 extends TextField { columns = 5 }
		object tulos extends TextField { columns = 5 }

		def fromRoman(merkkijono: String): Int = {
			var suurinLoytynyt = 0
			var luku = 0
			var loytynytMerkki = 0
			
	//		println("fromRoman: input = "+merkkijono)
			if(merkkijono.length>0) {
				for(i <- merkkijono.length-1 to 0 by -1) {
				//	println("merkki: "+merkkijono.charAt(i))
					loytynytMerkki = hash(merkkijono.charAt(i))
					if(suurinLoytynyt>loytynytMerkki) {
						luku = luku - loytynytMerkki
					} else {
						luku = luku + loytynytMerkki
						suurinLoytynyt = loytynytMerkki
					}
				//	println("i: "+i+", luku: "+luku)
				}
			} else {
			//	println("merkkijonon pituus: "+merkkijono.length)
			}
			//println("fromRoman: output = "+luku)
			luku
		}
		def oom(lukuParam: Int): Int = {
			var i = 0			
			var luku = lukuParam
			while(luku/10>0) {
				luku = luku/10
				i = i + 1
			}
			i
		}
		def osamaara(luku: Int, kokoluokka: Int): Int = {
			var apu = luku
			for(i <- 0 to kokoluokka-1) {
				apu = apu/10
			}
			return apu
		}
		def toRomanApu(lukuParam: Int, kokoluokka: Int): Int = {
			var luku = lukuParam
			//println("toRomanApu input: "+luku+", "+kokoluokka)
			if(luku<4) return 1
			if(luku<5) return 4
			if(luku<9) return 5
			if(luku<10) return 9
			for(i <- 0 to kokoluokka-1) {
				luku = luku/10
			}
			for(i <-0 to kokoluokka-1) {
				luku = luku*10
			} 
			//println("toRomanApu output: "+luku)
			return luku
		}
		def toRoman(lukuParam: Int): String = {
			//println("toRoman: Input = "+lukuParam)
			var toRomanHash = new HashMap[Int, String]
			toRomanHash += (900 -> "CM")
			toRomanHash += (800 -> "D")
			toRomanHash += (700 -> "D")
			toRomanHash += (600 -> "D")
			toRomanHash += (500 -> "D")
			toRomanHash += (400 -> "CD")
			toRomanHash += (300 -> "C")
			toRomanHash += (200 -> "C")
			toRomanHash += (100 -> "C")
			toRomanHash += (90 -> "XC")
			toRomanHash += (80 -> "L")
			toRomanHash += (70 -> "L")
			toRomanHash += (60 -> "L")
			toRomanHash += (50 -> "L")
			toRomanHash += (40 -> "XL")
			toRomanHash += (30 -> "X")
			toRomanHash += (20 -> "X")
			toRomanHash += (10 -> "X")
			toRomanHash += (9 -> "IX")
			toRomanHash += (8 -> "V")
			toRomanHash += (7 -> "V")
			toRomanHash += (6 -> "V")
			toRomanHash += (5 -> "V")
			toRomanHash += (4 -> "IV")
			toRomanHash += (3 -> "I")
			toRomanHash += (2 -> "I")
			toRomanHash += (1 -> "I")
			var mjono = ""
			var luku = lukuParam
			var kokoluokka = 0
			while(luku>0) {
				kokoluokka = oom(luku)
				if(kokoluokka>3) return "too large"
				else if(kokoluokka == 3) {
					if(osamaara(luku, kokoluokka)>3) return "too large"
					luku = luku-1000
					mjono += "M"
				} else {
					val roomalainenNumero = toRomanHash(toRomanApu(luku, kokoluokka))
					mjono += roomalainenNumero
					//println("merkki: "+roomalainenNumero)
					for(i <-roomalainenNumero.length-1 to 0 by -1) {
						if(i==roomalainenNumero.length-1) luku = luku - hash(roomalainenNumero.charAt(i))
						else luku = luku + hash(roomalainenNumero.charAt(i))
					}
				}
				//println("luku :"+luku)
			}
			println("toRoman: Output = "+mjono)
			mjono
		}
		def summaNappi = new Button {
			text="+"
			action = Action("+") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = fromRoman(laskettava2.text)
				val t = l1+l2
				tulos.text = toRoman(t)
			}
		}
		def erotusNappi = new Button {
			text="-"
			action = Action("-") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = fromRoman(laskettava2.text)
				val t = l1-l2
				tulos.text = toRoman(t)
			}
		}
		def tuloNappi = new Button {
			text="*"
			action = Action("*") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = fromRoman(laskettava2.text)
				val t = l1*l2
				tulos.text = toRoman(t)
			}
		}
		def osamaaraNappi = new Button {
			text="/"
			action = Action("/") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = fromRoman(laskettava2.text)
				val t = l1/l2
				tulos.text = toRoman(t)
			}
		}
		def INappi1 = new Button {
			text="I1"
			action = Action("I1") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = l1+1
				val t = toRoman(l2)
				laskettava1.text = t
			}
		}
		def VNappi1 = new Button {
			text="V1"
			action = Action("V1") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = l1+5
				val t = toRoman(l2)
				println(t)
				laskettava1.text = t
			}
		}
		def XNappi1 = new Button {
			text="X1"
			action = Action("X1") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = l1+10
				val t = toRoman(l2)
				laskettava1.text = t
			}
		}
	def LNappi1 = new Button {
			text="L1"
			action = Action("L1") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = l1+50
				val t = toRoman(l2)
				laskettava1.text = t
			}
		}
		def CNappi1 = new Button {
			text="C1"
			action = Action("C1") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = l1+100
				val t = toRoman(l2)
				println(t)
				laskettava1.text = t
			}
		}
		def DNappi1 = new Button {
			text="D1"
			action = Action("D1") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = l1+500
				val t = toRoman(l2)
				laskettava1.text = t
			}
		}
		def MNappi1 = new Button {
			text="M1"
			action = Action("M1") {
				val l1 = fromRoman(laskettava1.text)
				val l2 = l1+1000
				val t = toRoman(l2)
				laskettava1.text = t
			}
		}
		def INappi2 = new Button {
			text="I2"
			action = Action("I2") {
				val l1 = fromRoman(laskettava2.text)
				val l2 = l1+1
				val t = toRoman(l2)
				laskettava2.text = t
			}
		}
		def VNappi2 = new Button {
			text="V2"
			action = Action("V2") {
				val l1 = fromRoman(laskettava2.text)
				val l2 = l1+5
				val t = toRoman(l2)
				laskettava2.text = t
			}
		}
		def XNappi2 = new Button {
			text="X2"
			action = Action("X2") {
				val l1 = fromRoman(laskettava2.text)
				val l2 = l1+10
				val t = toRoman(l2)
				laskettava2.text = t
			}
		}
		def ansNappi1 = new Button {
			text="ans"
			action = Action("ans") {
				laskettava1.text = tulos.text
			}
		}
		def ansNappi2 = new Button {
			text="ans2"
			action = Action("ans2") {
				laskettava2.text = tulos.text
			}
		}
		val gridPanel1 = new GridPanel(1, 4) {
      contents += new Label(" Muuttuja 1  =  ")
      contents += laskettava1
      contents += new Label(" Muuttuja 2 = ")
			contents += laskettava2
    }
		val gridPanel2 = new GridPanel(1, 2) {
      contents += new Label("Tulos")
			contents += tulos
    }
		val gridPanel3 = new GridPanel(1, 4) {
      contents += summaNappi
			contents += erotusNappi
			contents += tuloNappi
			contents += osamaaraNappi
    }
		val gridPanel6 = new GridPanel(1, 2) {
      contents += ansNappi1
			contents += ansNappi2
    }
		val gridPanel4 = new GridPanel(1, 7) {
      contents += INappi1
			contents += VNappi1
			contents += XNappi1
			contents += LNappi1
			contents += CNappi1
			contents += DNappi1
			contents += MNappi1
    }
		val gridPanel5 = new GridPanel(1, 3) {
      contents += INappi2
			contents += VNappi2
			contents += XNappi2
    }
    contents = new BoxPanel(Orientation.Vertical) {
			
      border = Swing.EmptyBorder(15, 10, 10, 10)
			contents += gridPanel1
			contents += gridPanel2
			contents += gridPanel3
			contents += gridPanel6
			contents += gridPanel4
			contents += gridPanel5			
    }

    listenTo(laskettava1, laskettava2)

    reactions += {
      case EditDone(`laskettava2`) =>   // !!
				val l2 = laskettava2.text.toInt
				val jono = toRoman(l2) 
				laskettava2.text = jono		
      case EditDone(`laskettava1`) =>      // !!
				val l1 = laskettava1.text.toInt
				val jono = toRoman(l1) 
				laskettava1.text = jono				
    }
  }
}
