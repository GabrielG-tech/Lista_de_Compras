package br.edu.infnet.listadecompras.daos


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.edu.infnet.listadecompras.models.Categoria

@Dao
interface CategoriaDao {
    // CRUD:

    // Create
    @Insert
    fun insert(categoria: Categoria)

    // Read
    @Query("SELECT * FROM Categoria WHERE Categoria.id = :id")
    fun getById(id: Long): Categoria

    // Update
    @Update
    fun update(categoria: Categoria)

    // Delete
    @Delete
    fun delete(categoria: Categoria)


    @Query("SELECT * FROM Categoria")
    fun getAll(): List<Categoria>

}