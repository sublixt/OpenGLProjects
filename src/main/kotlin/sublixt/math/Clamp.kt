package sublixt.math

public fun Float.clamp(min: Float, max: Float): Float =
        if (this < min) min
        else if (this > max) max
        else this

public fun Float.clamp(min: Int, max: Int): Float =
        if (this < min) min.toFloat()
        else if (this > max) max.toFloat()
        else this

public fun Float.clamp(min: Float, max: Int): Float =
        if (this < min) min
        else if (this > max) max.toFloat()
        else this

public fun Float.clamp(min: Int, max: Float): Float =
        if (this < min) min.toFloat()
        else if (this > max) max
        else this

public fun Int.clamp(min: Float, max: Float): Float =
        if (this < min) min
        else if (this > max) max
        else this.toFloat()

public fun Int.clamp(min: Int, max: Int): Int =
        if (this < min) min
        else if (this > max) max
        else this

public fun Int.clamp(min: Float, max: Int): Float =
        if (this < min) min
        else if (this > max) max.toFloat()
        else this.toFloat()

public fun Int.clamp(min: Int, max: Float): Float =
        if (this < min) min.toFloat()
        else if (this > max) max
        else this.toFloat()
