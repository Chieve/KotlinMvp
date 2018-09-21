package com.chieveke.androidframework.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.chieveke.androidframework.R
import com.chieveke.androidframework.base.injection.component.DaggerMainActivityComponent
import com.chieveke.androidframework.feature.mvp.IUserView
import com.chieveke.androidframework.feature.mvp.presenter.UserPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View.OnClickListener, IUserView {


    @Inject
    lateinit var presenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Example of a call to a native method
//        sample_text.text = stringFromJNI()
        saveButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)
        DaggerMainActivityComponent.create().inject(this)
        presenter.attachView(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.saveButton -> Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show()
            R.id.saveButton -> presenter.saveUser(getID(),getUserName(),getAge())
//            R.id.saveButton -> Timber.d("使用Dagger注入变量，mBeanForDagger Name：" + mBeanForDagger?.name)
//            R.id.loadButton -> Toast.makeText(this, "$presenter", Toast.LENGTH_SHORT).show()
            R.id.loadButton -> presenter.loadUser(getID())
        }
    }

    override fun getID(): Int {
        val id = edt_id.text.toString().trim()
        if(id.isNotEmpty()){
            return id.toInt()
        }else{
            return 0
        }
    }

    override fun getUserName(): String {
        return edt_username.text.toString()
    }

    override fun getAge(): Int {
        val age = edt_age.text.toString().trim()
        if (age.isNotEmpty())
            return age.toInt()
        else
            return 0
    }

    override fun setUserName(userName: String) {
        Log.d("test_log", "setUsername:$userName")
        edt_username.setText(userName.toString())
    }

    override fun setAge(age: Int) {
        val d = Log.d("test_log", "setUsername:$age")
        edt_age.setText(age.toString())
    }

    override fun onSaveSuccess() {
        edt_id.setText("")
        edt_username.setText("")
        edt_age.setText("")
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
