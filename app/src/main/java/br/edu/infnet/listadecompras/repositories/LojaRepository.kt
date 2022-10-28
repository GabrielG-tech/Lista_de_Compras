package br.edu.infnet.listadecompras.repositories

import android.content.Context
import androidx.room.Room
import br.edu.infnet.listadecompras.database.LojaDatabase
import br.edu.infnet.listadecompras.models.Categoria
import br.edu.infnet.listadecompras.models.Produto

private const val DATABASE_NAME = "loja-db"

class LojaRepository private constructor(context: Context) {

    private val database: LojaDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            LojaDatabase::class.java,
            DATABASE_NAME
        )
        .build()

    companion object {
        private var INSTANCE: LojaRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = LojaRepository(context)
            }
        }

        fun get(): LojaRepository {
            return INSTANCE
                ?: throw IllegalStateException("LojaRepository deve ser inicializado.")
        }
    }

    // Chamar o DAO:
    fun insertCategoria(categoria: Categoria){
        database.categoriaDao().insert(categoria)
    }

    fun getCategoriaById(id: Long) : Categoria{
        return database.categoriaDao().getById(id)
    }

    fun deleteCategoria(categoria: Categoria) {
        database.categoriaDao().delete(categoria)
    }

    fun updateCategoria(categoria: Categoria){
        database.categoriaDao().update(categoria)
    }

    fun getAllCategoria(): List<Categoria> {
        return database.categoriaDao().getAll()
    }

    // Produto:

    fun insertProduto(produto: Produto){
        database.produtoDao().insert(produto)
    }

    fun getProdutoById(id: Long) : Produto{
        return database.produtoDao().getById(id)
    }

    fun deleteProduto(produto: Produto) {
        database.produtoDao().delete(produto)
    }

    fun updateProduto(produto: Produto){
        database.produtoDao().update(produto)
    }

    fun getAllProduto(): List<Produto> {
        return database.produtoDao().getAll()
    }

    fun getAllProdutosByCategoriaId(id: Long): List<Produto> {
        return database.produtoDao().getProdutosByCategoriaId(id)
    }


}
