package com.bangkit.navomobility


import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.speech.tts.TextToSpeech.QUEUE_FLUSH
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MicrophoneAI : AppCompatActivity(), OnInitListener {

    private lateinit var textToSpeech: TextToSpeech
    private lateinit var inputText: EditText
    private lateinit var microphoneButton: ImageButton

    companion object {
        private const val RECORD_AUDIO_PERMISSION_CODE = 1
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail
        )

        microphoneButton = findViewById(R.id.microphoneButton)

        textToSpeech = TextToSpeech(this, this)

        microphoneButton.setOnClickListener {
            if (isSpeechRecognitionPermissionGranted()) {
                startSpeechRecognition()
            } else {
                requestSpeechRecognitionPermission()
            }
        }
    }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech.language = Locale("id")
            // Set pitch level (misalnya, 1.5 untuk pitch lebih tinggi)
            val pitchLevel = 1.4f
            textToSpeech.setPitch(pitchLevel)
        }
    }

    private fun handleVoiceCommand(command: String) {
        val response = when {
            command.contains("halo") -> "Halo! Saya Navo, Ada yang bisa saya bantu?"
            command.contains("siapa nama kamu") -> "Halo! Saya adalah Navo, Asisten Perjalanan Pintar Kamu"
            command.contains("bagaimana kabar kamu") -> "Saya baik, terima kasih!"
            command.contains("jogja") -> "Oke, akan saya arahkan ke jogja."
            command.contains("bekasi") -> "Oke, akan saya arahkan ke bekasi."
            command.contains("jakarta") -> "Oke, akan saya arahkan ke jakarta."
            command.contains("bogor") -> "Oke, akan saya arahkan ke bogor."
            command.contains("bandung") -> "Oke, akan saya arahkan ke bandung."
            command.contains("garut") -> "Oke, akan saya arahkan ke garut."
            command.contains("depok") -> "Oke, akan saya arahkan ke depok."
            command.contains("apakah kamu bisa membantu saya") -> "Ya, saya bisa membantu kamu, Karena saya adalah asisten perjalanan pintar kamu. Apa yang bisa saya bantu?"
            command.contains("tolong bantu saya") -> "Ya, saya bisa membantu kamu, Karena saya adalah asisten perjalanan pintar kamu. Apa yang bisa saya bantu?"
            command.contains("apakah kamu bisa membantu aku") -> "Ya, saya bisa membantu kamu, Karena saya adalah asisten perjalanan pintar kamu. Apa yang bisa saya bantu?"
            command.contains("apakah kamu bisa membantuku") -> "Ya, saya bisa membantu kamu, Karena saya adalah asisten perjalanan pintar kamu. Apa yang bisa saya bantu?"
            else -> "Maaf, saya tidak mengerti."
        }

        speakText(response)
        inputText.setText(response) // Menampilkan output suara di EditText
    }


    private fun speakText(text: String) {
        textToSpeech.speak(text, QUEUE_FLUSH, null, null)
    }

    private fun isSpeechRecognitionPermissionGranted(): Boolean {
        return if (SDK_INT >= Build.VERSION_CODES.M) {
            checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    private fun requestSpeechRecognitionPermission() {
        requestPermissions(
            arrayOf(Manifest.permission.RECORD_AUDIO),
            RECORD_AUDIO_PERMISSION_CODE
        )
    }

    private fun startSpeechRecognition() {
        val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        val listener = object : RecognitionListener {
            override fun onResults(results: Bundle?) {
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (matches != null && matches.isNotEmpty()) {
                    val spokenText = matches[0]
                    inputText.setText(spokenText)
                    handleVoiceCommand(spokenText.toLowerCase(Locale.getDefault()))
                }
            }

            override fun onReadyForSpeech(params: Bundle?) {}

            override fun onBeginningOfSpeech() {}

            override fun onRmsChanged(rmsdB: Float) {}

            override fun onBufferReceived(buffer: ByteArray?) {}

            override fun onEndOfSpeech() {}

            override fun onError(error: Int) {
                // Handle errors if needed
            }

            override fun onPartialResults(partialResults: Bundle?) {}

            override fun onEvent(eventType: Int, params: Bundle?) {}
        }

        speechRecognizer.setRecognitionListener(listener)
        speechRecognizer.startListening(speechRecognizerIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RECORD_AUDIO_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startSpeechRecognition()
            }
        }
    }


}
