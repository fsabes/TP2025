package lyc.compiler.model

import kotlin.collections.iterator
const val FORMAT_TABLE = "| %-28s | %-15s | %-28s | %-8s |";
class SymbolTable {

    private val table = mutableMapOf<String, Symbol>()

    fun addSymbol(name: String, type: String, value: Any? = null, length: Int? = null) {
        table[name] = Symbol(name, type, value, length)
    }

    fun printTable() {
        val separator = "+------------------------------+-----------------+------------------------------+----------+"
        println(separator)
        println(FORMAT_TABLE.format("NOMBRE", "TIPO DE DATO", "VALOR", "LONGITUD"))
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
}