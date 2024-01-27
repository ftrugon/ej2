import kotlin.math.roundToInt
/**
 * Clase que representa una persona con propiedades como peso, altura y nombre.
 *
 * @property peso El peso de la persona.
 * @property altura La altura de la persona.
 * @property nombre El nombre de la persona.
 * @property imc El índice de masa corporal (IMC) de la persona.
 *
 * @constructor Crea un objeto [Persona] con el peso y la altura especificados.
 * @param peso El peso de la persona.
 * @param altura La altura de la persona.
 *
 * @constructor Crea un objeto [Persona] con el peso, la altura y el nombre especificados.
 * @param peso El peso de la persona.
 * @param altura La altura de la persona.
 * @param nombre El nombre de la persona.
 */
class Persona(
    val peso:Double,
    var altura:Double
){
    var nombre:String = ""
        set(value) {
            require(nombre.isBlank()) { "El nombre no puede ser nulo" }
            field = value
        }

    /**
     * El índice de masa corporal (IMC) de la persona.
     */
    var imc = peso / (altura*2)

    /**
     * Constructor secundario que permite proporcionar también el nombre al crear una persona.
     */
    constructor(peso: Double,altura: Double,nombre:String):this(peso,altura){
        this.nombre = nombre
    }

    /**
     * Representación en cadena del objeto [Persona].
     *
     * @return Una cadena que representa el peso, la altura, el IMC y el nombre de la persona.
     */
    override fun toString(): String {
        return """Persona: 
     peso: $peso
     altura: ${String.format("%.2f",this.imc)}
     imc: $imc 
     nombre: $nombre"""
    }

    /**
     * Compara si dos objetos [Persona] son iguales.
     *
     * @return `true` si los objetos son iguales, `false` en caso contrario.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        if (this.nombre != other.nombre) return false
        if (this.altura != other.altura) return false
        if (this.peso != other.peso) return false
        return false
    }
}

/**
 * Función principal que interactúa con objetos [Persona] y los imprime.
 */
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