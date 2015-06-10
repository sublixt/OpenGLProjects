package sublixt.math

public class Mat4(public val c0: Vec4, public val c1: Vec4, public val c2: Vec4, public val c3: Vec4) {
    public companion object {
        private val i0 = Vec4(1f, 0f, 0f, 0f)
        private val i1 = Vec4(0f, 1f, 0f, 0f)
        private val i2 = Vec4(0f, 0f, 1f, 0f)
        private val i3 = Vec4(0f, 0f, 0f, 1f)

        public val zero: Mat4 = Mat4(Vec4(), Vec4(), Vec4(), Vec4())
        public val identity: Mat4 = Mat4(i0, i1, i2, i3)
        public fun invoke(): Mat4 = identity

        public fun ortho(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 {
            val tmb = top - bottom
            val rml = right - left
            val fmn = far - near
            return Mat4(
                    Vec4(2f / rml, 0f, 0f, 0f),
                    Vec4(0f, 2f / tmb, 0f, 0f),
                    Vec4(0f, 0f, 2f / fmn, 0f),
                    Vec4(-((right + left) / (rml)), -((top + bottom) / (tmb)), -((far + near) / fmn), 1f))
        }

        public fun perspective(fov: Float, aspect: Float, near: Float, far: Float): Mat4 {
            val f = cot(fov / 2f)
            val fmn = far - near

            return Mat4(
                    Vec4(f / aspect, 0f, 0f, 0f),
                    Vec4(0f, f, 0f, 0f),
                    Vec4(0f, 0f, (far + near) / fmn, -1f),
                    Vec4(0f, 0f, (-2 * far * near) / fmn, 0f)
            )
        }

        public fun translate(x: Float, y: Float, z: Float): Mat4 =
                Mat4(i0, i1, i2, Vec4(x, y, z, 1f))

        public fun rotx(angle: Float): Mat4 {
            val c = cos(angle)
            val s = sin(angle)

            return Mat4(
                    i0,
                    Vec4(0f, c, s, 0f),
                    Vec4(0f, -s, c, 0f),
                    i3)
        }

        public fun roty(angle: Float): Mat4 {
            val c = cos(angle)
            val s = sin(angle)

            return Mat4(
                    Vec4(c, 0f, -s, 0f),
                    i1,
                    Vec4(s, 0f, c, 0f),
                    i3)
        }

        public fun rotz(angle: Float): Mat4 {
            val c = cos(angle)
            val s = sin(angle)

            return Mat4(
                    Vec4(c, s, 0f, 0f),
                    Vec4(-s, c, 0f, 0f),
                    i2,
                    i3)
        }

        public fun rot(bank: Float, heading: Float, attitude: Float): Mat4 {
            val sa = sin(attitude)
            val ca = cos(attitude)
            val sb = sin(bank)
            val cb = cos(bank)
            val sh = sin(heading)
            val ch = cos(heading)

            val shsa = sh * sa
            val chsa = ch * sa

            return Mat4(
                    Vec4(ch * ca, sa, -sh * ca, 0f),
                    Vec4(-chsa * cb + sh * sb, ca * cb, shsa * cb + ch * sb, 0f),
                    Vec4(chsa * sb + sh * cb, -ca * sb, -shsa * sb + ch * cb, 0f),
                    i3)
        }

        public fun scale(x: Float, y: Float, z: Float): Mat4 =
                Mat4(Vec4(x, 0f, 0f, 0f), Vec4(0f, y, 0f, 0f), Vec4(0f, 0f, z, 0f), i3)

    }

    public fun get(index: Int): Vec4 =
            when (index) {
                0 -> c0
                1 -> c1
                2 -> c2
                3 -> c3
                else -> throw IndexOutOfBoundsException("[Mat4](get(int)): " + index + " not in range [0, 3]")
            }

    public fun minus(): Mat4 = Mat4(-c0, -c1, -c2, -c3)

    public fun plus(scalar: Float): Mat4 = Mat4(c0 + scalar, c1 + scalar, c2 + scalar, c3 + scalar)
    public fun minus(scalar: Float): Mat4 = Mat4(c0 - scalar, c1 - scalar, c2 - scalar, c3 - scalar)
    public fun times(scalar: Float): Mat4 = Mat4(c0 * scalar, c1 * scalar, c2 * scalar, c3 * scalar)
    public fun div(scalar: Float): Mat4 = Mat4(c0 / scalar, c1 / scalar, c2 / scalar, c3 / scalar)

    public fun plus(scalar: Int): Mat4 = Mat4(c0 + scalar, c1 + scalar, c2 + scalar, c3 + scalar)
    public fun minus(scalar: Int): Mat4 = Mat4(c0 - scalar, c1 - scalar, c2 - scalar, c3 - scalar)
    public fun times(scalar: Int): Mat4 = Mat4(c0 * scalar, c1 * scalar, c2 * scalar, c3 * scalar)
    public fun div(scalar: Int): Mat4 = Mat4(c0 / scalar, c1 / scalar, c2 / scalar, c3 / scalar)

    public fun plus(other: Mat4): Mat4 = Mat4(c0 + other.c0, c1 + other.c1, c2 + other.c2, c3 + other.c3)
    public fun minus(other: Mat4): Mat4 = Mat4(c0 - other.c0, c1 - other.c1, c2 - other.c2, c3 - other.c3)

    public val transpose: Mat4
        get() =
        Mat4(
                Vec4(c0.x, c1.x, c2.x, c3.x),
                Vec4(c0.y, c1.y, c2.y, c3.y),
                Vec4(c0.z, c1.z, c2.z, c3.z),
                Vec4(c0.w, c1.w, c3.w, c3.w))

    public val determinant: Float
        get() =
        (c0.x * (c1.y * c2.z * c3.w + c2.y * c3.z * c1.w + c3.y * c1.z * c2.w -
                c1.w * c2.z * c3.y - c2.w * c3.z * c1.y - c3.w * c1.z * c2.y)) -
                (c1.x * (c0.y * c2.z * c3.w + c2.y * c3.z * c0.w + c3.y * c0.z * c2.w -
                        c0.w * c2.z * c3.y - c2.w * c3.z * c0.y - c3.w * c0.z * c2.y)) +
                (c2.x * (c0.y * c1.z * c3.w + c1.y * c3.z * c0.w + c3.y * c0.z * c1.w -
                        c0.w * c1.z * c3.y - c1.w * c3.z * c0.y - c3.w * c0.z * c1.y)) -
                (c3.x * (c0.y * c1.z * c2.w + c1.y * c2.z * c0.w + c2.y * c0.z * c1.w -
                        c0.w * c1.z * c2.y - c1.w * c2.z * c0.y - c2.w * c0.z * c1.y))

    public val inverse: Mat4
        get() {
            val d = determinant

            return Mat4(
                    Vec4((c1.z * c2.w * c3.y - c1.w * c2.z * c3.y + c1.w * c2.y * c3.z - c1.y * c2.w * c3.z - c1.z * c2.y * c3.w + c1.y * c2.z * c3.w) / d,
                            (c0.w * c2.z * c3.y - c0.z * c2.w * c3.y - c0.w * c2.y * c3.z + c0.y * c2.w * c3.z + c0.z * c2.y * c3.w - c0.y * c2.z * c3.w) / d,
                            (c0.z * c1.w * c3.y - c0.w * c1.z * c3.y + c0.w * c1.y * c3.z - c0.y * c1.w * c3.z - c0.z * c1.y * c3.w + c0.y * c1.z * c3.w) / d,
                            (c0.w * c1.z * c2.y - c0.z * c1.w * c2.y - c0.w * c1.y * c2.z + c0.y * c1.w * c2.z + c0.z * c1.y * c2.w - c0.y * c1.z * c2.w) / d),
                    Vec4((c1.w * c2.z * c3.x - c1.z * c2.w * c3.x - c1.w * c2.x * c3.z + c1.x * c2.w * c3.z + c1.z * c2.x * c3.w - c1.x * c2.z * c3.w) / d,
                            (c0.z * c2.w * c3.x - c0.w * c2.z * c3.x + c0.w * c2.x * c3.z - c0.x * c2.w * c3.z - c0.z * c2.x * c3.w + c0.x * c2.z * c3.w) / d,
                            (c0.w * c1.z * c3.x - c0.z * c1.w * c3.x - c0.w * c1.x * c3.z + c0.x * c1.w * c3.z + c0.z * c1.x * c3.w - c0.x * c1.z * c3.w) / d,
                            (c0.z * c1.w * c2.x - c0.w * c1.z * c2.x + c0.w * c1.x * c2.z - c0.x * c1.w * c2.z - c0.z * c1.x * c2.w + c0.x * c1.z * c2.w) / d),
                    Vec4((c1.y * c2.w * c3.x - c1.w * c2.y * c3.x + c1.w * c2.x * c3.y - c1.x * c2.w * c3.y - c1.y * c2.x * c3.w + c1.x * c2.y * c3.w) / d,
                            (c0.w * c2.y * c3.x - c0.y * c2.w * c3.x - c0.w * c2.x * c3.y + c0.x * c2.w * c3.y + c0.y * c2.x * c3.w - c0.x * c2.y * c3.w) / d,
                            (c0.y * c1.w * c3.x - c0.w * c1.y * c3.x + c0.w * c1.x * c3.y - c0.x * c1.w * c3.y - c0.y * c1.x * c3.w + c0.x * c1.y * c3.w) / d,
                            (c0.w * c1.y * c2.x - c0.y * c1.w * c2.x - c0.w * c1.x * c2.y + c0.x * c1.w * c2.y + c0.y * c1.x * c2.w - c0.x * c1.y * c2.w) / d),
                    Vec4((c1.z * c2.y * c3.x - c1.y * c2.z * c3.x - c1.z * c2.x * c3.y + c1.x * c2.z * c3.y + c1.y * c2.x * c3.z - c1.x * c2.y * c3.z) / d,
                            (c0.y * c2.z * c3.x - c0.z * c2.y * c3.x + c0.z * c2.x * c3.y - c0.x * c2.z * c3.y - c0.y * c2.x * c3.z + c0.x * c2.y * c3.z) / d,
                            (c0.z * c1.y * c3.x - c0.y * c1.z * c3.x - c0.z * c1.x * c3.y + c0.x * c1.z * c3.y + c0.y * c1.x * c3.z - c0.x * c1.y * c3.z) / d,
                            (c0.y * c1.z * c2.x - c0.z * c1.y * c2.x + c0.z * c1.x * c2.y - c0.x * c1.z * c2.y - c0.y * c1.x * c2.z + c0.x * c1.y * c2.z) / d))
        }

    public fun rotx(angle: Float): Mat4 {
        val c = cos(angle)
        val s = sin(angle)

        return Mat4(
                c0,
                Vec4(c1.x * c + c2.x * s, c1.y * c + c2.y * s, c1.z * c + c2.z * s, c1.w * c + c2.w * s),
                Vec4(c2.x * c - c1.x * s, c2.y * c - c1.y * s, c2.z * c - c1.z * s, c2.w * c - c1.w * s),
                c3)
    }

    public fun roty(angle: Float): Mat4 {
        val c = cos(angle)
        val s = sin(angle)

        return Mat4(
                Vec4(c0.x * c - c2.x * s, c0.y * c - c2.y * s, c0.z * c - c2.z * s, c0.w * c - c2.w * s),
                c1,
                Vec4(c0.x * s + c2.x * c, c0.y * s + c2.y * c, c0.z * s + c2.z * c, c0.w * s + c2.w * c),
                c3)
    }

    public fun rotz(angle: Float): Mat4 {
        val c = cos(angle)
        val s = sin(angle)

        return Mat4(
                Vec4(c0.x * c + c1.x * s, c0.y * c + c1.y * s, c0.z * c + c1.z * s, c0.w * c + c1.w * s),
                Vec4(c1.x * c - c0.x * s, c1.y * c - c0.y * s, c1.z * c - c0.z * s, c1.w * c - c0.w * s),
                c2,
                c3)
    }

    public fun rot(bank: Float, heading: Float, attitude: Float): Mat4 {
        val sa = sin(attitude)
        val ca = cos(attitude)
        val sb = sin(bank)
        val cb = cos(bank)
        val sh = sin(heading)
        val ch = cos(heading)

        val shsa = sh * sa
        val chsa = ch * sa

        return Mat4(
                Vec4(
                        c0.x * (ch * ca) + c1.x * sa - c2.x * (sh * ca),
                        c0.y * (ch * ca) + c1.y * sa - c2.y * (sh * ca),
                        c0.z * (ch * ca) + c1.z * sa - c2.z * (sh * ca),
                        c0.w * (ch * ca) + c1.w * sa - c2.w * (sh * ca)),
                Vec4(
                        c0.x * (-chsa * cb + sh * sb) + c1.x * (ca * cb) + c2.x * (shsa * cb + ch * sb),
                        c0.y * (-chsa * cb + sh * sb) + c1.y * (ca * cb) + c2.y * (shsa * cb + ch * sb),
                        c0.z * (-chsa * cb + sh * sb) + c1.z * (ca * cb) + c2.z * (shsa * cb + ch * sb),
                        c0.w * (-chsa * cb + sh * sb) + c1.w * (ca * cb) + c2.w * (shsa * cb + ch * sb)),
                Vec4(
                        c0.x * (chsa * sb + sh * cb) - c1.x * (ca * sb) + c2.x * (-shsa * sb + ch * cb),
                        c0.y * (chsa * sb + sh * cb) - c1.y * (ca * sb) + c2.y * (-shsa * sb + ch * cb),
                        c0.z * (chsa * sb + sh * cb) - c1.z * (ca * sb) + c2.z * (-shsa * sb + ch * cb),
                        c0.w * (chsa * sb + sh * cb) - c1.w * (ca * sb) + c2.w * (-shsa * sb + ch * cb)),
                c3)
    }

    public fun translate(x: Float, y: Float, z: Float): Mat4 =
            Mat4(c0, c1, c2,
                    Vec4(
                            c0.x * x + c1.x * y + c2.x * z + c3.x,
                            c0.y * x + c1.y * y + c2.y * z + c3.y,
                            c0.z * x + c1.z * y + c2.z * z + c3.z,
                            c0.w * x + c1.w * y + c2.w * z + c3.w))

    public fun scale(x: Float, y: Float, z: Float): Mat4 =
            Mat4(
                    Vec4(c0.x * x, c0.y * x, c0.z * x, c0.w * x),
                    Vec4(c1.x * y, c1.y * y, c1.z * y, c1.w * y),
                    Vec4(c2.x * z, c2.y * z, c2.z * z, c2.w * z),
                    c3)
}
