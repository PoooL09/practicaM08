package com.pallares.pol.practicam08.mediarecorder

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.pallares.pol.practicam08.R
import java.io.IOException

class MediaRecorderActivity : AppCompatActivity() {
    private var grabacion: MediaRecorder? = null
    private var salida: String? = null
    private var btnGrabar: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.f_grab)
        btnGrabar = findViewById<View>(R.id.btnGrabar) as Button
        back()
        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MediaRecorderActivity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO), 1000)
        }
    }

    private fun back() {
        supportActionBar!!.title = "GRABADORA"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun Grabar(view: View?) {
        if (grabacion == null) {
            salida = Environment.getExternalStorageDirectory().absolutePath + "/Grabacion.mp3"
            grabacion = MediaRecorder()
            grabacion!!.setAudioSource(MediaRecorder.AudioSource.MIC)
            grabacion!!.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            grabacion!!.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
            grabacion!!.setOutputFile(salida)
            try {
                grabacion!!.prepare()
                grabacion!!.start()
            } catch (e: IOException) {
            }
            Toast.makeText(applicationContext, "Grabando....", Toast.LENGTH_SHORT).show()
        } else if (grabacion != null) {
            grabacion!!.stop()
            grabacion!!.release()
            grabacion = null
            btnGrabar!!.setBackgroundResource(R.drawable.btn1)
            Toast.makeText(applicationContext, "Grabación Finalizada....", Toast.LENGTH_SHORT).show()
        }
    }

    fun Reproducir(view: View?) {
        if (salida != null) {
            val mediaPlayer = MediaPlayer()
            try {
                mediaPlayer.setDataSource(salida)
                mediaPlayer.prepare()
            } catch (e: IOException) {
            }
            mediaPlayer.start()
            Toast.makeText(applicationContext, "Reproduciendo Audio.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "No hay ningun audio.", Toast.LENGTH_SHORT).show()
        }
    }
}