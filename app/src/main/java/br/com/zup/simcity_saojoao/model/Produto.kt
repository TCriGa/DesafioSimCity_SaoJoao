package br.com.zup.simcity_saojoao.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produto(
    private var nomeProduto: String,
    private var quantidade: Int,
    private var valorProduto: Double,
    private var Receita: String
) : Parcelable {

    fun getNomeProduto() = this.nomeProduto
    fun getQuantidade() = this.quantidade
    fun getValorProduto() = this.valorProduto
    fun getReceita() = this.Receita
}