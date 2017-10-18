package com.hero.diegocampos.hero.listHeroes.contract;


import android.support.v7.widget.RecyclerView;

import com.hero.diegocampos.hero.common.adapters.HeroAdapter;
import com.hero.diegocampos.hero.common.rest.heroes.Heroes;
import com.hero.diegocampos.hero.common.rest.heroes.Superhero;

import java.util.ArrayList;


/**
 * Created by neon2004 on 30/04/2017.
 */

public class ListHeroesContract {
    public interface Presenter{
        void createAdapter(Heroes lisresult);
        void goDetail(Superhero sh);


    }

    public interface View {

        void  setListAdapter(HeroAdapter adapter);
        void goToDetailContact(Superhero sh);
        void setLayoutManager();
        RecyclerView getListView();
        void showImageFondo(boolean mostrar);

    }
}
