package by.zharikov.myapplication.homework12.utils

import java.math.BigInteger

object FibonacciNumbers {
    fun validate(n: Int): BigInteger {
        var number1 = BigInteger.valueOf(1)
        var number2 = BigInteger.valueOf(1)
        var number  = BigInteger.valueOf(1)
        if (n <= 0) number = BigInteger.valueOf(0)
        if (n == 0) number = BigInteger.valueOf(0)
        if (n == 1 || n == 2) number = BigInteger.valueOf(1)
        for (i in 3 .. n) {
            number = number1 + number2
            number1 = number2
            number2 = number
        }
        return number
    }
}