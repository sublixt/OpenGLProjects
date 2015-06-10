package sublixt.math

public class Vec3(public val x: Float, public val y: Float, public val z: Float) {
    public companion object {
        public val zero: Vec3 = Vec3(0f, 0f, 0f)
        public fun invoke(): Vec3 = zero
    }

    public fun get(index: Int): Float =
            when (index) {
                0 -> x
                1 -> y
                2 -> z
                else -> throw IndexOutOfBoundsException("[Vec3](get(int)): " + index + " not in range [0, 2]")
            }

    public fun minus(): Vec3 = Vec3(-x, -y, -z)

    public val magnitudeSquared: Float get() = dot(this)
    public val magnitude: Float get() = sqrt(magnitudeSquared)
    public val normal: Vec3 get() = div(magnitude)

    public fun project(onto: Vec3): Vec3 =
            onto * (dot(onto) / onto.magnitude)

    public fun dot(other: Vec3): Float = x * other.x + y * other.y + z * other.z
    public fun cross(other: Vec3): Vec3 = Vec3(y * other.z - z * other.y, z * other.x - x * other.z, x * other.y - y * other.x)

    public fun plus(scalar: Float): Vec3 = Vec3(x + scalar, y + scalar, z + scalar)
    public fun minus(scalar: Float): Vec3 = Vec3(x - scalar, y - scalar, z - scalar)
    public fun times(scalar: Float): Vec3 = Vec3(x * scalar, y * scalar, z * scalar)
    public fun div(scalar: Float): Vec3 = Vec3(x / scalar, y / scalar, z / scalar)

    public fun plus(scalar: Int): Vec3 = Vec3(x + scalar, y + scalar, z + scalar)
    public fun minus(scalar: Int): Vec3 = Vec3(x - scalar, y - scalar, z - scalar)
    public fun times(scalar: Int): Vec3 = Vec3(x * scalar, y * scalar, z * scalar)
    public fun div(scalar: Int): Vec3 = Vec3(x / scalar, y / scalar, z / scalar)

    public fun plus(other: Vec3): Vec3 = Vec3(x + other.x, y + other.y, z + other.z)
    public fun minus(other: Vec3): Vec3 = Vec3(x - other.x, y - other.y, z - other.z)
    public fun times(other: Vec3): Vec3 = Vec3(x * other.x, y * other.y, z * other.z)
    public fun div(other: Vec3): Vec3 = Vec3(x / other.x, y / other.y, z / other.z)

    public fun min(other: Vec3): Vec3 =
            Vec3(
                    x.min(other.x),
                    y.min(other.y),
                    y.min(other.z)
            )

    public fun min(scalar: Float): Vec3 =
            Vec3(
                    x.min(scalar),
                    y.min(scalar),
                    z.min(scalar)
            )

    public fun min(scalar: Int): Vec3 =
            Vec3(
                    x.min(scalar),
                    y.min(scalar),
                    z.min(scalar)
            )

    public fun max(other: Vec3): Vec3 =
            Vec3(
                    x.max(other.x),
                    y.max(other.y),
                    z.max(other.z)
            )

    public fun max(scalar: Float): Vec3 =
            Vec3(
                    x.max(scalar),
                    y.max(scalar),
                    z.max(scalar)
            )

    public fun max(scalar: Int): Vec3 =
            Vec3(
                    x.max(scalar),
                    y.max(scalar),
                    z.max(scalar)
            )

    public fun clamp(min: Vec3, max: Vec3): Vec3 =
            Vec3(
                    x.clamp(min.x, max.x),
                    y.clamp(min.y, max.y),
                    z.clamp(min.z, max.z)
            )

    public fun clamp(min: Vec3, max: Float): Vec3 =
            Vec3(
                    x.clamp(min.x, max),
                    y.clamp(min.y, max),
                    z.clamp(min.z, max)
            )

    public fun clamp(min: Vec3, max: Int): Vec3 =
            Vec3(
                    x.clamp(min.x, max),
                    y.clamp(min.y, max),
                    z.clamp(min.z, max)
            )

    public fun clamp(min: Float, max: Vec3): Vec3 =
            Vec3(
                    x.clamp(min, max.x),
                    y.clamp(min, max.y),
                    z.clamp(min, max.z)
            )

    public fun clamp(min: Int, max: Vec3): Vec3 =
            Vec3(
                    x.clamp(min, max.x),
                    y.clamp(min, max.y),
                    z.clamp(min, max.z)
            )

    public fun clamp(min: Float, max: Float): Vec3 =
            Vec3(
                    x.clamp(min, max),
                    y.clamp(min, max),
                    z.clamp(min, max)
            )

    public fun clamp(min: Float, max: Int): Vec3 =
            Vec3(
                    x.clamp(min, max),
                    y.clamp(min, max),
                    z.clamp(min, max)
            )

    public fun clamp(min: Int, max: Float): Vec3 =
            Vec3(
                    x.clamp(min, max),
                    y.clamp(min, max),
                    z.clamp(min, max)
            )

    public fun clamp(min: Int, max: Int): Vec3 =
            Vec3(
                    x.clamp(min, max),
                    y.clamp(min, max),
                    z.clamp(min, max)
            )

    public fun lerp(to: Vec3, speed: Float): Vec3 {
        val invspeed = 1f - speed
        return Vec3(
                (x * invspeed) + (to.x * speed),
                (y * invspeed) + (to.y * speed),
                (z * invspeed) + (to.z * speed)
        )
    }

    public val xx: Vec2 get() = Vec2(x, x)
    public val xy: Vec2 get() = Vec2(x, y)
    public val xz: Vec2 get() = Vec2(x, z)
    public val yx: Vec2 get() = Vec2(y, x)
    public val yy: Vec2 get() = Vec2(y, y)
    public val yz: Vec2 get() = Vec2(y, z)
    public val zx: Vec2 get() = Vec2(z, x)
    public val zy: Vec2 get() = Vec2(z, y)
    public val zz: Vec2 get() = Vec2(z, z)

    public val xxx: Vec3 get() = Vec3(x, x, x)
    public val xxy: Vec3 get() = Vec3(x, x, y)
    public val xxz: Vec3 get() = Vec3(x, x, z)
    public val xyx: Vec3 get() = Vec3(x, y, x)
    public val xyy: Vec3 get() = Vec3(x, y, y)
    public val xyz: Vec3 get() = Vec3(x, y, z)
    public val xzx: Vec3 get() = Vec3(x, z, x)
    public val xzy: Vec3 get() = Vec3(x, z, y)
    public val xzz: Vec3 get() = Vec3(x, z, z)
    public val yxx: Vec3 get() = Vec3(y, x, x)
    public val yxy: Vec3 get() = Vec3(y, x, y)
    public val yxz: Vec3 get() = Vec3(y, x, z)
    public val yyx: Vec3 get() = Vec3(y, y, x)
    public val yyy: Vec3 get() = Vec3(y, y, y)
    public val yyz: Vec3 get() = Vec3(y, y, z)
    public val yzx: Vec3 get() = Vec3(y, z, x)
    public val yzy: Vec3 get() = Vec3(y, z, y)
    public val yzz: Vec3 get() = Vec3(y, z, z)
    public val zxx: Vec3 get() = Vec3(z, x, x)
    public val zxy: Vec3 get() = Vec3(z, x, y)
    public val zxz: Vec3 get() = Vec3(z, x, z)
    public val zyx: Vec3 get() = Vec3(z, y, x)
    public val zyy: Vec3 get() = Vec3(z, y, y)
    public val zyz: Vec3 get() = Vec3(z, y, z)
    public val zzx: Vec3 get() = Vec3(z, z, x)
    public val zzy: Vec3 get() = Vec3(z, z, y)
    public val zzz: Vec3 get() = Vec3(z, z, z)

    public val xxxx: Vec4 get() = Vec4(x, x, x, x)
    public val xxxy: Vec4 get() = Vec4(x, x, x, y)
    public val xxxz: Vec4 get() = Vec4(x, x, x, z)
    public val xxyx: Vec4 get() = Vec4(x, x, y, x)
    public val xxyy: Vec4 get() = Vec4(x, x, y, y)
    public val xxyz: Vec4 get() = Vec4(x, x, y, z)
    public val xxzx: Vec4 get() = Vec4(x, x, z, x)
    public val xxzy: Vec4 get() = Vec4(x, x, z, y)
    public val xxzz: Vec4 get() = Vec4(x, x, z, z)
    public val xyxx: Vec4 get() = Vec4(x, y, x, x)
    public val xyxy: Vec4 get() = Vec4(x, y, x, y)
    public val xyxz: Vec4 get() = Vec4(x, y, x, z)
    public val xyyx: Vec4 get() = Vec4(x, y, y, x)
    public val xyyy: Vec4 get() = Vec4(x, y, y, y)
    public val xyyz: Vec4 get() = Vec4(x, y, y, z)
    public val xyzx: Vec4 get() = Vec4(x, y, z, x)
    public val xyzy: Vec4 get() = Vec4(x, y, z, y)
    public val xyzz: Vec4 get() = Vec4(x, y, z, z)
    public val xzxx: Vec4 get() = Vec4(x, z, x, x)
    public val xzxy: Vec4 get() = Vec4(x, z, x, y)
    public val xzxz: Vec4 get() = Vec4(x, z, x, z)
    public val xzyx: Vec4 get() = Vec4(x, z, y, x)
    public val xzyy: Vec4 get() = Vec4(x, z, y, y)
    public val xzyz: Vec4 get() = Vec4(x, z, y, z)
    public val xzzx: Vec4 get() = Vec4(x, z, z, x)
    public val xzzy: Vec4 get() = Vec4(x, z, z, y)
    public val xzzz: Vec4 get() = Vec4(x, z, z, z)
    public val yxxx: Vec4 get() = Vec4(y, x, x, x)
    public val yxxy: Vec4 get() = Vec4(y, x, x, y)
    public val yxxz: Vec4 get() = Vec4(y, x, x, z)
    public val yxyx: Vec4 get() = Vec4(y, x, y, x)
    public val yxyy: Vec4 get() = Vec4(y, x, y, y)
    public val yxyz: Vec4 get() = Vec4(y, x, y, z)
    public val yxzx: Vec4 get() = Vec4(y, x, z, x)
    public val yxzy: Vec4 get() = Vec4(y, x, z, y)
    public val yxzz: Vec4 get() = Vec4(y, x, z, z)
    public val yyxx: Vec4 get() = Vec4(y, y, x, x)
    public val yyxy: Vec4 get() = Vec4(y, y, x, y)
    public val yyxz: Vec4 get() = Vec4(y, y, x, z)
    public val yyyx: Vec4 get() = Vec4(y, y, y, x)
    public val yyyy: Vec4 get() = Vec4(y, y, y, y)
    public val yyyz: Vec4 get() = Vec4(y, y, y, z)
    public val yyzx: Vec4 get() = Vec4(y, y, z, x)
    public val yyzy: Vec4 get() = Vec4(y, y, z, y)
    public val yyzz: Vec4 get() = Vec4(y, y, z, z)
    public val yzxx: Vec4 get() = Vec4(y, z, x, x)
    public val yzxy: Vec4 get() = Vec4(y, z, x, y)
    public val yzxz: Vec4 get() = Vec4(y, z, x, z)
    public val yzyx: Vec4 get() = Vec4(y, z, y, x)
    public val yzyy: Vec4 get() = Vec4(y, z, y, y)
    public val yzyz: Vec4 get() = Vec4(y, z, y, z)
    public val yzzx: Vec4 get() = Vec4(y, z, z, x)
    public val yzzy: Vec4 get() = Vec4(y, z, z, y)
    public val yzzz: Vec4 get() = Vec4(y, z, z, z)
    public val zxxx: Vec4 get() = Vec4(z, x, x, x)
    public val zxxy: Vec4 get() = Vec4(z, x, x, y)
    public val zxxz: Vec4 get() = Vec4(z, x, x, z)
    public val zxyx: Vec4 get() = Vec4(z, x, y, x)
    public val zxyy: Vec4 get() = Vec4(z, x, y, y)
    public val zxyz: Vec4 get() = Vec4(z, x, y, z)
    public val zxzx: Vec4 get() = Vec4(z, x, z, x)
    public val zxzy: Vec4 get() = Vec4(z, x, z, y)
    public val zxzz: Vec4 get() = Vec4(z, x, z, z)
    public val zyxx: Vec4 get() = Vec4(z, y, x, x)
    public val zyxy: Vec4 get() = Vec4(z, y, x, y)
    public val zyxz: Vec4 get() = Vec4(z, y, x, z)
    public val zyyx: Vec4 get() = Vec4(z, y, y, x)
    public val zyyy: Vec4 get() = Vec4(z, y, y, y)
    public val zyyz: Vec4 get() = Vec4(z, y, y, z)
    public val zyzx: Vec4 get() = Vec4(z, y, z, x)
    public val zyzy: Vec4 get() = Vec4(z, y, z, y)
    public val zyzz: Vec4 get() = Vec4(z, y, z, z)
    public val zzxx: Vec4 get() = Vec4(z, z, x, x)
    public val zzxy: Vec4 get() = Vec4(z, z, x, y)
    public val zzxz: Vec4 get() = Vec4(z, z, x, z)
    public val zzyx: Vec4 get() = Vec4(z, z, y, x)
    public val zzyy: Vec4 get() = Vec4(z, z, y, y)
    public val zzyz: Vec4 get() = Vec4(z, z, y, z)
    public val zzzx: Vec4 get() = Vec4(z, z, z, x)
    public val zzzy: Vec4 get() = Vec4(z, z, z, y)
    public val zzzz: Vec4 get() = Vec4(z, z, z, z)

    public val s: Float get() = x
    public val t: Float get() = y
    public val p: Float get() = z

    public val ss: Vec2 get() = Vec2(x, x)
    public val st: Vec2 get() = Vec2(x, y)
    public val sp: Vec2 get() = Vec2(x, z)
    public val ts: Vec2 get() = Vec2(y, x)
    public val tt: Vec2 get() = Vec2(y, y)
    public val tp: Vec2 get() = Vec2(y, z)
    public val ps: Vec2 get() = Vec2(z, x)
    public val pt: Vec2 get() = Vec2(z, y)
    public val pp: Vec2 get() = Vec2(z, z)

    public val sss: Vec3 get() = Vec3(x, x, x)
    public val sst: Vec3 get() = Vec3(x, x, y)
    public val ssp: Vec3 get() = Vec3(x, x, z)
    public val sts: Vec3 get() = Vec3(x, y, x)
    public val stt: Vec3 get() = Vec3(x, y, y)
    public val stp: Vec3 get() = Vec3(x, y, z)
    public val sps: Vec3 get() = Vec3(x, z, x)
    public val spt: Vec3 get() = Vec3(x, z, y)
    public val spp: Vec3 get() = Vec3(x, z, z)
    public val tss: Vec3 get() = Vec3(y, x, x)
    public val tst: Vec3 get() = Vec3(y, x, y)
    public val tsp: Vec3 get() = Vec3(y, x, z)
    public val tts: Vec3 get() = Vec3(y, y, x)
    public val ttt: Vec3 get() = Vec3(y, y, y)
    public val ttp: Vec3 get() = Vec3(y, y, z)
    public val tps: Vec3 get() = Vec3(y, z, x)
    public val tpt: Vec3 get() = Vec3(y, z, y)
    public val tpp: Vec3 get() = Vec3(y, z, z)
    public val pss: Vec3 get() = Vec3(z, x, x)
    public val pst: Vec3 get() = Vec3(z, x, y)
    public val psp: Vec3 get() = Vec3(z, x, z)
    public val pts: Vec3 get() = Vec3(z, y, x)
    public val ptt: Vec3 get() = Vec3(z, y, y)
    public val ptp: Vec3 get() = Vec3(z, y, z)
    public val pps: Vec3 get() = Vec3(z, z, x)
    public val ppt: Vec3 get() = Vec3(z, z, y)
    public val ppp: Vec3 get() = Vec3(z, z, z)

    public val ssss: Vec4 get() = Vec4(x, x, x, x)
    public val ssst: Vec4 get() = Vec4(x, x, x, y)
    public val sssp: Vec4 get() = Vec4(x, x, x, z)
    public val ssts: Vec4 get() = Vec4(x, x, y, x)
    public val sstt: Vec4 get() = Vec4(x, x, y, y)
    public val sstp: Vec4 get() = Vec4(x, x, y, z)
    public val ssps: Vec4 get() = Vec4(x, x, z, x)
    public val sspt: Vec4 get() = Vec4(x, x, z, y)
    public val sspp: Vec4 get() = Vec4(x, x, z, z)
    public val stss: Vec4 get() = Vec4(x, y, x, x)
    public val stst: Vec4 get() = Vec4(x, y, x, y)
    public val stsp: Vec4 get() = Vec4(x, y, x, z)
    public val stts: Vec4 get() = Vec4(x, y, y, x)
    public val sttt: Vec4 get() = Vec4(x, y, y, y)
    public val sttp: Vec4 get() = Vec4(x, y, y, z)
    public val stps: Vec4 get() = Vec4(x, y, z, x)
    public val stpt: Vec4 get() = Vec4(x, y, z, y)
    public val stpp: Vec4 get() = Vec4(x, y, z, z)
    public val spss: Vec4 get() = Vec4(x, z, x, x)
    public val spst: Vec4 get() = Vec4(x, z, x, y)
    public val spsp: Vec4 get() = Vec4(x, z, x, z)
    public val spts: Vec4 get() = Vec4(x, z, y, x)
    public val sptt: Vec4 get() = Vec4(x, z, y, y)
    public val sptp: Vec4 get() = Vec4(x, z, y, z)
    public val spps: Vec4 get() = Vec4(x, z, z, x)
    public val sppt: Vec4 get() = Vec4(x, z, z, y)
    public val sppp: Vec4 get() = Vec4(x, z, z, z)
    public val tsss: Vec4 get() = Vec4(y, x, x, x)
    public val tsst: Vec4 get() = Vec4(y, x, x, y)
    public val tssp: Vec4 get() = Vec4(y, x, x, z)
    public val tsts: Vec4 get() = Vec4(y, x, y, x)
    public val tstt: Vec4 get() = Vec4(y, x, y, y)
    public val tstp: Vec4 get() = Vec4(y, x, y, z)
    public val tsps: Vec4 get() = Vec4(y, x, z, x)
    public val tspt: Vec4 get() = Vec4(y, x, z, y)
    public val tspp: Vec4 get() = Vec4(y, x, z, z)
    public val ttss: Vec4 get() = Vec4(y, y, x, x)
    public val ttst: Vec4 get() = Vec4(y, y, x, y)
    public val ttsp: Vec4 get() = Vec4(y, y, x, z)
    public val ttts: Vec4 get() = Vec4(y, y, y, x)
    public val tttt: Vec4 get() = Vec4(y, y, y, y)
    public val tttp: Vec4 get() = Vec4(y, y, y, z)
    public val ttps: Vec4 get() = Vec4(y, y, z, x)
    public val ttpt: Vec4 get() = Vec4(y, y, z, y)
    public val ttpp: Vec4 get() = Vec4(y, y, z, z)
    public val tpss: Vec4 get() = Vec4(y, z, x, x)
    public val tpst: Vec4 get() = Vec4(y, z, x, y)
    public val tpsp: Vec4 get() = Vec4(y, z, x, z)
    public val tpts: Vec4 get() = Vec4(y, z, y, x)
    public val tptt: Vec4 get() = Vec4(y, z, y, y)
    public val tptp: Vec4 get() = Vec4(y, z, y, z)
    public val tpps: Vec4 get() = Vec4(y, z, z, x)
    public val tppt: Vec4 get() = Vec4(y, z, z, y)
    public val tppp: Vec4 get() = Vec4(y, z, z, z)
    public val psss: Vec4 get() = Vec4(z, x, x, x)
    public val psst: Vec4 get() = Vec4(z, x, x, y)
    public val pssp: Vec4 get() = Vec4(z, x, x, z)
    public val psts: Vec4 get() = Vec4(z, x, y, x)
    public val pstt: Vec4 get() = Vec4(z, x, y, y)
    public val pstp: Vec4 get() = Vec4(z, x, y, z)
    public val psps: Vec4 get() = Vec4(z, x, z, x)
    public val pspt: Vec4 get() = Vec4(z, x, z, y)
    public val pspp: Vec4 get() = Vec4(z, x, z, z)
    public val ptss: Vec4 get() = Vec4(z, y, x, x)
    public val ptst: Vec4 get() = Vec4(z, y, x, y)
    public val ptsp: Vec4 get() = Vec4(z, y, x, z)
    public val ptts: Vec4 get() = Vec4(z, y, y, x)
    public val pttt: Vec4 get() = Vec4(z, y, y, y)
    public val pttp: Vec4 get() = Vec4(z, y, y, z)
    public val ptps: Vec4 get() = Vec4(z, y, z, x)
    public val ptpt: Vec4 get() = Vec4(z, y, z, y)
    public val ptpp: Vec4 get() = Vec4(z, y, z, z)
    public val ppss: Vec4 get() = Vec4(z, z, x, x)
    public val ppst: Vec4 get() = Vec4(z, z, x, y)
    public val ppsp: Vec4 get() = Vec4(z, z, x, z)
    public val ppts: Vec4 get() = Vec4(z, z, y, x)
    public val pptt: Vec4 get() = Vec4(z, z, y, y)
    public val pptp: Vec4 get() = Vec4(z, z, y, z)
    public val ppps: Vec4 get() = Vec4(z, z, z, x)
    public val pppt: Vec4 get() = Vec4(z, z, z, y)
    public val pppp: Vec4 get() = Vec4(z, z, z, z)

    public val r: Float get() = x
    public val g: Float get() = y
    public val b: Float get() = z

    public val rr: Vec2 get() = Vec2(x, x)
    public val rg: Vec2 get() = Vec2(x, y)
    public val rb: Vec2 get() = Vec2(x, z)
    public val gr: Vec2 get() = Vec2(y, x)
    public val gg: Vec2 get() = Vec2(y, y)
    public val gb: Vec2 get() = Vec2(y, z)
    public val br: Vec2 get() = Vec2(z, x)
    public val bg: Vec2 get() = Vec2(z, y)
    public val bb: Vec2 get() = Vec2(z, z)

    public val rrr: Vec3 get() = Vec3(x, x, x)
    public val rrg: Vec3 get() = Vec3(x, x, y)
    public val rrb: Vec3 get() = Vec3(x, x, z)
    public val rgr: Vec3 get() = Vec3(x, y, x)
    public val rgg: Vec3 get() = Vec3(x, y, y)
    public val rgb: Vec3 get() = Vec3(x, y, z)
    public val rbr: Vec3 get() = Vec3(x, z, x)
    public val rbg: Vec3 get() = Vec3(x, z, y)
    public val rbb: Vec3 get() = Vec3(x, z, z)
    public val grr: Vec3 get() = Vec3(y, x, x)
    public val grg: Vec3 get() = Vec3(y, x, y)
    public val grb: Vec3 get() = Vec3(y, x, z)
    public val ggr: Vec3 get() = Vec3(y, y, x)
    public val ggg: Vec3 get() = Vec3(y, y, y)
    public val ggb: Vec3 get() = Vec3(y, y, z)
    public val gbr: Vec3 get() = Vec3(y, z, x)
    public val gbg: Vec3 get() = Vec3(y, z, y)
    public val gbb: Vec3 get() = Vec3(y, z, z)
    public val brr: Vec3 get() = Vec3(z, x, x)
    public val brg: Vec3 get() = Vec3(z, x, y)
    public val brb: Vec3 get() = Vec3(z, x, z)
    public val bgr: Vec3 get() = Vec3(z, y, x)
    public val bgg: Vec3 get() = Vec3(z, y, y)
    public val bgb: Vec3 get() = Vec3(z, y, z)
    public val bbr: Vec3 get() = Vec3(z, z, x)
    public val bbg: Vec3 get() = Vec3(z, z, y)
    public val bbb: Vec3 get() = Vec3(z, z, z)

    public val rrrr: Vec4 get() = Vec4(x, x, x, x)
    public val rrrg: Vec4 get() = Vec4(x, x, x, y)
    public val rrrb: Vec4 get() = Vec4(x, x, x, z)
    public val rrgr: Vec4 get() = Vec4(x, x, y, x)
    public val rrgg: Vec4 get() = Vec4(x, x, y, y)
    public val rrgb: Vec4 get() = Vec4(x, x, y, z)
    public val rrbr: Vec4 get() = Vec4(x, x, z, x)
    public val rrbg: Vec4 get() = Vec4(x, x, z, y)
    public val rrbb: Vec4 get() = Vec4(x, x, z, z)
    public val rgrr: Vec4 get() = Vec4(x, y, x, x)
    public val rgrg: Vec4 get() = Vec4(x, y, x, y)
    public val rgrb: Vec4 get() = Vec4(x, y, x, z)
    public val rggr: Vec4 get() = Vec4(x, y, y, x)
    public val rggg: Vec4 get() = Vec4(x, y, y, y)
    public val rggb: Vec4 get() = Vec4(x, y, y, z)
    public val rgbr: Vec4 get() = Vec4(x, y, z, x)
    public val rgbg: Vec4 get() = Vec4(x, y, z, y)
    public val rgbb: Vec4 get() = Vec4(x, y, z, z)
    public val rbrr: Vec4 get() = Vec4(x, z, x, x)
    public val rbrg: Vec4 get() = Vec4(x, z, x, y)
    public val rbrb: Vec4 get() = Vec4(x, z, x, z)
    public val rbgr: Vec4 get() = Vec4(x, z, y, x)
    public val rbgg: Vec4 get() = Vec4(x, z, y, y)
    public val rbgb: Vec4 get() = Vec4(x, z, y, z)
    public val rbbr: Vec4 get() = Vec4(x, z, z, x)
    public val rbbg: Vec4 get() = Vec4(x, z, z, y)
    public val rbbb: Vec4 get() = Vec4(x, z, z, z)
    public val grrr: Vec4 get() = Vec4(y, x, x, x)
    public val grrg: Vec4 get() = Vec4(y, x, x, y)
    public val grrb: Vec4 get() = Vec4(y, x, x, z)
    public val grgr: Vec4 get() = Vec4(y, x, y, x)
    public val grgg: Vec4 get() = Vec4(y, x, y, y)
    public val grgb: Vec4 get() = Vec4(y, x, y, z)
    public val grbr: Vec4 get() = Vec4(y, x, z, x)
    public val grbg: Vec4 get() = Vec4(y, x, z, y)
    public val grbb: Vec4 get() = Vec4(y, x, z, z)
    public val ggrr: Vec4 get() = Vec4(y, y, x, x)
    public val ggrg: Vec4 get() = Vec4(y, y, x, y)
    public val ggrb: Vec4 get() = Vec4(y, y, x, z)
    public val gggr: Vec4 get() = Vec4(y, y, y, x)
    public val gggg: Vec4 get() = Vec4(y, y, y, y)
    public val gggb: Vec4 get() = Vec4(y, y, y, z)
    public val ggbr: Vec4 get() = Vec4(y, y, z, x)
    public val ggbg: Vec4 get() = Vec4(y, y, z, y)
    public val ggbb: Vec4 get() = Vec4(y, y, z, z)
    public val gbrr: Vec4 get() = Vec4(y, z, x, x)
    public val gbrg: Vec4 get() = Vec4(y, z, x, y)
    public val gbrb: Vec4 get() = Vec4(y, z, x, z)
    public val gbgr: Vec4 get() = Vec4(y, z, y, x)
    public val gbgg: Vec4 get() = Vec4(y, z, y, y)
    public val gbgb: Vec4 get() = Vec4(y, z, y, z)
    public val gbbr: Vec4 get() = Vec4(y, z, z, x)
    public val gbbg: Vec4 get() = Vec4(y, z, z, y)
    public val gbbb: Vec4 get() = Vec4(y, z, z, z)
    public val brrr: Vec4 get() = Vec4(z, x, x, x)
    public val brrg: Vec4 get() = Vec4(z, x, x, y)
    public val brrb: Vec4 get() = Vec4(z, x, x, z)
    public val brgr: Vec4 get() = Vec4(z, x, y, x)
    public val brgg: Vec4 get() = Vec4(z, x, y, y)
    public val brgb: Vec4 get() = Vec4(z, x, y, z)
    public val brbr: Vec4 get() = Vec4(z, x, z, x)
    public val brbg: Vec4 get() = Vec4(z, x, z, y)
    public val brbb: Vec4 get() = Vec4(z, x, z, z)
    public val bgrr: Vec4 get() = Vec4(z, y, x, x)
    public val bgrg: Vec4 get() = Vec4(z, y, x, y)
    public val bgrb: Vec4 get() = Vec4(z, y, x, z)
    public val bggr: Vec4 get() = Vec4(z, y, y, x)
    public val bggg: Vec4 get() = Vec4(z, y, y, y)
    public val bggb: Vec4 get() = Vec4(z, y, y, z)
    public val bgbr: Vec4 get() = Vec4(z, y, z, x)
    public val bgbg: Vec4 get() = Vec4(z, y, z, y)
    public val bgbb: Vec4 get() = Vec4(z, y, z, z)
    public val bbrr: Vec4 get() = Vec4(z, z, x, x)
    public val bbrg: Vec4 get() = Vec4(z, z, x, y)
    public val bbrb: Vec4 get() = Vec4(z, z, x, z)
    public val bbgr: Vec4 get() = Vec4(z, z, y, x)
    public val bbgg: Vec4 get() = Vec4(z, z, y, y)
    public val bbgb: Vec4 get() = Vec4(z, z, y, z)
    public val bbbr: Vec4 get() = Vec4(z, z, z, x)
    public val bbbg: Vec4 get() = Vec4(z, z, z, y)
    public val bbbb: Vec4 get() = Vec4(z, z, z, z)
}
