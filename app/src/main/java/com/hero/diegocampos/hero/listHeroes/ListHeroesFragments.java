package com.hero.diegocampos.hero.listHeroes;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hero.diegocampos.hero.R;
import com.hero.diegocampos.hero.common.adapters.HeroAdapter;
import com.hero.diegocampos.hero.common.base.BaseFragment;
import com.hero.diegocampos.hero.common.rest.heroes.Superhero;
import com.hero.diegocampos.hero.common.utils.Constants;
import com.hero.diegocampos.hero.hero.HeroActivity;
import com.hero.diegocampos.hero.listHeroes.contract.ListHeroesContract;
import com.hero.diegocampos.hero.listHeroes.presenter.ListHeroesPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * A placeholder fragment containing a simple view.
 */

@EFragment(R.layout.list_hero_fragment)
public class ListHeroesFragments extends BaseFragment implements ListHeroesContract.View {

    @ViewById(R.id.recView)
    RecyclerView recView;
    @ViewById(R.id.activity_main)
    LinearLayout activityMain;
    @ViewById(R.id.appbar)
    Toolbar appbar;
    @ViewById(R.id.imageView)
    ImageView imageView;
    private ListHeroesPresenter heroListPresenter;

    @AfterViews
    protected void listHeroesFragmentsAfterViews() {

        this.heroListPresenter = new ListHeroesPresenter(this, getActivity());
        this.heroListPresenter.start();
        appbar.setTitle(R.string.app_name);

    }

    @Override
    public void setListAdapter(HeroAdapter adapter) {
        recView.setAdapter(adapter);
    }

    @Override
    public void setLayoutManager() {
        recView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public RecyclerView getListView() {
        return recView;
    }

    @Override
    public void showImageFondo(boolean mostrar) {
        if (mostrar){
            imageView.setVisibility(View.VISIBLE);
            recView.setVisibility(View.GONE);
        }else{
            imageView.setVisibility(View.GONE);
            recView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void goToDetailContact(Superhero sh) {
        HeroActivity act = (HeroActivity) getActivity();
        act.changeFragment(sh, Constants.TAG_DETAILHEROSFR);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        heroListPresenter.getInteractor().cancelCall();
    }
}
