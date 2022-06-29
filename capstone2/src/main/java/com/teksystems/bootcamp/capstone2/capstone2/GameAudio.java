package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.scene.media.AudioClip;

public class GameAudio {

   private AudioClip welcomeSceneMusic = new AudioClip("https://soundimage.org/wp-content/uploads/2014/09/Our-Mountain_v003.mp3");
   private AudioClip selectionSound = new AudioClip("https://vgmsite.com/soundtracks/nintendo-switch-sound-effects/cusagemg/Controller.mp3");


    public void playSceneMusic() {
       welcomeSceneMusic.play();
    }
    public void playSelectionSound(){
        selectionSound.play();
    }
}
