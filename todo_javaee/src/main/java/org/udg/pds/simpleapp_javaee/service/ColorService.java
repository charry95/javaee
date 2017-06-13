package org.udg.pds.simpleapp_javaee.service;

/**
 * Created by Charry on 14/05/2017.
 */

import org.udg.pds.simpleapp_javaee.model.Color;
import org.udg.pds.simpleapp_javaee.model.Estacio;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.StyledEditorKit;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Stateless
@LocalBean
public class ColorService {

    @PersistenceContext
    protected EntityManager em;


    public Collection<Color> getColors() {
        try {
            return em.createQuery("SELECT color FROM Color color").getResultList();
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }

    public Color getColor(Long id) {
        try {
            Color c = em.find(Color.class, id);
            return c;
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }

    public Collection<Color> getColorsEstacio(Long estacioId){
        Estacio e = em.find(Estacio.class, estacioId);
        return e.getColors();
    }

    public Collection<Color> getColorsColor(String nom){
        Color cr1 = new Color(new Long(1), "r1");
        Color cr11 = new Color(new Long(2), "r11");
        Color cr8 = new Color(new Long(3), "r8");
        List<Color> relacions = new ArrayList<Color>();
        switch (nom){
            case "r1":
                relacions.add(cr11);
                break;
            case "r11":
                relacions.add(cr1);
                relacions.add(cr8);
                break;
            case "r8":
                relacions.add(cr11);
                break;

        }
        return relacions;
    }

    public ArrayList<ArrayList<Color>> obtenirMinimaPermutacioColors(Collection<Color> colorsc1, Collection<Color> colorsc2){
        ArrayList<ArrayList<Color>> permutacionsColors = new ArrayList<ArrayList<Color>>();
        for(Color c : colorsc1){
            ArrayList<Color> permutacioActual = new ArrayList<Color>();
            permutacioActual.add(c);
            obtenirPermutacioColors_i(permutacioActual,colorsc2,permutacionsColors);
        }
        //filtrar els minims
        Integer maxim = -1;
        ArrayList<Integer> eliminar = new ArrayList<>();
        ArrayList<Integer> salvats = new ArrayList<>();
        Integer contador = 0;
        for(ArrayList<Color> permutacio : permutacionsColors){
            if(permutacio.size()<maxim || maxim == -1){
                maxim = permutacio.size();
                eliminar.addAll(salvats);
                salvats.clear();
                salvats.add(contador);
            }
            else{
                eliminar.add(contador);
            }
            contador++;
        }
        Collections.sort(eliminar);
        Integer nEliminats = 0;
        for(Integer index : eliminar){
            permutacionsColors.remove((index-nEliminats));
            nEliminats++;
        }
        return permutacionsColors;

    }

    public void obtenirPermutacioColors_i(ArrayList<Color> actual, Collection<Color> colorsc2, ArrayList<ArrayList<Color>> permutacions){
        Color ultimActual = actual.get(actual.size() - 1);
        Boolean arribat = false;
        for(Color c : colorsc2){
            arribat = existeixColor(colorsc2, ultimActual);
            if(arribat)
                break;
        }
        if(arribat){
            ArrayList<Color> permutacio = new ArrayList<Color>();
            for(Color cPerm : actual){
                Color c = new Color(cPerm.getId(), cPerm.getNom());
                permutacio.add(c);
            }
            permutacions.add(permutacio);
        }
        else{
            Collection<Color> colorsUltim = this.getColorsColor(ultimActual.getNom());
            for(Color c : colorsUltim){
                if(!existeixColor(actual, c)){
                    actual.add(c);
                    obtenirPermutacioColors_i(actual, colorsc2, permutacions);
                    actual.remove(actual.size()-1);
                }
            }
        }
    }

    public Boolean existeixColor(Collection<Color> colors, Color c){
        for(Color act : colors){
            if(c.getId() .equals(act.getId()))
                return true;
        }
        return false;
    }


}



