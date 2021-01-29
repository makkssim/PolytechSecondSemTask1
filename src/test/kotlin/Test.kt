import org.junit.Test
import org.junit.jupiter.api.Assertions
import kotlin.test.assertEquals
import org.junit.jupiter.api.Assertions.*
import java.lang.NumberFormatException


class Test {


    @Test
    fun plus() {
        assertEquals(true, Complex("6 + 8i").equals(Complex("1 + 2i").plus(Complex("5 + 6i"))))
        assertThrows(NumberFormatException::class.java) { Complex("6 + 8ii")  }
        assertThrows(NumberFormatException::class.java) { Complex("6 ++ 8i")  }
        assertThrows(NumberFormatException::class.java) { Complex("")  }
    }
    @Test
    fun minus() {
        assertEquals(true, Complex("6 - 8i").equals(Complex("6 + i").minus(Complex("9i"))))
        assertEquals(true, Complex("1 + 2i").equals(Complex("3 + 8i").minus(Complex("2 + 6i"))))
    }
    @Test
    fun div() {
        assertEquals(true, Complex("0.68 + 0.24i").equals(Complex("2 + 3i").div(Complex("4 + 3i"))))
        assertEquals(true, Complex("1").equals(Complex("3 + 8i").div(Complex("3 + 8i"))))
    }
    @Test
    fun times() {
        Assertions.assertEquals(true, Complex("-1 + 18i").equals(Complex("2 + 3i").times(Complex("4 + 3i"))))
        Assertions.assertEquals(true, Complex("6 + 16i").equals(Complex("3 + 8i").times(Complex("2"))))
    }


}
