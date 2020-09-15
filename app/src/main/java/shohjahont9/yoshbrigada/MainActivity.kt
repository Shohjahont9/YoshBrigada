package shohjahont9.yoshbrigada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import shohjahont9.Adapter.Custom_Adapter_tuman

class MainActivity : AppCompatActivity() {

    val images = arrayOf(
        R.drawable.navoi,
        R.drawable.navoi,
        R.drawable.navoi,
        R.drawable.navoi,
        R.drawable.navoi,
        R.drawable.navoi,
        R.drawable.navoi
    )

    val titles = arrayOf(
        "Navbahor",
        "Xatirchi",
        "Nurota",
        "Zarafshon",
        "Qiziltepa",
        "Uchquduq",
        "Karmana"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = Custom_Adapter_tuman(this, images, titles)
        listview_vil.adapter= adapter

        listview_vil.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext, BrigadaActivity::class.java)
            intent.putExtra("txt", titles[position])
            startActivity(intent)
        }
    }
}