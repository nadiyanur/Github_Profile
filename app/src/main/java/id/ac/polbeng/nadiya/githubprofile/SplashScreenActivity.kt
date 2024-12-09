package id.ac.polbeng.nadiya.githubprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import id.ac.polbeng.nadiya.githubprofile.activities.MainActivity
import id.ac.polbeng.nadiya.githubprofile.databinding.ActivitySplashScreenBinding
import id.ac.polbeng.nadiya.githubprofile.helpers.Config


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }, Config.SPLASH_SCREEN_DELAY)
    }
}

