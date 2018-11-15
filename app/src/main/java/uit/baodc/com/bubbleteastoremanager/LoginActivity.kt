package uit.baodc.com.bubbleteastoremanager

import android.animation.Animator
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.VISIBLE
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import android.R.attr.button
import android.R.attr.onClick
import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.content.SharedPreferences


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)
        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                TeaTextView.visibility = View.GONE
                loadingProgressBar.visibility = View.GONE
                rootView.setBackgroundColor(ContextCompat.getColor(this@LoginActivity, R.color.colorSplashText))
                BubbleTeaIconImageView.setImageResource(R.drawable.bubble_tea)
                startAnimation()
            }

            override fun onTick(p0: Long) {}
        }.start()

        // Hien toast message o nut forget password
        val txtForget = findViewById(R.id.forgetpassword) as TextView
        txtForget.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Contact Bao for help", Toast.LENGTH_LONG).show()// Set your own toast  message
        })
        //  setting nut dang nhap
        val etUser = findViewById(R.id.userEditText) as TextView
        val etPass = findViewById(R.id.passwordEditText) as TextView
        val btnDangNhap = findViewById(R.id.loginButton) as Button
        btnDangNhap.setOnClickListener(
                View.OnClickListener {
                    val stringUsername = etUser.toString();
                    val stringPassword = etPass.toString();
                    val task = "Login";
                    val preferences = this.getSharedPreferences("MYPREFS", Context.MODE_PRIVATE)

                    val mName = preferences.getString("name", "ERROR getting name")
                    val mEmail = preferences.getString("email", "ERROR getting email")
                    etPass.setText(mName);
                    etUser.setText(mEmail);
                    val loginbackground = BackgroundActivity(LoginActivity)

                }
        )

    }

    private fun startAnimation() {
        BubbleTeaIconImageView.animate().apply {
            x(50f)
            y(100f)
            duration = 1000
        }.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                afterAnimationView.visibility = VISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }
        })
    }
}