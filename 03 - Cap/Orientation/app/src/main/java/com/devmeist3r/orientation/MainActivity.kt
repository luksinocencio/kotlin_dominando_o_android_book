package com.devmeist3r.orientation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var names = arrayListOf<String>()
    var adapter: ArrayAdapter<String>? = null

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putStringArrayList("names_list", names)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (lastCustomNonConfigurationInstance != null) {
//            names = lastCustomNonConfigurationInstance as ArrayList<String>
//        }

        if (savedInstanceState != null) {
            names = savedInstanceState.getStringArrayList("names_list") ?: arrayListOf()
        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        lstNames.adapter = adapter
    }


//    override fun onRetainCustomNonConfigurationInstance(): Any? {
//        return names
//    }

    fun btnAddClick(view: View) {
        if(edtName.text.isNotEmpty()) {
            names.add(edtName.text.toString())
            edtName.text.clear()
            adapter?.notifyDataSetChanged()
        } else {
            Toast.makeText(this, "Informe um nome", Toast.LENGTH_LONG).show()
        }
    }
}