package com.di.entity.infoentity;

/**
 * Created by beerman on 25.02.2017.
 */
public enum Position {
    KLERK, MANAGER, BIGBOSS, TECHLEAD;

    public boolean canTravel(Position position){
        if(position.equals(KLERK) || position.equals(TECHLEAD))
            return false;
        return true;
    }
}
