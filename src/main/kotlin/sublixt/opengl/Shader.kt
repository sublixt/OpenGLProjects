package sublixt.opengl

import org.lwjgl.opengl.GL20
import kotlin.properties.Delegates

public class VertexShader (source: String) {
    public val id: Int = GL20.glCreateShader(GL20.GL_VERTEX_SHADER)
    public val infoLog: String by Delegates.lazy { GL20.glGetShaderInfoLog(id) }

    init {
        GL20.glShaderSource(id, source)
        GL20.glCompileShader(id)
    }

    public fun delete() {
        GL20.glDeleteShader(id)
    }

    protected fun finalize() {
        delete()
    }
}

public class FragmentShader (source: String) {
    public val id: Int = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER)
    public val infoLog: String by Delegates.lazy { GL20.glGetShaderInfoLog(id) }

    init {
        GL20.glShaderSource(id, source)
        GL20.glCompileShader(id)
    }

    public fun delete() {
        GL20.glDeleteShader(id)
    }

    protected fun finalize() {
        delete()
    }
}
