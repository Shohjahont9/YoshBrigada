package shohjahont9.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.custom_listview.view.*
import shohjahont9.yoshbrigada.R

class Custom_Adapter_tuman(
    private val activity: Activity,
    private val images: Array<Int>,
    private val titles: Array<String>
) : BaseAdapter() {

    lateinit var inflater: LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_listview, null)

        view.img_view_tuman.setImageResource(images[position])
        view.text_view_tuman.text = titles[position]

        return view
    }

    override fun getItem(position: Int): Any = 0

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = images.size
}