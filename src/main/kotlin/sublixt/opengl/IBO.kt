package sublixt.opengl

import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL15
import java.nio.IntBuffer

public object IBOFunctions {
    public fun bufferData(buffer: IntBuffer, usage: Int) {
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, usage)
    }

    public fun bufferSubData(buffer: IntBuffer, offset: Long) {
        GL15.glBufferSubData(GL15.GL_ELEMENT_ARRAY_BUFFER, (offset * 4).toLong(), buffer)
    }

    public fun drawElements(offset: Int, count: Int) {
        GL11.glDrawElements(GL11.GL_TRIANGLES, count, GL11.GL_UNSIGNED_INT, (offset * 4).toLong())
    }
}

public class IBO {
    public val id: Int = GL15.glGenBuffers()

    inline public fun bind<T>(body: IBOFunctions.() -> T): T {
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, id)
        val res = IBOFunctions.body()
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0)
        return res
    }

    public fun delete() {
        GL15.glDeleteBuffers(id)
    }

    protected fun finalize() {
        delete()
    }
}
