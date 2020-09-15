package shohjahont9.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.custom_brigada.view.*
import shohjahont9.objects.Brigada
import shohjahont9.yoshbrigada.R
import shohjahont9.yoshbrigada.mass

class BrigadaAdapter(val mCtx:Context, val layoutResId: Int,val brigadaList: List<Brigada>) :
    ArrayAdapter<Brigada>(mCtx, layoutResId, brigadaList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(mCtx)
        val view = layoutInflater.inflate(layoutResId,null)

        val textviewName = view.findViewById<TextView>(R.id.text_view_brigada)
        val massa = view.findViewById<TextView>(R.id.text_view_brigada_massa)

        val brigada =brigadaList[position]

        textviewName.text=brigada.name
        view.text_view_brigada_massa.text = mass.toString()
        return view
    }
}