package lyc.compiler.model

import kotlin.collections.iterator

private const val FORMAT_TABLE = "| %-28s | %-15s | %-28s | %-8s |"
private val header = FORMAT_TABLE.format("NOMBRE", "TIPO DE DATO", "VALOR", "LONGITUD")

class SymbolTable {

    fun addSymbol(name: String, type: String, value: Any? = null, length: Int? = null) {
        table[name] = Symbol(name, type, value, length)
    }

    fun printTable() {
        val separator = "+------------------------------+-----------------+------------------------------+----------+"
        println(separator)
        println(header)
        println(separator)

        for ((_, symbol) in table) {
            val name = symbol.name
            val type = symbol.type
            val value = symbol.value?.toString() ?: "—"
            val length = symbol.length?.toString() ?: "—"

            println(FORMAT_TABLE.format(name, type, value, length))
        }

        println(separator)
    }

    companion object {
        val table = mutableMapOf<String, Symbol>()

        fun getTableAsString(): String {
            val separator =
                "+------------------------------+-----------------+------------------------------+----------+"
            val sb = StringBuilder()

            sb.appendLine(separator)
            sb.appendLine(header)
            sb.appendLine(separator)

            for ((_, symbol) in table) {
                val name = symbol.name
                val type = symbol.type
                val value = symbol.value?.toString() ?: "—"
                val length = symbol.length?.toString() ?: "—"

                sb.appendLine(FORMAT_TABLE.format(name, type, value, length))
            }

            sb.appendLine(separator)

            return sb.toString()
        }
    }
}