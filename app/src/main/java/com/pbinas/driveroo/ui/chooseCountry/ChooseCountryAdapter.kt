package com.pbinas.driveroo.ui.chooseCountry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.interactor.BaseInteractor
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.base.view.BaseView
import com.pbinas.driveroo.ui.chooseCountry.interactor.ChooseCountryInteractor
import com.pbinas.driveroo.ui.chooseCountry.presenter.ChooseCountryPresenter
import com.pbinas.driveroo.ui.chooseCountry.view.ChooseCountryView

class ChooseCountryAdapter(private val countriesList: List<CountryItem>, private val viewPresenter:
BasePresenter<BaseView, BaseInteractor>): RecyclerView.Adapter<ChooseCountryAdapter.ChooseCountryViewHolder>() {

    var parent: ViewGroup? = null
    var clickedItem = -1

    class ChooseCountryViewHolder(chooseCountryView: View): RecyclerView.ViewHolder(chooseCountryView) {
        val flagImage: ImageView = chooseCountryView.findViewById(R.id.flagImage)
        val countryTextView: TextView = chooseCountryView.findViewById(R.id.countryTextView)
        val view = chooseCountryView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseCountryAdapter.ChooseCountryViewHolder {
        this.parent = parent
        val chooseCountryView = LayoutInflater.from(parent.context).inflate(R.layout.country, parent, false)
        return ChooseCountryViewHolder((chooseCountryView))
    }

    override fun onBindViewHolder(holder: ChooseCountryAdapter.ChooseCountryViewHolder, position: Int) {
        val currentCountry = countriesList[position]
        holder.countryTextView.text = currentCountry.name
        val context: Context = holder.flagImage.context
        val id: Int = context.resources.getIdentifier(currentCountry.flagFileName, "drawable", context.packageName)
        holder.flagImage.setImageResource(id)
        holder.view.setOnClickListener { itemClicked(holder, position) }

        if(position != clickedItem) {
            changeColorBack(holder.view)
        } else {
            changeColor(holder.view)
        }
    }

    override fun getItemCount() = countriesList.size

    private fun itemClicked(holder: ChooseCountryAdapter.ChooseCountryViewHolder, position: Int) {
        clickedItem = position
        notifyDataSetChanged()
        if(viewPresenter is ChooseCountryPresenter<*, *>) {
            (viewPresenter as ChooseCountryPresenter< ChooseCountryView, ChooseCountryInteractor>).updateChosenItem(position)
        }
    }

    private fun changeColor(view: View) {
        view.setBackgroundResource(R.drawable.grey_shadow_chosen)
    }

    private fun changeColorBack(view: View) {
        view.setBackgroundResource(R.drawable.grey_shadow)
    }
}