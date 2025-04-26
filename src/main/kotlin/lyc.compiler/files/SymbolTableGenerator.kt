package lyc.compiler.files

import lyc.compiler.model.SymbolTable
import java.io.FileWriter
import java.io.IOException

class SymbolTableGenerator : FileGenerator {
    @Throws(IOException::class)
    override fun generate(fileWriter: FileWriter) {
        fileWriter.write(SymbolTable.getTableAsString())
    }
}