package sublixt.math

public class Vec2(public val x: Float, public val y: Float) {
    public companion object {
        public val zero: Vec2 = Vec2(0f, 0f)
        public fun invoke(): Vec2 = zero
    }

    public fun get(index: Int): Float =
            when (index) {
                0 -> x
                1 -> y
                else -> throw IndexOutOfBoundsException("[Vec2](get(int)): " + index + " not in range [0, 1]")
            }

    public fun minus(): Vec2 = Vec2(-x, -y)

    public val magnitudeSquared: Float get() = dot(this)
    public val magnitude: Float get() = sqrt(magnitudeSquared)
    public val normal: Vec2 get() = div(magnitude)

    public fun project(onto: Vec2): Vec2 =
            onto * (dot(onto) / onto.magnitude)

    public fun dot(other: Vec2): Float = x * other.x + y * other.y

    public fun plus(scalar: Float): Vec2 = Vec2(x + scalar, y + scalar)
    public fun minus(scalar: Float): Vec2 = Vec2(x - scalar, y - scalar)
    public fun times(scalar: Float): Vec2 = Vec2(x * scalar, y * scalar)
    public fun div(scalar: Float): Vec2 = Vec2(x / scalar, y / scalar)

    public fun plus(scalar: Int): Vec2 = Vec2(x + scalar, y + scalar)
    public fun minus(scalar: Int): Vec2 = Vec2(x - scalar, y - scalar)
    public fun times(scalar: Int): Vec2 = Vec2(x * scalar, y * scalar)
    public fun div(scalar: Int): Vec2 = Vec2(x / scalar, y / scalar)

    public fun plus(other: Vec2): Vec2 = Vec2(x + other.x, y + other.y)
    public fun minus(other: Vec2): Vec2 = Vec2(x - other.x, y - other.y)
    public fun times(other: Vec2): Vec2 = Vec2(x * other.x, y * other.y)
    public fun div(other: Vec2): Vec2 = Vec2(x / other.x, y * other.y)

    public fun min(other: Vec2): Vec2 =
            Vec2(
                    x.min(other.x),
                    y.min(other.y)
            )

    public fun min(scalar: Float): Vec2 =
            Vec2(
                    x.min(scalar),
                    y.min(scalar)
            )

    public fun min(scalar: Int): Vec2 =
            Vec2(
                    x.min(scalar),
                    y.min(scalar)
            )

    public fun max(other: Vec2): Vec2 =
            Vec2(
                    x.max(other.x),
                    y.max(other.y)
            )

    public fun max(scalar: Float): Vec2 =
            Vec2(
                    x.max(scalar),
                    y.max(scalar)
            )

    public fun max(scalar: Int): Vec2 =
            Vec2(
                    x.max(scalar),
                    y.max(scalar)
            )

    public fun clamp(min: Vec2, max: Vec2): Vec2 =
            Vec2(
                    x.clamp(min.x, max.x),
                    y.clamp(min.y, max.y)
            )

    public fun clamp(min: Vec2, max: Float): Vec2 =
            Vec2(
                    x.clamp(min.x, max),
                    y.clamp(min.y, max)
            )

    public fun clamp(min: Vec2, max: Int): Vec2 =
            Vec2(
                    x.clamp(min.x, max),
                    y.clamp(min.y, max)
            )

    public fun clamp(min: Float, max: Vec2): Vec2 =
            Vec2(
                    x.clamp(min, max.x),
                    y.clamp(min, max.y)
            )

    public fun clamp(min: Int, max: Vec2): Vec2 =
            Vec2(
                    x.clamp(min, max.x),
                    y.clamp(min, max.y)
            )

    public fun clamp(min: Float, max: Float): Vec2 =
            Vec2(
                    x.clamp(min, max),
                    y.clamp(min, max)
            )

    public fun clamp(min: Float, max: Int): Vec2 =
            Vec2(
                    x.clamp(min, max),
                    y.clamp(min, max)
            )

    public fun clamp(min: Int, max: Float): Vec2 =
            Vec2(
                    x.clamp(min, max),
                    y.clamp(min, max)
            )

    public fun clamp(min: Int, max: Int): Vec2 =
            Vec2(
                    x.clamp(min, max),
                    y.clamp(min, max)
            )

    public fun lerp(to: Vec2, speed: Float): Vec2 {
        val invspeed = 1f - speed
        return Vec2(
                (x * invspeed) + (to.x * speed),
                (y * invspeed) + (to.y * speed)
        )
    }

    public val xx: Vec2 get() = Vec2(x, x)
    public val xy: Vec2 get() = Vec2(x, y)
    public val yx: Vec2 get() = Vec2(y, x)
    public val yy: Vec2 get() = Vec2(y, y)

    public val xxx: Vec3 get() = Vec3(x, x, x)
    public val xxy: Vec3 get() = Vec3(x, x, y)
    public val xyx: Vec3 get() = Vec3(x, y, x)
    public val xyy: Vec3 get() = Vec3(x, y, y)
    public val yxx: Vec3 get() = Vec3(y, x, x)
    public val yxy: Vec3 get() = Vec3(y, x, y)
    public val yyx: Vec3 get() = Vec3(y, y, x)
    public val yyy: Vec3 get() = Vec3(y, y, y)

    public val xxxx: Vec4 get() = Vec4(x, x, x, x)
    public val xxxy: Vec4 get() = Vec4(x, x, x, y)
    public val xxyx: Vec4 get() = Vec4(x, x, y, x)
    public val xxyy: Vec4 get() = Vec4(x, x, y, y)
    public val xyxx: Vec4 get() = Vec4(x, y, x, x)
    public val xyxy: Vec4 get() = Vec4(x, y, x, y)
    public val xyyx: Vec4 get() = Vec4(x, y, y, x)
    public val xyyy: Vec4 get() = Vec4(x, y, y, y)
    public val yxxx: Vec4 get() = Vec4(y, x, x, x)
    public val yxxy: Vec4 get() = Vec4(y, x, x, y)
    public val yxyx: Vec4 get() = Vec4(y, x, y, x)
    public val yxyy: Vec4 get() = Vec4(y, x, y, y)
    public val yyxx: Vec4 get() = Vec4(y, y, x, x)
    public val yyxy: Vec4 get() = Vec4(y, y, x, y)
    public val yyyx: Vec4 get() = Vec4(y, y, y, x)
    public val yyyy: Vec4 get() = Vec4(y, y, y, y)

    public val s: Float get() = x
    public val t: Float get() = y

    public val ss: Vec2 get() = Vec2(x, x)
    public val st: Vec2 get() = Vec2(x, y)
    public val ts: Vec2 get() = Vec2(y, x)
    public val tt: Vec2 get() = Vec2(y, y)

    public val sss: Vec3 get() = Vec3(x, x, x)
    public val sst: Vec3 get() = Vec3(x, x, y)
    public val sts: Vec3 get() = Vec3(x, y, x)
    public val stt: Vec3 get() = Vec3(x, y, y)
    public val tss: Vec3 get() = Vec3(y, x, x)
    public val tst: Vec3 get() = Vec3(y, x, y)
    public val tts: Vec3 get() = Vec3(y, y, x)
    public val ttt: Vec3 get() = Vec3(y, y, y)

    public val ssss: Vec4 get() = Vec4(x, x, x, x)
    public val ssst: Vec4 get() = Vec4(x, x, x, y)
    public val ssts: Vec4 get() = Vec4(x, x, y, x)
    public val sstt: Vec4 get() = Vec4(x, x, y, y)
    public val stss: Vec4 get() = Vec4(x, y, x, x)
    public val stst: Vec4 get() = Vec4(x, y, x, y)
    public val stts: Vec4 get() = Vec4(x, y, y, x)
    public val sttt: Vec4 get() = Vec4(x, y, y, y)
    public val tsss: Vec4 get() = Vec4(y, x, x, x)
    public val tsst: Vec4 get() = Vec4(y, x, x, y)
    public val tsts: Vec4 get() = Vec4(y, x, y, x)
    public val tstt: Vec4 get() = Vec4(y, x, y, y)
    public val ttss: Vec4 get() = Vec4(y, y, x, x)
    public val ttst: Vec4 get() = Vec4(y, y, x, y)
    public val ttts: Vec4 get() = Vec4(y, y, y, x)
    public val tttt: Vec4 get() = Vec4(y, y, y, y)

    public val r: Float get() = x
    public val g: Float get() = y

    public val rr: Vec2 get() = Vec2(x, x)
    public val rg: Vec2 get() = Vec2(x, y)
    public val gr: Vec2 get() = Vec2(y, x)
    public val gg: Vec2 get() = Vec2(y, y)

    public val rrr: Vec3 get() = Vec3(x, x, x)
    public val rrg: Vec3 get() = Vec3(x, x, y)
    public val rgr: Vec3 get() = Vec3(x, y, x)
    public val rgg: Vec3 get() = Vec3(x, y, y)
    public val grr: Vec3 get() = Vec3(y, x, x)
    public val grg: Vec3 get() = Vec3(y, x, y)
    public val ggr: Vec3 get() = Vec3(y, y, x)
    public val ggg: Vec3 get() = Vec3(y, y, y)

    public val rrrr: Vec4 get() = Vec4(x, x, x, x)
    public val rrrg: Vec4 get() = Vec4(x, x, x, y)
    public val rrgr: Vec4 get() = Vec4(x, x, y, x)
    public val rrgg: Vec4 get() = Vec4(x, x, y, y)
    public val rgrr: Vec4 get() = Vec4(x, y, x, x)
    public val rgrg: Vec4 get() = Vec4(x, y, x, y)
    public val rggr: Vec4 get() = Vec4(x, y, y, x)
    public val rggg: Vec4 get() = Vec4(x, y, y, y)
    public val grrr: Vec4 get() = Vec4(y, x, x, x)
    public val grrg: Vec4 get() = Vec4(y, x, x, y)
    public val grgr: Vec4 get() = Vec4(y, x, y, x)
    public val grgg: Vec4 get() = Vec4(y, x, y, y)
    public val ggrr: Vec4 get() = Vec4(y, y, x, x)
    public val ggrg: Vec4 get() = Vec4(y, y, x, y)
    public val gggr: Vec4 get() = Vec4(y, y, y, x)
    public val gggg: Vec4 get() = Vec4(y, y, y, y)
}
