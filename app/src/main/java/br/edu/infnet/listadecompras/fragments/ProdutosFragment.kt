package br.edu.infnet.listadecompras.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import br.edu.infnet.listadecompras.R
import br.edu.infnet.listadecompras.databinding.FragmentProdutosBinding
import br.edu.infnet.listadecompras.models.Categoria
import br.edu.infnet.listadecompras.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class ProdutosFragment : Fragment() {

    val viewModel : MainViewModel by viewModels()

    private var _binding: FragmentProdutosBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProdutosBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply{
            btnSave.setOnClickListener {
                onSaveClick()
            }

            btnGetByIdProduto.setOnClickListener {
                onGetByIdClick()
            }

            btnRemoveByIdProduto.setOnClickListener {
                onRemoveByIdClick()
            }

            btnGetByIdCategoria.setOnClickListener {
                onGetByIdClick()
            }

            btnRemoveByIdCategoria.setOnClickListener {
                onRemoveByIdClick()
            }

        }
    }

    private fun onRemoveByProductIdClick() {
        val idInput = binding.inputNomeIdProduto.text.toString().toLong()
        viewModel.deleteCategoriaById(idInput)
    }

    private fun onGetByProductIdClick() {
        val idInput = binding.inputNomeIdProduto.text.toString().toLong()
        lifecycleScope.launch {
            val categoria = viewModel.getCategoriaById(idInput)
            binding.tvCategoria.text = categoria.nome
        }
    }

    fun onSaveProductClick() {
        val nomeInput = binding.inputNomeProduto.text.toString()
        viewModel.insertCategoria(Categoria(nome = nomeInput))
    }

    private fun onRemoveByCategoryIdClick() {
        val idInput = binding.inputNomeIdProduto.text.toString().toLong()
        viewModel.deleteCategoriaById(idInput)
    }

    private fun onGetByCategoryIdClick() {
        val idInput = binding.inputNomeIdProduto.text.toString().toLong()
        lifecycleScope.launch {
            val categoria = viewModel.getCategoriaById(idInput)
            binding.tvCategoria.text = categoria.nome
        }
    }

    fun onSaveCategoryClick() {
        val nomeInput = binding.inputNomeProduto.text.toString()
        viewModel.insertCategoria(Categoria(nome = nomeInput))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}