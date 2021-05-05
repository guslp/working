package fr.Projinfo.Ecamarket.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.Projinfo.Ecamarket.MainActivity
import fr.Projinfo.Ecamarket.OfferModel
import fr.Projinfo.Ecamarket.R

class OfferAdapter(
    private val context : MainActivity,
    private val OfferList: List<OfferModel>,
    private val layoutId : Int) : RecyclerView.Adapter<OfferAdapter.ViewHolder>() {

    //boite pour ranger tous les composanta à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        //image de l'offre
        val OfferImage = view.findViewById<ImageView>(R.id.image_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // recuperer les informations de la plante
        val currentOffer = OfferList[position]

        //utiliser glide pour récupérer l'image à partir de son lien
        Glide.with(context).load(Uri.parse(currentOffer.ImageUrl)).into(holder.OfferImage)

    }

    override fun getItemCount(): Int = OfferList.size
}