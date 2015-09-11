/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author healdb
 */
import  java.util.Random;
public class ShufflePlaylist extends PlayList{
    
    private boolean isRandom;
    private Random randNum = new Random();
    
    public ShufflePlaylist(){
        this.isRandom = false;
    }
    public void turnOnRandom(){
        this.isRandom = true;
    }
    public void turnOffRandom(){
        this.isRandom = false;
    }
    public boolean isRandom(){
        return this.isRandom;
    }
    public String getNext(){
        
        if(this.isRandom){
            int max = super.songs.length;
            int chosen = super.current;
            //Prevents the same song from being played twice in a row when on shuffle.
            while(chosen==super.current){
                chosen=randNum.nextInt(max);
            }
            super.current=chosen;
            return super.songs[chosen];
        }
        else{
            return super.getNext();
        }
    }
}
