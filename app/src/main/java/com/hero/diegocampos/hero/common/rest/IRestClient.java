package com.hero.diegocampos.hero.common.rest;

import com.hero.diegocampos.hero.common.rest.heroes.Heroes;
import com.hero.diegocampos.hero.common.utils.Constants;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by neon2004 on 28/01/2017.
 */

public interface IRestClient {
    @GET(Constants.TAG_PARAM_URL)
    Call<Heroes> getHeroes();


}
