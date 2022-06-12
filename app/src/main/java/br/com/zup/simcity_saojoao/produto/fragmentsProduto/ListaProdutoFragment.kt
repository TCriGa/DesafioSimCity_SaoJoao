package br.com.zup.simcity_saojoao.produto.fragmentsProduto

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcity_saojoao.CHAVE_PRODUTO
import br.com.zup.simcity_saojoao.R
import br.com.zup.simcity_saojoao.databinding.FragmentListaProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto
import br.com.zup.simcity_saojoao.produto.adapter.ProdutoAdapter

class ListaProdutoFragment : Fragment() {
    private lateinit var binding: FragmentListaProdutoBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), ::irParDetalheProdutoFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarDadosProdutos()

    }


    private fun exibirRecycleView() {
        binding.rvListaProdutos.adapter = produtoAdapter
        binding.rvListaProdutos.layoutManager = LinearLayoutManager(context)

    }

    private fun recuperarDadosProdutos() {
        val receberProdutos = arguments?.getParcelableArrayList<Produto>(CHAVE_PRODUTO)

        if (receberProdutos != null) {
            produtoAdapter.atualizarListaProdutos(receberProdutos)
            exibirRecycleView()
        }

    }

    private fun irParDetalheProdutoFragment(produto: Produto) {
        val bundle = bundleOf(CHAVE_PRODUTO to produto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_listaProdutoFragment_to_detalheProdutoFragment, bundle)

    }
}


