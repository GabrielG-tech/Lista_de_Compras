package br.edu.infnet.listadecompras.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.infnet.listadecompras.daos.CategoriaDao
import br.edu.infnet.listadecompras.daos.ProdutoDao
import br.edu.infnet.listadecompras.models.Categoria
import br.edu.infnet.listadecompras.models.Produto

@Database(entities = [Categoria::class, Produto::class], version = 1, exportSchema = false)
abstract class LojaDatabase: RoomDatabase() {

    // Interfaces que alteram o banco de dados:
    abstract fun CategoriaDao(): CategoriaDao
    abstract fun ProdutoDao(): ProdutoDao

}