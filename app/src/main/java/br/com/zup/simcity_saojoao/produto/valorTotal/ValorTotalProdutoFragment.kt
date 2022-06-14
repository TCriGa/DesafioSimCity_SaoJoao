package br.com.zup.simcity_saojoao.produto.valorTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.zup.simcity_saojoao.CHAVE_PRODUTO
import br.com.zup.simcity_saojoao.R
import br.com.zup.simcity_saojoao.databinding.FragmentValorTotalProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto


class ValorTotalProdutoFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentValorTotalProdutoBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.valor_total)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receberExibirDadosProdutos()
        bindingClicks()
    }

    private fun receberExibirDadosProdutos() {
        var valorTotal = 0.0
        arguments?.getParcelableArrayList<Produto>(CHAVE_PRODUTO)?.forEach {
            valorTotal += (it.getValorProduto() * it.getQuantidade())
        }
        binding.textValorTotal.text = "${getString(R.string.O_valor_total)} $valorTotal"
    }

    private fun getListaNovaBundle(): Bundle? =
        (arguments?.getParcelableArrayList<Produto>(CHAVE_PRODUTO) as? ArrayList<Produto>)
            ?.let {
                return bundleOf(CHAVE_PRODUTO to it)
            }


    private fun bindingClicks() {
        binding.buttonCadastrarNovoProduto2.setOnClickListener {
            findNavController().navigate(
                R.id.action_valorTotalProdutoFragment_to_cadastrarProdutoFragment,
                getListaNovaBundle()
            )
        }
        binding.buttonVerProduto.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                R.id.action_valorTotalProdutoFragment_to_listaProdutoFragment,
                getListaNovaBundle()
            )
        }
    }
}


