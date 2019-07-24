package template.android.hyogeuns.retrofit_template_for_login


import android.Manifest
import android.content.Intent
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class SplashActivity : BaseActivity() {

    val PREFERENCE = "si.template.samplesharepreference"
    override var viewId: Int = R.layout.activity_splash
    override fun onCreate() {
        val handler = Handler()
        handler.postDelayed({
                val intent = Intent(baseContext, LoginActivity::class.java)
                startActivity(intent)
            finish()
        }, 3000)
    }
}