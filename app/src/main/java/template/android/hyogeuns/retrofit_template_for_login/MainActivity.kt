package template.android.hyogeuns.retrofit_template_for_login

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFERENCE = "si.template.samplesharepreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)
        var users = pref.getString("username", "")
        hello.text = "환영합니다" + users + "님"
    }
}
