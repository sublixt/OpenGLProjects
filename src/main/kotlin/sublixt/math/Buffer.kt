package sublixt.math

import java.nio.FloatBuffer

public fun FloatBuffer.put(vec: Vec2) {
    put(vec.x)
    put(vec.y)
}

public fun FloatBuffer.put(vec: Vec3) {
    put(vec.x)
    put(vec.y)
    put(vec.z)
}

public fun FloatBuffer.put(vec: Vec4) {
    put(vec.x)
    put(vec.y)
    put(vec.z)
    put(vec.w)
}

public fun FloatBuffer.put(mat: Mat2) {
    put(mat.c0)
    put(mat.c1)
}

public fun FloatBuffer.put(mat: Mat3) {
    put(mat.c0)
    put(mat.c1)
    put(mat.c2)
}

public fun FloatBuffer.put(mat: Mat4) {
    put(mat.c0)
    put(mat.c1)
    put(mat.c2)
    put(mat.c3)
}
