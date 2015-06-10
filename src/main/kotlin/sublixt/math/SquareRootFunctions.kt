package sublixt.math

public fun sqrt(x: Float): Float {
    val i = java.lang.Float.floatToIntBits(x)
    val b = (1 shl 29) + (i shr 1) - (1 shl 22)
    val f = java.lang.Float.intBitsToFloat(b)
    return 0.5f * (f + x / f)
}

public fun invSqrt(x: Float): Float {
    val halfX = x * 0.5f
    val i = 0x5f3759df - (java.lang.Float.floatToIntBits(x) shr 1)
    val y = java.lang.Float.intBitsToFloat(i)
    return y * (1.5f - halfX * y * y)
}
