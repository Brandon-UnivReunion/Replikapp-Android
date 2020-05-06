package com.ckfcsteam.spaceinvaders.gamelib;

import android.graphics.Canvas;

import java.util.ArrayList;

public class ProjectilesInvaders extends ArrayList<ProjectileInvaders> {

    // Dimensions de l'écran
    private int screenWidth;
    private int screenHeight;

    public ProjectilesInvaders(int width, int height){
        super();
        screenWidth = width;
        screenHeight = height;
    }

    /**
     * resize redimensionne tout les projectiles ennemi
     * @param nWidth largeur
     * @param nHeight hauteur
     */
    public void resize(int nWidth, int nHeight){
        for(ProjectileInvaders p: this){
            p.resize(nWidth, nHeight);
        }
    }

    /**
     * move effectue un deplacement de tous les projectiles ennemi
     *
     * @param n distance à parcourir
     */
     public void move(int n){
         for(ProjectileInvaders p: this){
             p.move(n);
         }
     }

    /**
     * lose verifie si le joueur à perdue à cause d'un tir ennemi
     * @param s le vaisseau du joueur
     * @return vrai si le vaisseau est entré en collision avec un projectile ennemi
     */
    public boolean lose(Ship s){
        for(ProjectileInvaders p: this){
            if(s.entringEnCollisioningCarre(p))
                return (true);
        }
        return (false);
    }

    /**
     * annulation supprime deux projectiles de camp opposé qui entre en collisions
     * @param lShip projectiles du joueur
     */
    public void annulation(ArrayList<ProjectileShip> lShip){
        for(int i = 0; i<this.size(); i++){
            for(int j = 0; j<lShip.size(); j++){
                if(this.get(i).entringEnCollisioningCarre(lShip.get(j))){
                    this.remove(i);
                    lShip.remove(j);
                    break;
                }
            }
        }
    }

    /**
     * maj mets à jour tout les projectile
     *
     * Il supprime les projectiles qui sorte de l'écran
     */
    public void maj(){
        for(int i = 0; i<this.size(); i++){
            if(this.get(i).cordy > screenHeight){
                this.remove(i);
            }
        }
    }

    /**
     * displayAll affiche tout les projectiles ennemi
     *
     * @param canvas canvas qui va dessiner les projectiles
     */
    public void displayAll(Canvas canvas){
        for(ProjectileInvaders p: this){
            p.display(canvas);
        }
    }
}
