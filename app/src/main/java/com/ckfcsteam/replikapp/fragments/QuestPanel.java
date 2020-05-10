package com.ckfcsteam.replikapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ckfcsteam.replikapp.R;
import com.ckfcsteam.replikapp.models.CustomAdaptater;
import com.ckfcsteam.replikapp.models.DataModel;

import java.util.ArrayList;


public class QuestPanel extends Fragment {

    /*Déclaration des variables*/
    ArrayList<DataModel> dataModels;
    private static CustomAdaptater adapter;
    private ListView quest_list;
    private int maxLvl_unlocked, block_number ;

    /*Constructeur*/
    public QuestPanel(int maxLvl_unlocked, int block_number){
        this.maxLvl_unlocked = maxLvl_unlocked;
        this.block_number = block_number;
    }

    @Override
    /*Associe le fragment à la création de la View*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_levelselection, container, false);
    }

    @Override
    /*Construit le paneau de visualisation des quêtes à la création de l'activité*/
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*On récupère dans la vue, l'emplacement où afficher la présentation sous forme de liste*/
        quest_list = (ListView) getView().findViewById(R.id.menu_levelList);

        /*On crée une liste d'objet dataModels, objet permettant de décrire une quête ( on réuilise le même que pour les niveaux)*/
        dataModels = new ArrayList<DataModel>();

        /*On crée les descriptions des quêtes en fonction de s'ils elle sont finies ou pas*/
        String quest0 = maxLvl_unlocked < 4 ? "En cours : "+maxLvl_unlocked+" sur 4" : "Terminé : 4 sur 4";
        String quest1 = block_number < 50 ? "En cours : "+block_number+" sur 50" : "Terminé : 50 sur 50";
        String quest2 = block_number < 100 ? "En cours : "+block_number+" sur 100" : "Terminé : 100 sur 100";
        String quest3 = block_number < 150 ? "En cours : "+block_number+" sur 150" : "Terminé : 150 sur 150";
        String quest4 = (block_number < 1000 ) ? "En cours : "+block_number+" sur 1000" : "Terminé : 1000 sur 1000";
        /*Et on ajoute chaque quête dans la liste créée*/
        dataModels.add(new DataModel(R.drawable.quest_icon,"Débloquer les 4 niveaux",quest0));
        dataModels.add(new DataModel(R.drawable.quest_icon,"Détruire 50 blocks",quest1));
        dataModels.add(new DataModel(R.drawable.quest_icon,"Détruire 100 blocks",quest2));
        dataModels.add(new DataModel(R.drawable.quest_icon,"Détruire 150 blocks",quest3));
        dataModels.add(new DataModel(R.drawable.quest_icon,"Détruire 1000 blocks",quest4));

        /*On récupère notre Adaptateur Custom*/
        adapter = new CustomAdaptater(dataModels,getContext());
        /*On ajoute l'adaptateur à l'objet concerné*/
        quest_list.setAdapter(adapter);

    }
}
