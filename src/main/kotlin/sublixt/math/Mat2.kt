package sublixt.math

public class Mat2(public val c0: Vec2, public val c1: Vec2) {
    public companion object {
        private val i0 = Vec2(1f, 0f)
        private val i1 = Vec2(0f, 1f)

        public val zero: Mat2 = Mat2(Vec2(), Vec2())
        public val identity: Mat2 = Mat2(i0, i1)
        public fun invoke(): Mat2 = identity
    }

    public fun get(index: Int): Vec2 =
            when (index) {
                0 -> c0
                1 -> c1
                else -> throw IndexOutOfBoundsException("[Mat2](get(int)): " + index + " not in range [0, 1]")
            }

    public fun minus(): Mat2 = Mat2(-c0, -c1)

    public fun plus(scalar: Float): Mat2 = Mat2(c0 + scalar, c1 + scalar)
    public fun minus(scalar: Float): Mat2 = Mat2(c0 - scalar, c1 - scalar)
    public fun times(scalar: Float): Mat2 = Mat2(c0 * scalar, c1 * scalar)
    public fun div(scalar: Float): Mat2 = Mat2(c0 / scalar, c1 / scalar)

    public fun plus(scalar: Int): Mat2 = Mat2(c0 + scalar, c1 + scalar)
    public fun minus(scalar: Int): Mat2 = Mat2(c0 - scalar, c1 - scalar)
    public fun times(scalar: Int): Mat2 = Mat2(c0 * scalar, c1 * scalar)
    public fun div(scalar: Int): Mat2 = Mat2(c0 / scalar, c1 / scalar)

    public fun plus(other: Mat2): Mat2 = Mat2(c0 + other.c0, c1 + other.c1)
    public fun minus(other: Mat2): Mat2 = Mat2(c0 - other.c0, c1 - other.c1)

    public fun times(other: Mat2): Mat2 =
            Mat2(
                    Vec2(
                            c0.x * other.c0.x + c1.x * other.c0.y,
                            c0.y * other.c0.x + c1.y * other.c0.y),
                    Vec2(
                            c0.x * other.c1.x + c1.x * other.c1.y,
                            c0.y * other.c1.x + c1.y * other.c1.y))

    public fun times(vec: Vec2): Vec2 =
            Vec2(
                    c0.x * vec.x + c1.x * vec.y,
                    c0.y * vec.x + c1.y * vec.y)

    public val transpose: Mat2
        get() =
        Mat2(
                Vec2(c0.x, c1.x),
                Vec2(c0.y, c1.y))

    public val determinant: Float
        get() =
        c0.x * c1.y - c0.y * c1.x

    public val inverse: Mat2
        get() {
            val d = determinant
            return Mat2(Vec2(c1.y / d, -c0.y / d), Vec2(-c1.x / d, c0.x / d))
        }
}
