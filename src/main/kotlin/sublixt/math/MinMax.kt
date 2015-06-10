package sublixt.math

public fun Int.min(other: Int): Int =
        if (this < other) this else other

public fun Int.min(other: Float): Float =
        if (this < other) this.toFloat() else other

public fun Float.min(other: Int): Float =
        if (this < other) this else other.toFloat()

public fun Float.min(other: Float): Float =
        if (this < other) this else other

public fun Int.max(other: Int): Int =
        if (this > other) this else other

public fun Int.max(other: Float): Float =
        if (this > other) this.toFloat() else other

public fun Float.max(other: Int): Float =
        if (this > other) this else other.toFloat()

public fun Float.max(other: Float): Float =
        if (this > other) this else other
