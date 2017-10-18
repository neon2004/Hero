package com.hero.diegocampos.hero.heroDetail.contract;


/**
 * Created by neon2004 on 30/04/2017.
 */

public class DetailHeroContract {
    public interface Presenter{



    }

    public interface View {
        void  setImage(String url);
        void setTitulo(String titulo);
        void setRealName(String realName);
        void setHeight(String height);
        void setPower(String power);
        void setAbility(String ability);
        void setGroups(String groups);

    }
}
