package br.com.zup.simcity_saojoao.produto.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.zup.simcity_saojoao.CHAVE_PRODUTO
import br.com.zup.simcity_saojoao.ICONE_FAVORITAR
import br.com.zup.simcity_saojoao.R
import br.com.zup.simcity_saojoao.databinding.FragmentDetalheProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto
import br.com.zup.simcity_saojoao.produto.ProdutosActivity

class DetalheProdutoFragment : Fragment() {

    private lateinit var binding: FragmentDetalheProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheProdutoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as ProdutosActivity).supportActionBar?.title = getString(R.string.produto)

        recuperarExibirDadosProduto()
        habilitarBotaoVoltar()
        cliclIconeFavoritar()

    }

    private fun habilitarBotaoVoltar() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigateUp()
        }
    }

    private fun recuperarExibirDadosProduto() {
        val produto = arguments?.getParcelable<Produto>(CHAVE_PRODUTO)

        if (produto != null) {
            binding.textNomeProduto.text =
                "${getString(R.string.nome_do_produto)} ${produto.getNomeProduto()}"
            binding.textQuantidade.text =
                "${getString(R.string.quantidade_produto)} ${produto.getQuantidade()}"
            binding.textValorUnitario.text =
                "${getString(R.string.valor_unitario)} ${produto.getValorProduto()}"
            binding.textReceita.text =
                "${getString(R.string.receita_produto)} ${produto.getReceita()}"

        }
    }


    private fun cliclIconeFavoritar() {
        binding.imagemFavoritar.setOnClickListener {
            Toast.makeText(context, ICONE_FAVORITAR, Toast.LENGTH_LONG).show()
        }
    }
}