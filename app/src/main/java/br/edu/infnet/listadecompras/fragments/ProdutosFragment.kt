package br.edu.infnet.listadecompras.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import br.edu.infnet.listadecompras.databinding.FragmentProdutosBinding
import br.edu.infnet.listadecompras.models.Produto
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

            btnGetById.setOnClickListener {
                onGetByIdClick()
            }

            btnRemoveById.setOnClickListener {
                onRemoveByIdClick()
            }

            btnUpdate.setOnClickListener {
                onUpdateClick()
            }

            btnListAll.setOnClickListener {
                onListClick()
            }



        }
    }

    private fun onListClick() {
        lifecycleScope.launch {
            val texto = viewModel.getAllProdutosString()
            binding.tvAllProdutos.text = texto
        }
    }

    private fun onUpdateClick() {
        val idInput = binding.inputIdProdutoUpdate.text.toString().toLong()
        val nomeInput = binding.inputNomeProdutoUpdate.text.toString()
        val categoriaIdInput = binding.inputIdCategoriaUpdate.text.toString().toLong()
        val produto = Produto(id = idInput, nome = nomeInput, categoriaId = categoriaIdInput)
        viewModel.updateProduto(produto)
    }

    private fun onRemoveByIdClick() {
        val idInput = binding.inputNomeIdProduto.text.toString().toLong()
        viewModel.deleteProdutoById(idInput)
    }

    private fun onGetByIdClick() {
        val idInput = binding.inputNomeIdProduto.text.toString().toLong()
        lifecycleScope.launch {
            val produto = viewModel.getProdutoById(idInput)
            binding.tvProduto.text = produto.nome
        }
    }

    fun onSaveClick() {
        val nomeInput = binding.inputNomeProduto.text.toString()
        val categoriaIdInput = binding.inputIdCategoria.text.toString().toLong()
        viewModel.insertProduto(Produto(nome = nomeInput, categoriaId = categoriaIdInput))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}