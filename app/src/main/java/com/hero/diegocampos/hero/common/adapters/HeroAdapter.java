package com.hero.diegocampos.hero.common.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hero.diegocampos.hero.R;

import com.hero.diegocampos.hero.common.rest.heroes.Superhero;
import com.hero.diegocampos.hero.listHeroes.presenter.ListHeroesPresenter;

import java.util.ArrayList;

/**
 * Created by neon2004 on 28/01/2017.
 */


public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder>  {


    RelativeLayout activityMain;
    public ListHeroesPresenter callback;
    private ArrayList<Superhero> datos;
    private static Context ctx;
    private HeroViewHolder tvh;
    private View.OnClickListener listener;
    
     public class HeroViewHolder extends RecyclerView.ViewHolder {

         ImageView imgHeroList;
         TextView tvNamelist;
         CardView card;


        public Superhero getHero() {
            return sh;
        }

        private  Superhero sh;

        public HeroViewHolder(View itemView) {
            super(itemView);

            imgHeroList = (ImageView)itemView.findViewById(R.id.imgHeroList);
            tvNamelist = (TextView)itemView.findViewById(R.id.tvNamelist);
            card = (CardView)itemView.findViewById(R.id.card);


        }

        public void bindHero(Superhero sh) {
            this.sh = sh;
            tvNamelist.setText(sh.getName());
            Glide.with(ctx).load(sh.getPhoto())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .centerCrop()
                    .animate(android.R.anim.fade_in)
                    .into(imgHeroList);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.goDetail(datos.get(getAdapterPosition()));
                }
            });
        }


    }

    public HeroAdapter(ArrayList<Superhero> datos, Context context) {
        this.datos = datos;
        this.ctx = context;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        tvh = new HeroViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(HeroViewHolder viewHolder, int pos) {
        Superhero item = datos.get(pos);
        viewHolder.bindHero(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

}
