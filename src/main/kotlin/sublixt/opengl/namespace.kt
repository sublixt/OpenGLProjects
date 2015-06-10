package sublixt.opengl

import java.io.File

public class ExceptionStack(val exception: Throwable, val tail: ExceptionStack?) {
    public fun forEach(f: (Throwable) -> Unit) {
        f(exception)
        tail?.forEach(f)
    }
}

private var exceptionStack: ExceptionStack? = null
public fun clearExceptionStack() {
    exceptionStack = null
}

public fun glExceptions(): ExceptionStack? = exceptionStack
public fun pushException(t: Throwable) {
    exceptionStack = ExceptionStack(t, exceptionStack)
}
