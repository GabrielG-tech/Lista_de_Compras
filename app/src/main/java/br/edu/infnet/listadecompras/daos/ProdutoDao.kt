package br.edu.infnet.listadecompras.daos


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.edu.infnet.listadecompras.models.Produto

@Dao
interface ProdutoDao {
    // CRUD:

    // Create
    @Insert
    fun insert(produto: Produto)

    // Read
    @Query("SELECT * FROM Produto WHERE Produto.id = :id")
    fun getById(id: Long): Produto

    // Update
    @Update
    fun update(produto: Produto)

    // Delete
    @Delete
    fun delete(produto: Produto)


    @Query("SELECT * FROM Produto")
    fun getAll(): List<Produto>

    @Query("SELECT * FROM Produto WHERE categoriaId = :id")
    fun getProdutosByCategoriaId(id: Long) : List<Produto>

}