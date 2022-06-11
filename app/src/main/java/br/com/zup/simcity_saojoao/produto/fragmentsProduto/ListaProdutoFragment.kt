package br.com.zup.simcity_saojoao.produto.fragmentsProduto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcity_saojoao.CHAVE_PRODUTO
import br.com.zup.simcity_saojoao.databinding.FragmentListaProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto
import br.com.zup.simcity_saojoao.produto.adapter.ProdutoAdapter

class ListaProdutoFragment : Fragment() {
    private lateinit var binding: FragmentListaProdutoBinding
    private var nomeProduto: String = ""
    private var quantidade: Int = 0
    private var valorProduto: Double = 0.0
    private var receita: String = " "
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
        val listaProduto = mutableListOf<Produto>()
        val receberProdutos = recuperarProduto()
        listaProduto.addAll(listOf(receberProdutos))
        produtoAdapter.atualizarListaProdutos(listaProduto)
        exibirRecycleView()
    }

    private fun recuperarProduto(): Produto {
        val produto = arguments?.getParcelable<Produto>(CHAVE_PRODUTO)
        if (produto != null) {
            val produtorecebido = Produto(
                produto.getNomeProduto(),
                produto.getQuantidade(),
                produto.getValorProduto(),
                produto.getReceita()
            )
            this.nomeProduto = produtorecebido.getNomeProduto()
            this.valorProduto = produto.getValorProduto()
            this.quantidade = produtorecebido.getQuantidade()
            this.receita = produtorecebido.getReceita()
        }
        return Produto(nomeProduto, quantidade, valorProduto, receita)
    }
    private fun irParDetalheProdutoFragment(produto: Produto){

    }


}

