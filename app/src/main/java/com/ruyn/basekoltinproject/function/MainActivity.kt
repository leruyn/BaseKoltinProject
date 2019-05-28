package com.ruyn.basekoltinproject.function

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ruyn.basekoltinproject.R
import com.ruyn.basekoltinproject.base.BaseActivity
import com.ruyn.basekoltinproject.function.home.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun setUpView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitAllowingStateLoss()
        }
    }


    override fun getRootLayoutId(): Int {
        return R.layout.activity_main
    }
}
