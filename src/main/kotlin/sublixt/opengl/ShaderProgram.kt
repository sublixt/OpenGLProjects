package sublixt.opengl

import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL20
import sublixt.math.*
import java.nio.FloatBuffer
import kotlin.properties.Delegates

public object ShaderProgramFunctions {
    private val buffer: FloatBuffer = BufferUtils.createFloatBuffer(16)

    public fun uniform(location: Int, scalar: Float) {
        buffer.put(scalar)
        buffer.flip()
        GL20.glUniform1(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, scalar: Int) {
        buffer.put(scalar.toFloat())
        buffer.flip()
        GL20.glUniform1(location: Int, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, vec: Vec2) {
        buffer.put(vec)
        buffer.flip()
        GL20.glUniform2(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Float) {
        buffer.put(x)
        buffer.put(y)
        buffer.flip()
        GL20.glUniform2(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Int) {
        buffer.put(x)
        buffer.put(y.toFloat())
        buffer.flip()
        GL20.glUniform2(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Float) {
        buffer.put(x.toFloat())
        buffer.put(y)
        buffer.flip()
        GL20.glUniform2(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Int) {
        buffer.put(x.toFloat())
        buffer.put(y.toFloat())
        buffer.flip()
        GL20.glUniform2(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, vec: Vec3) {
        buffer.put(vec)
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Float, z: Float) {
        buffer.put(x)
        buffer.put(y)
        buffer.put(z)
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Float, z: Float) {
        buffer.put(x.toFloat())
        buffer.put(y)
        buffer.put(z)
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Int, z: Float) {
        buffer.put(x)
        buffer.put(y.toFloat())
        buffer.put(z)
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Int, z: Float) {
        buffer.put(x.toFloat())
        buffer.put(y.toFloat())
        buffer.put(z)
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Float, z: Int) {
        buffer.put(x)
        buffer.put(y)
        buffer.put(z.toFloat())
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Float, z: Int) {
        buffer.put(x.toFloat())
        buffer.put(y)
        buffer.put(z.toFloat())
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Int, z: Int) {
        buffer.put(x)
        buffer.put(y.toFloat())
        buffer.put(z.toFloat())
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Int, z: Int) {
        buffer.put(x.toFloat())
        buffer.put(y.toFloat())
        buffer.put(z.toFloat())
        buffer.flip()
        GL20.glUniform3(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, vec: Vec4) {
        buffer.put(vec)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Float, z: Float, w: Float) {
        buffer.put(x)
        buffer.put(y)
        buffer.put(z)
        buffer.put(w)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Float, z: Float, w: Float) {
        buffer.put(x.toFloat())
        buffer.put(y)
        buffer.put(z)
        buffer.put(w)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Int, z: Float, w: Float) {
        buffer.put(x)
        buffer.put(y.toFloat())
        buffer.put(z)
        buffer.put(w)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Int, z: Float, w: Float) {
        buffer.put(x.toFloat())
        buffer.put(y.toFloat())
        buffer.put(z)
        buffer.put(w)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Float, z: Int, w: Float) {
        buffer.put(x)
        buffer.put(y)
        buffer.put(z.toFloat())
        buffer.put(w)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Float, z: Int, w: Float) {
        buffer.put(x.toFloat())
        buffer.put(y)
        buffer.put(z.toFloat())
        buffer.put(w)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Int, z: Int, w: Float) {
        buffer.put(x)
        buffer.put(y.toFloat())
        buffer.put(z.toFloat())
        buffer.put(w)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Int, z: Int, w: Float) {
        buffer.put(x.toFloat())
        buffer.put(y.toFloat())
        buffer.put(z.toFloat())
        buffer.put(w)
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Float, z: Float, w: Int) {
        buffer.put(x.toFloat())
        buffer.put(y)
        buffer.put(z)
        buffer.put(w.toFloat())
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Int, z: Float, w: Int) {
        buffer.put(x)
        buffer.put(y.toFloat())
        buffer.put(z)
        buffer.put(w.toFloat())
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Int, z: Float, w: Int) {
        buffer.put(x.toFloat())
        buffer.put(y.toFloat())
        buffer.put(z)
        buffer.put(w.toFloat())
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Float, z: Int, w: Int) {
        buffer.put(x)
        buffer.put(y)
        buffer.put(z.toFloat())
        buffer.put(w.toFloat())
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Float, z: Int, w: Int) {
        buffer.put(x.toFloat())
        buffer.put(y)
        buffer.put(z.toFloat())
        buffer.put(w.toFloat())
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Float, y: Int, z: Int, w: Int) {
        buffer.put(x)
        buffer.put(y.toFloat())
        buffer.put(z.toFloat())
        buffer.put(w.toFloat())
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, x: Int, y: Int, z: Int, w: Int) {
        buffer.put(x.toFloat())
        buffer.put(y.toFloat())
        buffer.put(z.toFloat())
        buffer.put(w.toFloat())
        buffer.flip()
        GL20.glUniform4(location, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, mat: Mat2) {
        buffer.put(mat)
        buffer.flip()
        GL20.glUniformMatrix2(location, false, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, mat: Mat3) {
        buffer.put(mat)
        buffer.flip()
        GL20.glUniformMatrix3(location, false, buffer)
        buffer.clear()
    }

    public fun uniform(location: Int, mat: Mat4) {
        buffer.put(mat)
        buffer.flip()
        GL20.glUniformMatrix4(location, false, buffer)
        buffer.clear()
    }

    public fun unifrom1(location: Int, buf: FloatBuffer) {
        GL20.glUniform1(location, buf)
    }

    public fun unifrom2(location: Int, buf: FloatBuffer) {
        GL20.glUniform2(location, buf)
    }

    public fun unifrom3(location: Int, buf: FloatBuffer) {
        GL20.glUniform3(location, buf)
    }

    public fun unifrom4(location: Int, buf: FloatBuffer) {
        GL20.glUniform4(location, buf)
    }

    public fun uniformMatrix2(location: Int, buf: FloatBuffer) {
        GL20.glUniformMatrix2(location, false, buf)
    }

    public fun uniformMatrix3(location: Int, buf: FloatBuffer) {
        GL20.glUniformMatrix3(location, false, buf)
    }

    public fun uniformMatrix4(location: Int, buf: FloatBuffer) {
        GL20.glUniformMatrix4(location, false, buf)
    }
}

//these need to be vals so finalize doesn't get called and accidentally delete the shaders
public class ShaderProgram(public val vert: VertexShader, public val frag: FragmentShader) {
    public val id: Int = GL20.glCreateProgram()
    private var deleted = false
    public val infoLog: String
        get() =
            if(!deleted) GL20.glGetProgramInfoLog(id)
            else "ShaderProgram already deleted."

    init {
        GL20.glAttachShader(id, vert.id)
        GL20.glAttachShader(id, frag.id)
        GL20.glLinkProgram(id)
        GL20.glValidateProgram(id)
    }

    inline public fun bind(body: ShaderProgramFunctions.() -> Unit) {
        if (!isDeleted()) {
            GL20.glUseProgram(id)
            ShaderProgramFunctions.body()
            GL20.glUseProgram(0)
        } else
            pushException(Exception("[ShaderProgram](bind(() -> Unit)) Cannot bind. ShaderProgram is deleted."))
    }

    public fun isDeleted(): Boolean = deleted

    public fun delete() {
        if (!deleted) {
            GL20.glDeleteProgram(id)
            deleted = true
        }
    }

    protected fun finalize() {
        delete()
    }
}
