package br.edu.infnet.listadecompras.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.infnet.listadecompras.models.Categoria
import br.edu.infnet.listadecompras.models.Produto
import br.edu.infnet.listadecompras.repositories.LojaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val repositorio = LojaRepository.get()

    fun insertCategoria(categoria: Categoria) {
        viewModelScope.launch(Dispatchers.IO){
            repositorio.insertCategoria(categoria)
        }
    }

    suspend fun getCategoriaById(id: Long) : Categoria {
        val categoria = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getCategoriaById(id)
        }
        return categoria.await()
    }

    fun deleteCategoriaById(id: Long) {
        viewModelScope.launch(Dispatchers.IO){
            repositorio.deleteCategoria(Categoria(id = id))
        }
    }

    fun updateCategoria(categoria: Categoria){
        viewModelScope.launch(Dispatchers.IO){
            repositorio.updateCategoria(categoria)
        }
    }

    suspend fun getAllCategoria(): List<Categoria> {
        val lista = viewModelScope.async(Dispatchers.IO){
            return@async repositorio.getAllCategoria()
        }
        return lista.await()
    }

    suspend fun getAllCategoriasString(): String{
        val lista = getAllCategoria()
        var texto = ""

        lista.forEach {
            texto += "${it.id} ${it.nome}\n"
        }
        return texto
    }

    // Produto:

    fun insertProduto(produto: Produto) {
        viewModelScope.launch(Dispatchers.IO){
            repositorio.insertProduto(produto)
        }
    }

    suspend fun getProdutoById(id: Long) : Produto {
        val produto = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getProdutoById(id)
        }
        return produto.await()
    }

    fun deleteProdutoById(id: Long) {
        viewModelScope.launch(Dispatchers.IO){
            repositorio.deleteProduto(Produto(id = id))
        }
    }

    fun updateProduto(produto: Produto){
        viewModelScope.launch(Dispatchers.IO){
            repositorio.updateProduto(produto)
        }
    }

    suspend fun getAllProdutos(): List<Produto> {
        val lista = viewModelScope.async(Dispatchers.IO){
            return@async repositorio.getAllProduto()
        }
        return lista.await()
    }

    suspend fun getProdutoByCategoriaId(id: Long): List<Produto> {
        val lista = viewModelScope.async(Dispatchers.IO){
            return@async repositorio.getAllProdutosByCategoriaId(id)
        }
        return lista.await()
    }


    suspend fun getAllProdutosString(): String{
        val lista = getAllProdutos()
        var texto = ""

        lista.forEach {
            texto += "${it.id} ${it.nome} - CategoriaId: ${it.categoriaId}\n"
        }
        return texto
    }

}