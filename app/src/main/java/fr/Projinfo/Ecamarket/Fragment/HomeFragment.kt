package fr.Projinfo.Ecamarket.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.Projinfo.Ecamarket.MainActivity
import fr.Projinfo.Ecamarket.OfferModel
import fr.Projinfo.Ecamarket.R
import fr.Projinfo.Ecamarket.adapter.OfferAdapter
import fr.Projinfo.Ecamarket.adapter.OfferItemDecoration

class HomeFragment(
    private val context: MainActivity
): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        // creer une liste qui va stocker les offres
        val OfferList = arrayListOf<OfferModel>()

        //enregistrer une première offre dans notre liste
        OfferList.add(OfferModel(
            "Ps4",
            "Parfaite état",
            "https://media.istockphoto.com/photos/console-playstation-4-and-pad-dualshock-on-white-background-picture-id472077083?b=1&k=6&m=472077083&s=170667a&w=0&h=hgr4Jk08y5ik-kM6fcv10WheqbqqCEow9WEm_BbLH1s=",
            false
        ))

        //enregistrer une deuxième offre dans notre liste
        OfferList.add(OfferModel(
            "Iphone X",
            "Parfaite état",
            "https://cdn.pixabay.com/photo/2018/01/08/02/34/technology-3068617__340.jpg",
            false
        ))

        //enregistrer une troixieme offre dans notre liste
        OfferList.add(OfferModel(
            "Machine à laver",
            "Parfaite état",
            "https://cdn.pixabay.com/photo/2016/01/28/22/07/washing-machine-1167053__480.jpg",
            false
        ))

        //recuperer le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = OfferAdapter(context,OfferList, R.layout.item_horizontal_offer)

        //recuperer le second recyclerview
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = OfferAdapter(context,OfferList,R.layout.item_vertical_offer)
        verticalRecyclerView.addItemDecoration(OfferItemDecoration())

        return view
    }
}