package lyc.compiler.model

data class Symbol(
    val name: String,
    val type: String,
    val value: Any? = null,
    val length: Int? = null
)