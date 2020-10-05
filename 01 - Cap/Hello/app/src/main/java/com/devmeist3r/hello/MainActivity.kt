package com.devmeist3r.hello

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtText = findViewById<EditText>(R.id.editTexto)
        val button = findViewById<Button>(R.id.buttonToast)

//        button.setOnClickListener {
//            val texto = edtText.text.toString()
//            Toast.makeText(this, "Olá $texto", Toast.LENGTH_SHORT).show()
//        }
//        button.setOnClickListener(object: View.OnClickListener {
//            override fun onClick(v: View?) {
//                val texto = edtText.text.toString()
//                Toast.makeText(this@MainActivity, "Olá $texto", Toast.LENGTH_SHORT).show()
//            }
//
//        })

        button.setOnClickListener { v ->
            if (v is Button) {
                val texto = edtText.text.toString()
                Toast.makeText(this, "${v.text} - $texto", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

//val config = resources.configuration
//val metrics = resources.displayMetrics
//val orientation = config.orientation
//val density = metrics.density
//val height = metrics.heightPixels
//val width = metrics.widthPixels
//val mcc = config.mcc
//val mnc = config.mnc
//val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) config.locales[0] else config.locale
//
//val tag = "NGVL"
//Log.d(tag, "density: $density")
//Log.d(tag, "orientation: $orientation")
//Log.d(tag, "height: $height")
//Log.d(tag, "width: $width")
//Log.d(tag, "language: ${locale.language} - ${locale.country}")
//Log.d(tag, "mcc: $mcc")
//Log.d(tag, "mnc: $mnc")