package br.edu.infnet.listadecompras.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.infnet.listadecompras.models.Categoria
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

}