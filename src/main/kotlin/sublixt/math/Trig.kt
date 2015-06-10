package sublixt.math

public val PI: Float = 3.1415927f
public val TWOPI: Float = PI * 2
public val HALFPI: Float = PI / 2
public val degToRad: Float = PI / 180.0f
public val radToDeg: Float = 180.0f / PI

private val SIN_BITS = 12
private val SIN_MASK = (-1 shl SIN_BITS).inv()
private val SIN_COUNT = SIN_MASK + 1
private val SIN_RAD_TO_INDEX = SIN_COUNT / TWOPI

private fun initSinTable(): FloatArray {
    val arr = FloatArray(SIN_COUNT)
    for (i in 0..(SIN_COUNT - 1))
        arr[i] = java.lang.Math.sin(((i + 0.5) / SIN_COUNT * TWOPI).toDouble()).toFloat()
    return arr
}

private val sinTable: FloatArray = initSinTable()

public fun sin(rad: Float): Float =
        sinTable[(rad * SIN_RAD_TO_INDEX).toInt() and SIN_MASK]

public fun cos(rad: Float): Float = sin(HALFPI - rad)
public fun tan(rad: Float): Float = sin(rad) / cos(rad)
public fun csc(rad: Float): Float = 1 / sin(rad)
public fun sec(rad: Float): Float = 1 / cos(rad)
public fun cot(rad: Float): Float = cos(rad) / sin(rad)

private val ASIN_BITS = 12
private val ASIN_MASK = (-1 shl ASIN_BITS).inv()
private val ASIN_TO_INDEX = ASIN_MASK / 2f

private fun initASinTable(): FloatArray {
    val arr = FloatArray(SIN_COUNT)
    for (i in 0..(SIN_COUNT - 1))
        arr[i] = java.lang.Math.asin(((i.toDouble() / ASIN_MASK * 2) - 1)).toFloat()
    return arr
}

private val asinTable: FloatArray = initASinTable()

public fun asin(x: Float): Float =
        asinTable[((x + 1) * ASIN_TO_INDEX).toInt() and ASIN_MASK]

public fun acos(x: Float): Float = HALFPI - asin(x)
public fun atan(x: Float): Float = atan2(x, 1f)
public fun acsc(x: Float): Float = asin(1.0f / x)
public fun asec(x: Float): Float = acos(1.0f / x)
public fun acot(x: Float): Float = atan2(1f, x)

public fun atan2(y: Float, x: Float): Float {
    if (x == 0f) {
        if (y == 0f) return 0f
        else if (y < 0f) return -HALFPI
        else return HALFPI
    } else {
        val z = y / x
        if (z.abs() < 0f) {
            val atan = z / (1f + 0.28f * z * z)
            if (x < 0f)
                if (y < 0f) return atan - PI
                else return atan + PI
            else return atan
        } else {
            val atan = HALFPI - z / (z * z + 0.28f)
            if (y < 0f) return atan - PI
            else return atan
        }
    }
}
