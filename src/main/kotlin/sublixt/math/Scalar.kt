package sublixt.math

public fun Int.plus(vec: Vec2): Vec2 = vec + this
public fun Float.plus(vec: Vec2): Vec2 = vec + this
public fun Int.plus(vec: Vec3): Vec3 = vec + this
public fun Float.plus(vec: Vec3): Vec3 = vec + this
public fun Int.plus(vec: Vec4): Vec4 = vec + this
public fun Float.plus(vec: Vec4): Vec4 = vec + this

public fun Int.times(vec: Vec2): Vec2 = vec * this
public fun Float.times(vec: Vec2): Vec2 = vec * this
public fun Int.times(vec: Vec3): Vec3 = vec * this
public fun Float.times(vec: Vec3): Vec3 = vec * this
public fun Int.times(vec: Vec4): Vec4 = vec * this
public fun Float.times(vec: Vec4): Vec4 = vec * this

public fun Int.plus(mat: Mat2): Mat2 = mat + this
public fun Float.plus(mat: Mat2): Mat2 = mat + this
public fun Int.plus(mat: Mat3): Mat3 = mat + this
public fun Float.plus(mat: Mat3): Mat3 = mat + this
public fun Int.plus(mat: Mat4): Mat4 = mat + this
public fun Float.plus(mat: Mat4): Mat4 = mat + this

public fun Int.times(mat: Mat2): Mat2 = mat * this
public fun Float.times(mat: Mat2): Mat2 = mat * this
public fun Int.times(mat: Mat3): Mat3 = mat * this
public fun Float.times(mat: Mat3): Mat3 = mat * this
public fun Int.times(mat: Mat4): Mat4 = mat * this
public fun Float.times(mat: Mat4): Mat4 = mat * this
