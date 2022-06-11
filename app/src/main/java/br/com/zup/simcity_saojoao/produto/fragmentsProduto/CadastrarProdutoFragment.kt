package br.com.zup.simcity_saojoao.produto.fragmentsProduto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcity_saojoao.*
import br.com.zup.simcity_saojoao.databinding.FragmentCadastrarProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto

class CadastrarProdutoFragment : Fragment() {
    private lateinit var binding: FragmentCadastrarProdutoBinding
    private lateinit var nomeProduto: String
    private lateinit var quantidade: String
    private lateinit var valorProduto: String
    private lateinit var receita: String
    private val listaProduto = mutableListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastrarProdutoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCadastrarNovoProduto.setOnClickListener {
            adicianarProdutoLista()
            limparDadosDoCarrinho()
        }
        binding.buttonVerProdutos.setOnClickListener {
            irParaDetalheProduto()
        }
    }

    private fun adicianarProdutoLista() {
        recuperarDadosProdutos()
        if (!verificarCamposEdicao()) {
            val produto = Produto(nomeProduto, quantidade.toInt(), valorProduto.toDouble(), receita)
            listaProduto.add(produto)
        }

    }

    private fun recuperarDadosProdutos() {
        this.nomeProduto = binding.editNomeProduto.text.toString()
        this.quantidade = binding.editQuantidade.text.toString()
        this.valorProduto = binding.editValorUnitario.text.toString()
        this.receita = binding.editReceita.text.toString()
    }

    private fun irParaDetalheProduto() {

            val bundle = bundleOf(CHAVE_PRODUTO to listaProduto)
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_cadastrarProdutoFragment_to_listaProdutoFragment, bundle)

    }

    private fun verificarCamposEdicao(): Boolean {
        when {
            this.nomeProduto.isEmpty() -> {
                binding.editNomeProduto.error = MENSAGEM_ERRO_NOME_PRODUTO
                return true
            }
            this.quantidade.isEmpty() -> {
                binding.editQuantidade.error = MENSAGEM_ERRO_QUANTIDADE
                return true
            }
            this.valorProduto.isEmpty() -> {
                binding.editValorUnitario.error = MENSAGEM_ERRO_VALOR_PRODUTO
                return true
            }
            this.receita.isEmpty() -> {
                binding.editReceita.error = MENSAGEM_ERRO_RECEITA
                return true
            }
        }
        return false
    }

    private fun limparDadosDoCarrinho() {
        binding.editNomeProduto.text.clear()
        binding.editQuantidade.text.clear()
        binding.editValorUnitario.text.clear()
        binding.editReceita.text.clear()
    }
}


