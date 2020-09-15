package shohjahont9.yoshbrigada

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_brigada.*
import kotlinx.android.synthetic.main.dialog_add.*
import kotlinx.android.synthetic.main.dialog_add.view.*
import shohjahont9.Adapter.BrigadaAdapter
import shohjahont9.objects.Brigada

var mass = 0

class BrigadaActivity : AppCompatActivity() {

    lateinit var listview:ListView
    lateinit var ref: DatabaseReference
    lateinit var brigadaList: MutableList<Brigada>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brigada)

        brigadaList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("brigadalar")

        listview = findViewById(R.id.listview_brig)


        val text = intent.getStringExtra("txt")
        text_toolbar.text = text


        add_icon_img.setOnClickListener {
            showDialog()
        }

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    brigadaList.clear()
                    for (h in p0.children){
                        val brigada = h.getValue(Brigada::class.java)
                        brigadaList.add(brigada!!)
                    }

                    val adapter = BrigadaAdapter(applicationContext,R.layout.custom_brigada, brigadaList)
                    listview.adapter = adapter

                }
            }
        })

    }

    @SuppressLint("ResourceType")
    fun showDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add, null)

        val mBuilder = AlertDialog.Builder(this).setView(mDialogView).setCancelable(false)
        val dialog = mBuilder.create()
        dialog.show()
        mDialogView.btn_save.setOnClickListener {
            val name = mDialogView.edit_name.text.toString().trim()
            if (name.isEmpty()) {
                mDialogView.edit_name.error = "Iltimos brigada ismini kiriting"
                return@setOnClickListener
            }

            val brigadaId = ref.push().key

            val brigada = Brigada(brigadaId.toString(), name, mass.toString())

            ref.child(brigadaId.toString()).setValue(brigada).addOnCompleteListener {
                Toast.makeText(applicationContext, "saved", Toast.LENGTH_SHORT).show()
            }

            dialog.dismiss()

        }
        mDialogView.btn_leave.setOnClickListener {
            dialog.dismiss()
        }
    }

}