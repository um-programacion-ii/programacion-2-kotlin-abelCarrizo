package org.example

// Escribir una interface perimetrable con un metodo calcularPerimetro()
interface perimetrable {
    fun calcularPerimetro(): Double
}

class Coche (private var _marca: String = "Ford", private var _modelo: Int = 2020) {
    var marca: String
        get() = _marca
        set(value) {
            _marca = value
        }

    var modelo: Int
        get() = _modelo
        set(value) {
            _modelo = value
        }
}

// Escribir una clase Rectangulo que implemente la interface Perimetrable
class Rectangulo(val ancho: Double, val alto: Double) : perimetrable {
    // calculada una sola vez
    val area: Double = ancho * alto

    override fun calcularPerimetro(): Double = 2 * (ancho + alto)
    override fun toString(): String = "Rectángulo(${ancho} x ${alto})"

    init {
        println("Se ha creado un rectángulo de $ancho x $alto con un área de $area")
    }

    fun describir() {
        println("Este es un rectángulo.")
    }
}

// Escribir una clase Circulo que implemente la interface Perimetrable
class Circulo(val radio: Double) : perimetrable {
    override fun calcularPerimetro(): Double = 2 * Math.PI * radio
    override fun toString(): String = "Círculo(r=$radio)"
}

fun main() {
    val coche = Coche("Chevrolet", 2025)
    println("Marca: ${coche.marca}")
    println("Modelo: ${coche.modelo}")

    val rectangulo = Rectangulo(10.0, 5.0)
    println("Área del rectángulo: ${rectangulo.area}")
    rectangulo.describir()

    val perimetro = rectangulo.calcularPerimetro()
    println("El perímetro del rectángulo es: $perimetro")

    val formas: List<perimetrable> = listOf(
        Rectangulo(10.0, 5.0),
        Circulo(3.0)
    )

    formas.forEach { f ->
        println("$f → perímetro = ${"%.2f".format(f.calcularPerimetro())}")
    }
}
