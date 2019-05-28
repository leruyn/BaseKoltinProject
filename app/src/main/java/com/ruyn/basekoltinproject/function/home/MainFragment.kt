package com.ruyn.basekoltinproject.function.home

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since May-17-2019
 */
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import com.ruyn.basekoltinproject.R
import com.ruyn.basekoltinproject.base.BaseFragment
import com.ruyn.basekoltinproject.model.RepositoriesEntity
import com.ruyn.basekoltinproject.model.UserEntity
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : BaseFragment() {
    override fun setUpViewModel() {

        Log.d("RLV", "setupViewModel")
        //0.0 Config UserViewModel
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        setObserveLive(viewModel)

        //1.0  Observe showUserInfo
        val userObserver = Observer<UserEntity> { userEntity ->
            setupUserInfo(userEntity)
        }
        viewModel.showUserInfo().observe(this, userObserver)

        //2.0 Observe showRepositories
        val repoObserver = Observer<List<RepositoriesEntity>> {
            setupRepositories(it)
        }
        viewModel.showRepositories().observe(this, repoObserver)
    }

    override fun setUpUI(view: View) {
        Log.d("RLV", "setupViewModel")
        btn_load_data.setOnClickListener {
            viewModel.getUserInfo("vietruyn")
            viewModel.getRepositories("vietruyn")
        }
    }

    private lateinit var viewModel: UserViewModel

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    override fun getRootLayoutId(): Int {
        return R.layout.main_fragment
    }


    private fun setupRepositories(it: List<RepositoriesEntity>?) {
        val repoName: MutableList<String> = mutableListOf()
        for (repo in it!!) {
            repoName.add(repo.name + "\n" + repo.full_name)
        }
        val adapter = ArrayAdapter(
            context!!,
            android.R.layout.simple_list_item_1, android.R.id.text1, repoName
        )
        list_repositories.adapter = adapter
    }

    private fun setupUserInfo(entity: UserEntity?) {
        tv_name_user.text = entity!!.name
    }

}