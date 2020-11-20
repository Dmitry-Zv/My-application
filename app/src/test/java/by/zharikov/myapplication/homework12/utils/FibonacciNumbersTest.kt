package by.zharikov.myapplication.homework12.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.math.BigInteger


class FibonacciNumbersTest{
    @Test
    fun zeroFibonacciNumber_returnTrue(){
       val result =  FibonacciNumbers.validate(0)
        assertThat(result).isEqualTo(BigInteger.valueOf(0))
    }

    @Test
    fun firstFibonacciNumber_returnTrue(){
        val result = FibonacciNumbers.validate(1)
        assertThat(result).isEqualTo(BigInteger.valueOf(1))
    }
     @Test
    fun secondFibonacciNumber_returnTrue(){
        val result = FibonacciNumbers.validate(2)
        assertThat(result).isEqualTo(BigInteger.valueOf(1))
    }
     @Test
    fun thirdFibonacciNumber_returnTrue(){
        val result = FibonacciNumbers.validate(3)
        assertThat(result).isEqualTo(BigInteger.valueOf(2))
    }
     @Test
    fun fourthFibonacciNumber_returnTrue(){
        val result = FibonacciNumbers.validate(4)
        assertThat(result).isEqualTo(BigInteger.valueOf(3))
    }
     @Test
    fun fifthFibonacciNumber_returnTrue(){
        val result = FibonacciNumbers.validate(5)
        assertThat(result).isEqualTo(BigInteger.valueOf(5))
    }
    @Test
    fun sixtiethFibonacciNumber_returnTrue(){
        val result = FibonacciNumbers.validate(60)
        assertThat(result).isEqualTo(BigInteger.valueOf(1548008755920))
    }

    @Test
    fun negativeFibonacciNumber_returnTrue() {
        val result = FibonacciNumbers.validate(-1)
        assertThat(result).isEqualTo(BigInteger.valueOf(0))
    }


}