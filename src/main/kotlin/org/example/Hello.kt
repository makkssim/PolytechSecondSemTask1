package org.example

import Complex

fun main(args: Array<String>) {
    var a = Complex("2 + 3i").div(Complex("4 + 3i"))
    print(a.toString())
}

