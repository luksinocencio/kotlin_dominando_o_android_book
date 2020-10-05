package com.devmeist3r.activityintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtText = findViewById<EditText>(R.id.editTexto)
        val button = findViewById<Button>(R.id.buttonToast)

        button.setOnClickListener {
            val texto = edtText.text.toString()
            Toast.makeText(this, "Olá $texto", Toast.LENGTH_SHORT).show()
        }

        buttonTela2.setOnClickListener {
            val intent = Intent(this, TelaActivity2::class.java)
            intent. putExtra("pessoa", Pessoa("Nelson", 34))
            startActivity(intent)
        }

        buttonParcel.setOnClickListener {
            val cliente = Cliente(1, "Lucas")
            val intent = Intent(this, TelaActivity2::class.java)
            intent.putExtra("cliente", Parcels.wrap(cliente))
            startActivity(intent)
        }

        buttonSerializable.setOnClickListener {
            val intent = Intent(this, TelaActivity2::class.java)
            intent.putExtra("pessoa", Pessoa("Lucas", 26))
            startActivity(intent)
        }
    }
}