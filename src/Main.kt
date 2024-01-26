import kotlin.math.roundToInt

class Persona(
    val peso:Double,
    var altura:Double
){
    var nombre:String = ""
        set(value) {
            require(nombre.isBlank()) { "El nombre no puede ser nulo" }
            field = value
        }

    var imc = peso / (altura*2)

    constructor(peso: Double,altura: Double,nombre:String):this(peso,altura){
        this.nombre = nombre
    }


    override fun toString(): String {
        return """Persona: 
 peso: $peso
 altura: ${String.format("%.2f",this.imc)}
 imc: $imc 
 nombre: $nombre"""
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        if (this.nombre != other.nombre) return false
        if (this.altura != other.altura) return false
        if (this.peso != other.peso) return false
        return false
    }
}

fun main() {
    print("DiMe Tu NoMbRe: ")
    val nombre = readln()
    val persona1 = Persona(23.8,0.50,nombre)
    persona1.toString()

    val persona3 = Persona(43.3,1.72,"carlos")
    println(persona3)
    persona3.altura = 1.80
    println(persona3)

    val persona2 = Persona(123.2,1.9,"Van Dijk")
    persona2.altura = persona3.altura
    println(persona2)
    println(persona3)
    if (persona2.equals(persona3)) println("Las personas son iguales") else println("Las personas no son iguales")

}