package sublixt.opengl

import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL15
import org.lwjgl.opengl.GL20
import org.lwjgl.opengl.GL30

public object VAOFunctions {
    public fun drawArrays(offset: Int, count: Int) {
        GL11.glDrawArrays(GL11.GL_TRIANGLES, offset, count)
    }

    public fun drawElements(offset: Int, count: Int) {
        GL11.glDrawElements(GL11.GL_TRIANGLES, count, GL11.GL_UNSIGNED_INT, (offset * 4).toLong())
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

    public fun VBO.bindOnly(body: VBOFunctions.() -> Unit) {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id)
        VBOFunctions.body()
    }

    public fun IBO.bindOnly(body: IBOFunctions.() -> Unit) {
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, id)
        IBOFunctions.body()
    }
}

public class VAO {
    public val id: Int = GL30.glGenVertexArrays()

    private var deleted = false

    inline public fun bind(body: VAOFunctions.() -> Unit) {
        if (!isDeleted()) {
            GL30.glBindVertexArray(id)
            VAOFunctions.body()
            GL30.glBindVertexArray(0)
        } else
            pushException(Exception("[VAO](bind(() -> Unit)) Cannot bind. VAO is deleted."))
    }

    public fun isDeleted(): Boolean = deleted

    public fun delete() {
        if (!deleted) {
            GL30.glDeleteVertexArrays(id)
            deleted = false
        }
    }

    protected fun finalize() {
        delete()
    }
}
