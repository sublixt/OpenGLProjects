package sublixt.opengl

import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL15
import org.lwjgl.opengl.GL20
import java.nio.FloatBuffer

public object VBOFunctions {
    public fun bufferData(buffer: FloatBuffer, usage: Int) {
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, usage)
    }

    public fun bufferSubData(buffer: FloatBuffer, offset: Int) {
        GL15.glBufferSubData(GL15.GL_ARRAY_BUFFER, (offset * 4).toLong(), buffer)
    }

    public fun drawArrays(offset: Int, count: Int) {
        GL11.glDrawArrays(GL11.GL_TRIANGLES, offset, count)
    }

    public fun enableAttribArray(index: Int) {
        GL20.glEnableVertexAttribArray(index)
    }

    public fun disableAttribArray(index: Int) {
        GL20.glDisableVertexAttribArray(index)
    }

    public fun vertexAttribPointer(index: Int, size: Int, stride: Int, offset: Int) {
        GL20.glVertexAttribPointer(index, size, GL11.GL_FLOAT, false, stride * 4, (offset * 4).toLong())
    }
}

public class VBO {
    public val id: Int = GL15.glGenBuffers()

    private var deleted = false

    inline public fun bind(body: VBOFunctions.() -> Unit) {
        if (!isDeleted()) {
            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id)
            VBOFunctions.body()
            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0)
        }
    }

    public fun isDeleted(): Boolean = deleted

    public fun delete() {
        if (!deleted) {
            GL15.glDeleteBuffers(id)
            deleted = true
        }
    }

    protected fun finalize() {
        delete()
    }
}

