package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.scene.media.AudioClip;

public class FightSceneAudio {
   private AudioClip faintMusic = new AudioClip("https://vgmsite.com/soundtracks/street-fighter-ii-the-world-warrior-arcade/uvpuolxyky/07%20Stage%20End.mp3");
//            faintMusic.setVolume(0.05);
//            faintMusic.play();

//      bossBattleMusic.setVolume(0.03);
    //        bossBattleMusic.play();
    private AudioClip bossBattleMusic = new AudioClip("https://vgmsite.com/soundtracks/duck-tales/ksfvgilqyf/08%20Boss.mp3");

    public AudioClip getFaintMusic() {
        return faintMusic;
    }

    public AudioClip getBossBattleMusic() {
        return bossBattleMusic;
    }
}
