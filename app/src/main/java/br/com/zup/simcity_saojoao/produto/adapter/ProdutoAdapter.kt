package br.com.zup.simcity_saojoao.produto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcity_saojoao.databinding.ProdutoItemBinding
import br.com.zup.simcity_saojoao.model.Produto


class ProdutoAdapter(
    private var listaProdutos: MutableList<Produto>,
    private val clickProduto: (produto: Produto) -> Unit
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val carrinhoProduto = listaProdutos[position]
        holder.adicionarInformacoesView(carrinhoProduto)
        holder.binding.cardVItemProduto.setOnClickListener {
            clickProduto(carrinhoProduto)
        }
    }

    override fun getItemCount() = listaProdutos.size

  fun atualizarListaProdutos(novaListaProduto: MutableList<Produto>) {
        if (listaProdutos.size == 0) {
            listaProdutos.addAll(novaListaProduto)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
       fun adicionarInformacoesView(produto: Produto) {
            binding.textNomeProdutosCadastrados.text = produto.getNomeProduto()
            binding.textQuantidadeCadastrada.text = "${produto.getQuantidade()} ->"
        }
    }
}