package com.hero.diegocampos.hero.common.rest;

import android.app.Activity;

import com.hero.diegocampos.hero.R;
import com.hero.diegocampos.hero.common.base.BaseActivity;
import com.hero.diegocampos.hero.common.rest.heroes.Heroes;
import com.hero.diegocampos.hero.common.rest.heroes.Superhero;
import com.hero.diegocampos.hero.hero.HeroActivity;
import com.hero.diegocampos.hero.listHeroes.presenter.ListHeroesPresenter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by neon2004 on 29/01/2017.
 */

public class HeroInteractor {
    private HeroActivity act;
    private ListHeroesPresenter callback;
    private Call<Heroes> call;


    public HeroInteractor(Activity activity, ListHeroesPresenter listHeroesPresenter) {
        act = (HeroActivity) activity;
        callback = listHeroesPresenter;
    }

    public ArrayList<Superhero> getListHeroes() {
        call = BaseActivity.interfaces.getHeroes();
        call.enqueue(new Callback<Heroes>() {
            @Override
            public void onResponse(Call<Heroes> call, Response<Heroes> response) {
                if (response.isSuccessful()) {
                    Heroes lisresult = new Heroes();
                    lisresult.setSuperheroes(response.body().getSuperheroes());
                    callback.createAdapter(lisresult);
                } else {
                    act.showSnackbar(act.getString(R.string.errorGetDatos));
                }
            }

            @Override
            public void onFailure(Call<Heroes> call, Throwable t) {
                act.showSnackbar(act.getString(R.string.errorGetDatos));
            }
        });
        return null;
    }

    public void cancelCall() {
        if (!call.isCanceled()) {
            call.cancel();
        }
    }
}
