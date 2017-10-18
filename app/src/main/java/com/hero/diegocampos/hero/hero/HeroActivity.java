package com.hero.diegocampos.hero.hero;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.hero.diegocampos.hero.R;
import com.hero.diegocampos.hero.common.base.BaseActivity;
import com.hero.diegocampos.hero.common.base.BaseFragment;
import com.hero.diegocampos.hero.common.dialogs.DialogoWifi;
import com.hero.diegocampos.hero.common.rest.IRestClient;
import com.hero.diegocampos.hero.common.rest.heroes.Superhero;
import com.hero.diegocampos.hero.common.utils.Constants;
import com.hero.diegocampos.hero.heroDetail.DetailHeroFragments;
import com.hero.diegocampos.hero.heroDetail.DetailHeroFragments_;
import com.hero.diegocampos.hero.listHeroes.ListHeroesFragments;
import com.hero.diegocampos.hero.listHeroes.ListHeroesFragments_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class HeroActivity extends BaseActivity {

    @ViewById(R.id.contenedor)
    LinearLayout contenedor;


    private ListHeroesFragments listHeroesFragments;
    private DetailHeroFragments detailHeroFragments;
    public IRestClient interfaces;
    public BaseFragment FRAGMENT_ACTUAL;

    @AfterViews
    protected void HeroActivityAfterViews() {

        crearRetrofitGson();

        if(isOnline()){
            changeFragment(null, Constants.TAG_LISTAHEROSFR);
        }else{
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogoWifi dialogo = new DialogoWifi();
            dialogo.show(fragmentManager, "tagShowWifi");
        }
    }


    @Override
    public void onBackPressed() {
        if(FRAGMENT_ACTUAL instanceof ListHeroesFragments){
            finish();
        }else{
            changeFragment(null, Constants.TAG_LISTAHEROSFR);
        }
    }

    // CAMBIAMOS EL FRAGMENT A MOSTRAR
    public void changeFragment(Superhero superHero, String framgenCargar) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        switch (framgenCargar) {
            case Constants.TAG_LISTAHEROSFR:
                if (listHeroesFragments == null) {
                    listHeroesFragments = ListHeroesFragments_.builder().build();
                }
                FRAGMENT_ACTUAL = listHeroesFragments;
                ft.replace(android.R.id.content, listHeroesFragments);
                ft.commit();

                break;
            case Constants.TAG_DETAILHEROSFR:

                detailHeroFragments = DetailHeroFragments_.builder().hero(superHero).build();
                FRAGMENT_ACTUAL = detailHeroFragments;
                ft.replace(android.R.id.content, detailHeroFragments);
                ft.commit();
                break;
        }
    }
}
