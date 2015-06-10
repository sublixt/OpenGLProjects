package sublixt.opengl

import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL30
import java.nio.ByteBuffer

public object Tex2DFunctions {
    public fun genMipmaps() {
        GL30.glGenerateMipmap(GL11.GL_TEXTURE_2D)
    }

    public fun image(level: Int, internalFormat: Int, width: Int, height: Int, format: Int, type: Int, data: ByteBuffer) {
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, level, internalFormat, width, height, 0, format, type, data)
    }

    public fun image(level: Int, internalFormat: Int, width: Int, height: Int, format: Int, type: Int) {
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, level, internalFormat, width, height, 0, format, type, null as ByteBuffer?)
    }

    public fun subimage(level: Int, x: Int, y: Int, width: Int, height: Int, format: Int, pixels: ByteBuffer) {
        GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, level, x, y, width, height, format, GL11.GL_UNSIGNED_BYTE, pixels)
    }

    public fun parameter(pname: Int, param: Int) {
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, pname, param)
    }
}

public class Tex2D {
    public val id: Int = GL11.glGenTextures()

    private var deleted = false

    inline public fun bind(body: Tex2DFunctions.() -> Unit) {
        if (!isDeleted()) {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, id)
            Tex2DFunctions.body()
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0)
        }
    }

    public fun isDeleted(): Boolean = deleted

    public fun delete() {
        if (!deleted) {
            GL11.glDeleteTextures(id)
            deleted = true
        }
    }

    protected fun finalize() {
        delete()
    }
}
