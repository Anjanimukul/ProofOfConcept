package com.example.proofofconcept.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proofofconcept.R
import com.example.proofofconcept.databinding.HomeActivityBinding
import com.example.proofofconcept.ui.base.BaseActivity
import com.example.proofofconcept.ui.home.adapter.HomeAdapter
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeContract.View{

    private lateinit var mBinding: HomeActivityBinding

    lateinit var mPresenter: HomeContract.Presenter<HomeContract.View>
        @Inject set

    lateinit var mAdapter: HomeAdapter
        @Inject set

    companion object {
        fun startActivity(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.home_activity)

        activityComponent.inject(this)

        mPresenter.onAttach(this)

    }

    override fun initToolBar(title: String) {
        setSupportActionBar(mBinding.toolbar)
        mBinding.toolbar.title = title
    }

    override fun setUpRecyclerView() {
        mBinding.recyclerView.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(this@HomeActivity)
                adapter = mAdapter
            } else {
                mAdapter.notifyDataSetChanged()
            }
            visibility = View.VISIBLE
            hideProgressBar()
        }
    }

    override fun hideProgressBar() {
        mBinding.progressBar.visibility = View.GONE
    }

    override fun showProgressBar() {
        mBinding.progressBar.visibility = View.VISIBLE
    }

    override fun showEmptyView() {
        mBinding.tvEmptyView.visibility = View.VISIBLE
        mBinding.progressBar.visibility = View.GONE
        mBinding.recyclerView.visibility = View.GONE
    }

}