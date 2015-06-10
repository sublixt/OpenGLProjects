package sublixt

import java.io.*

public fun String.div(other: String): String = this + File.separator + other

public fun InputStream.mkString(): String {
    val builder = StringBuilder()
    val reader = BufferedReader(InputStreamReader(this))

    while(true) {
        val line: String? = reader.readLine()
        if(line === null) break
        builder.append(line)
        builder.append('\n')
    }

    reader.close()
    return builder.toString()
}

public fun File.mkString(): String {
    val builder = StringBuilder()
    val reader = BufferedReader(FileReader(this))

    while(true) {
        val line: String? = reader.readLine()
        if(line === null) break
        builder.append(line)
        builder.append('\n')
    }

    reader.close()
    return builder.toString()
}
