package template.android.hyogeuns.retrofit_template_for_login


import android.Manifest
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    override var viewId: Int = R.layout.activity_login
    val PREFERENCE = "si.template.samplesharepreference"

    override fun onCreate() {

        SharedPref.openSharedPrep(this)
        login_btn.setOnClickListener {
            Client.retrofitService.logIn(id_tv.text.toString(), pw_tv.text.toString()).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                    when (response!!.code()) {
                        200 -> {
                            val pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)
                            val editor = pref.edit()
                            editor.putString("username", id_tv.text.toString())
                            editor.commit()
                            finish()
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        }
                        405 -> Toast.makeText(this@LoginActivity, "로그인 실패 : 아이디나 비번이 올바르지 않습니다", Toast.LENGTH_LONG).show()
                        500 -> Toast.makeText(this@LoginActivity, "로그인 실패 : 서버 오류", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>?, t: Throwable?) {

                }


            })
        }

        signup_go.setOnClickListener { startActivity(Intent(this@LoginActivity, SignUpActivity::class.java)) }
    }
}