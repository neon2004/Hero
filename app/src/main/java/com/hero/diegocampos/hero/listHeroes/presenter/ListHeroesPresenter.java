package com.hero.diegocampos.hero.listHeroes.presenter;

import android.app.Activity;

import com.hero.diegocampos.hero.common.adapters.HeroAdapter;
import com.hero.diegocampos.hero.common.rest.HeroInteractor;
import com.hero.diegocampos.hero.common.rest.heroes.Heroes;
import com.hero.diegocampos.hero.common.rest.heroes.Superhero;
import com.hero.diegocampos.hero.listHeroes.contract.ListHeroesContract;


public class ListHeroesPresenter implements ListHeroesContract.Presenter {




    private HeroInteractor interactor;
    private ListHeroesContract.View listHeroesFragments;
    private Activity act;

    public ListHeroesPresenter(ListHeroesContract.View listHeroesFragments, Activity activity) {
        this.listHeroesFragments = listHeroesFragments;
        this.interactor = new HeroInteractor(activity,this);
        this.act = activity;
    }
//    md5(ts+privateKey+publicKey)
    public void start(){
        listHeroesFragments.showImageFondo(true);
        getDatos();
    }

    public void getDatos(){
        interactor.getListHeroes();
    }



    public void onItemClick(Superhero sh){
        listHeroesFragments.goToDetailContact(sh);
    }

    @Override
    public void createAdapter(Heroes lisresult) {
        listHeroesFragments.showImageFondo(false);
        HeroAdapter adapter = new HeroAdapter(lisresult.getSuperheroes(),act.getApplicationContext());
        adapter.callback = this;
        listHeroesFragments.setListAdapter(adapter);
        listHeroesFragments.setLayoutManager();

    }

    @Override
    public void goDetail(Superhero sh) {
        listHeroesFragments.goToDetailContact(sh);
    }

    public HeroInteractor getInteractor() {
        return interactor;
    }


}
