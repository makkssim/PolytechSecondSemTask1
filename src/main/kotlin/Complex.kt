@file:Suppress("UNUSED_PARAMETER")

import java.lang.NumberFormatException


class Complex(var re: Double, var im: Double) {

    operator fun plus(other: Complex): Complex = Complex(this.re + other.re, this.im + other.im)

    operator fun minus(other: Complex): Complex = Complex(this.re - other.re, this.im - other.im)

    operator fun times(other: Complex): Complex =
        Complex(this.re * other.re - this.im * other.im, this.re * other.im + this.im * other.re)

    operator fun div(other: Complex): Complex =
        Complex((this.re * other.re + this.im * other.im) / (other.im * other.im + other.re * other.re),
            (this.im * other.re - this.re * other.im) / (other.im * other.im + other.re * other.re))

     fun equals(other: Complex): Boolean = this.re == other.re && this.im == other.im

    override fun toString(): String {
        if (this.re == 0.0 && this.im == 0.0) return "0" else{
            if (this.re == 0.0) return "${this.im}i"
            if (this.im == 0.0) return this.re.toString()
        }
        return if (this.im > 0.0) "${this.re} + ${this.im}i" else "${this.re} - ${-this.im}i"
    }

    constructor(str: String): this(1.0,1.0) {
        var re = 0.0
        var im = 0.0
        var flag = 1.0
        val a = str.split(" ")
        for (str in a){
            when {
                str == "-" -> flag = -1.0
                str == "+" -> flag = 1.0
                str == "i" -> im++
                str.toDoubleOrNull() != null -> re += str.toDouble() * flag
                str.removeSuffix("i").toDoubleOrNull() != null -> im += str.removeSuffix("i").toDouble() * flag
                else -> throw NumberFormatException()
            }
        }
        this.re = re
        this.im = im
    }
}
