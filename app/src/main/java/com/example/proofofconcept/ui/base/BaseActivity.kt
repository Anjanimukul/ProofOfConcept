package com.example.proofofconcept.ui.base

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proofofconcept.ProofOfConceptApplication
import com.example.proofofconcept.di.components.ActivityComponent
import com.example.proofofconcept.di.components.DaggerActivityComponent
import com.example.proofofconcept.di.modules.ActivityModule

abstract class BaseActivity: AppCompatActivity(), BaseContract.View {

    lateinit var activityComponent: ActivityComponent

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        activityComponent = DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .applicationComponent((application as ProofOfConceptApplication).appComponent)
            .build()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showToast(message: String, length: Int) {
        Toast.makeText(this, message, length).show()
    }
}