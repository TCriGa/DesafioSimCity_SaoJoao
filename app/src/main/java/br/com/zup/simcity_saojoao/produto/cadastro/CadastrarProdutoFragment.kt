package br.com.zup.simcity_saojoao.produto.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcity_saojoao.*
import br.com.zup.simcity_saojoao.databinding.FragmentCadastrarProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto
import br.com.zup.simcity_saojoao.produto.ProdutosActivity

class CadastrarProdutoFragment : Fragment() {
    private lateinit var binding: FragmentCadastrarProdutoBinding
    private var listaNovaProduto = mutableListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastrarProdutoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.produto)

        clickButtonCadastrarNProduto()
        clickButtonIrParaDetalheProduto()
        clickIrParaValorTotal()
        receberArguments()
    }

    private fun receberArguments() {
        val listaRecebida = arguments?.getParcelableArrayList<Produto>(CHAVE_PRODUTO) ?: ArrayList()
        atualizarListaProdutos(listaRecebida)
    }

    private fun atualizarListaProdutos(novaListaProduto: MutableList<Produto>) {
        if (listaNovaProduto.size == 0) {
            listaNovaProduto.addAll(novaListaProduto)
        }
    }

    private fun clickButtonCadastrarNProduto() {
        binding.buttonCadastrarNovoProduto.setOnClickListener {
            adicionarProdutoLista()

        }

    }

    private fun clickButtonIrParaDetalheProduto() {
        binding.buttonVerProdutos.setOnClickListener {
            irParaDetalheProduto()
        }
    }

    private fun clickIrParaValorTotal() {
        binding.buttonValorTotal.setOnClickListener {
            irParaValorTotalProduto()
        }
    }

    private fun adicionarProdutoLista() {
        var nomeProduto = binding.editNomeProduto.text.toString()
        var quantidade: String = binding.editQuantidade.text.toString()
        var valorProduto: String = binding.editValorUnitario.text.toString()
        var receita: String = binding.editReceita.text.toString()
        fun verificarCamposEdicao(): Boolean {
            when {
                nomeProduto.isEmpty() -> {
                    binding.editNomeProduto.error = MENSAGEM_ERRO_NOME_PRODUTO
                    return true
                }
                quantidade.isEmpty() -> {
                    binding.editQuantidade.error = MENSAGEM_ERRO_QUANTIDADE
                    return true
                }
                valorProduto.isEmpty() -> {
                    binding.editValorUnitario.error = MENSAGEM_ERRO_VALOR_PRODUTO
                    return true
                }
                receita.isEmpty() -> {
                    binding.editReceita.error = MENSAGEM_ERRO_RECEITA
                    return true
                }
            }
            return false
        }
        if (!verificarCamposEdicao()) {
            val produto = Produto(nomeProduto, quantidade.toInt(), valorProduto.toDouble(), receita)
            listaNovaProduto.add(produto)
            Toast.makeText(
                context,
                getString(R.string.produto_cadastrado_sucesso),
                Toast.LENGTH_SHORT
            )
                .show()
            limparDadosDoCarrinho()
        }

    }


    private fun irParaDetalheProduto() {
        val bundle = bundleOf(CHAVE_PRODUTO to listaNovaProduto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_cadastrarProdutoFragment_to_listaProdutoFragment, bundle)

    }

    private fun irParaValorTotalProduto() {
        val bundle = bundleOf(CHAVE_PRODUTO to listaNovaProduto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_cadastrarProdutoFragment_to_valorTotalProdutoFragment, bundle)

    }

    private fun limparDadosDoCarrinho() {
        binding.editNomeProduto.text.clear()
        binding.editQuantidade.text.clear()
        binding.editValorUnitario.text.clear()
        binding.editReceita.text.clear()
    }

}


