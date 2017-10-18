package com.hero.diegocampos.hero.heroDetail;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hero.diegocampos.hero.R;
import com.hero.diegocampos.hero.common.base.BaseFragment;
import com.hero.diegocampos.hero.common.rest.heroes.Superhero;
import com.hero.diegocampos.hero.heroDetail.contract.DetailHeroContract;
import com.hero.diegocampos.hero.heroDetail.prsenter.DetailHeroPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;


/**
 * A placeholder fragment containing a simple view.
 */
@EFragment(R.layout.detail_hero_fragment)
public class DetailHeroFragments extends BaseFragment implements DetailHeroContract.View {

    @ViewById(R.id.scroll)
    NestedScrollView scroll;
    @ViewById(R.id.imageDetail)
    ImageView imageDetail;
    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    @ViewById(R.id.collapser)
    CollapsingToolbarLayout collapser;
    @ViewById(R.id.app_bar)
    AppBarLayout appBar;
    @ViewById(R.id.coordinator)
    CoordinatorLayout coordinator;
    @ViewById(R.id.tvRealName)
    TextView tvRealName;
    @ViewById(R.id.tvHeight)
    TextView tvHeight;
    @ViewById(R.id.tvPower)
    TextView tvPower;
    @ViewById(R.id.tvAbility)
    TextView tvAbility;
    @ViewById(R.id.tvGroups)
    TextView tvGroups;

    @FragmentArg
    Superhero hero;

    private DetailHeroPresenter heroDetailPresenter;

    @AfterViews
    protected void detailHeroFragmentsAfterViews() {
        this.heroDetailPresenter = new DetailHeroPresenter(this, getActivity(), hero);
        this.heroDetailPresenter.start();
    }

    @Override
    public void setImage(String url) {
        Glide.with(this).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(imageDetail);
    }

    @Override
    public void setTitulo(String titulo) {
        collapser.setTitle(titulo);

    }

    @Override
    public void setRealName(String realName) {
        tvRealName.setText(realName);
    }

    @Override
    public void setHeight(String height) {
        tvHeight.setText(height);
    }

    @Override
    public void setPower(String power) {
        tvPower.setText(power);
    }

    @Override
    public void setAbility(String ability) {
        tvAbility.setText(ability);
    }

    @Override
    public void setGroups(String groups) {
        tvGroups.setText(groups);
    }

}
