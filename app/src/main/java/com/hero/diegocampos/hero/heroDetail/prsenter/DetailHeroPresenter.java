package com.hero.diegocampos.hero.heroDetail.prsenter;

import android.app.Activity;

import com.hero.diegocampos.hero.common.rest.heroes.Superhero;
import com.hero.diegocampos.hero.heroDetail.contract.DetailHeroContract;


public class DetailHeroPresenter implements DetailHeroContract.Presenter{

    private final Activity act;
    private final Superhero sh;
    private DetailHeroContract.View detailHeroFragments;

    public DetailHeroPresenter(DetailHeroContract.View detailHeroFragments, Activity activity, Superhero sh) {
        this.detailHeroFragments = detailHeroFragments;
        this.act = activity;
        this.sh = sh;
    }

    public void start(){

        detailHeroFragments.setImage(sh.getPhoto());
        detailHeroFragments.setTitulo(sh.getName());
        detailHeroFragments.setRealName(sh.getRealName());
        detailHeroFragments.setHeight(sh.getHeight());
        detailHeroFragments.setPower(sh.getPower());
        detailHeroFragments.setAbility(sh.getAbilities());
        detailHeroFragments.setGroups(sh.getGroups());
    }
}
