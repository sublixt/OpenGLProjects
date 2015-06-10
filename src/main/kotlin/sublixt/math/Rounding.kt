package sublixt.math

import java.lang.Float.floatToIntBits
import java.lang.Float.intBitsToFloat

public fun Float.floor(): Int {
    val x = this.toInt()
    if (this < x)
        return x - 1
    else
        return x
}

public fun Float.ceil(): Int {
    val x = this.toInt()
    if (this > x)
        return x + 1
    else
        return x
}

public fun Float.round(): Int =
        (this + 0.5f).floor()

public fun Float.abs(): Float {
    val i = floatToIntBits(this) and 0x7FFFFFFF
    return intBitsToFloat(i)
}

public fun Int.abs(): Int {
    val y = this shr 31
    return (this xor y) - y // twos complement when negative
}
