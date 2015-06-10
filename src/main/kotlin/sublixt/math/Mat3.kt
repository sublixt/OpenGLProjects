package sublixt.math

public class Mat3(public val c0: Vec3, public val c1: Vec3, public val c2: Vec3) {
    public companion object {
        private val i0 = Vec3(1f, 0f, 0f)
        private val i1 = Vec3(0f, 1f, 0f)
        private val i2 = Vec3(0f, 0f, 1f)

        public val zero: Mat3 = Mat3(Vec3(), Vec3(), Vec3())
        public val identity: Mat3 = Mat3(i0, i1, i2)
        public fun invoke(): Mat3 = identity
    }

    public fun get(index: Int): Vec3 =
            when (index) {
                0 -> c0
                1 -> c1
                2 -> c2
                else -> throw IndexOutOfBoundsException("[Mat3](get(int)): " + index + " not in range [0, 2]")
            }

    public fun minus(): Mat3 = Mat3(-c0, -c1, -c2)

    public fun plus(scalar: Float): Mat3 = Mat3(c0 + scalar, c1 + scalar, c2 + scalar)
    public fun minus(scalar: Float): Mat3 = Mat3(c0 - scalar, c1 - scalar, c2 - scalar)
    public fun times(scalar: Float): Mat3 = Mat3(c0 * scalar, c1 * scalar, c2 * scalar)
    public fun div(scalar: Float): Mat3 = Mat3(c0 / scalar, c1 / scalar, c2 / scalar)

    public fun plus(scalar: Int): Mat3 = Mat3(c0 + scalar, c1 + scalar, c2 + scalar)
    public fun minus(scalar: Int): Mat3 = Mat3(c0 - scalar, c1 - scalar, c2 - scalar)
    public fun times(scalar: Int): Mat3 = Mat3(c0 * scalar, c1 * scalar, c2 * scalar)
    public fun div(scalar: Int): Mat3 = Mat3(c0 / scalar, c1 / scalar, c2 / scalar)

    public fun plus(other: Mat3): Mat3 = Mat3(c0 + other.c0, c1 + other.c1, c2 + other.c2)
    public fun minus(other: Mat3): Mat3 = Mat3(c0 - other.c0, c1 - other.c1, c2 - other.c2)

    public val transpose: Mat3
        get() =
        Mat3(
                Vec3(c0.x, c1.x, c2.x),
                Vec3(c0.y, c1.y, c2.y),
                Vec3(c0.z, c1.z, c2.z))

    public val determinant: Float
        get() =
        c0.x * c1.y * c2.z + c1.x * c2.y * c0.z + c2.x * c0.y * c1.z -
                c0.z * c1.y * c2.x - c1.z * c2.y * c0.x - c2.z * c0.y * c1.x

    public val inverse: Mat3
        get() {
            val d = determinant
            return Mat3(
                    Vec3((c2.z * c1.y - c1.z * c2.y) / d, -(c2.z * c0.y - c0.z * c2.y) / d, (c1.z * c0.y - c0.z * c1.y) / d),
                    Vec3(-(c2.z * c1.x - c1.z * c2.x) / d, (c2.z * c0.x - c0.z * c2.x) / d, -(c1.z * c0.x - c0.z * c1.x) / d),
                    Vec3((c2.y * c1.x - c1.y * c2.x) / d, -(c2.y * c0.x - c0.y * c2.x) / d, (c1.y * c0.x - c0.y * c1.x) / d))
        }
}
