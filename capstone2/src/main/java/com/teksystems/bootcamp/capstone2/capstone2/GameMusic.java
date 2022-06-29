package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameMusic {
    private final MediaPlayer faintMusic = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/street-fighter-ii-the-world-warrior-arcade/uvpuolxyky/07%20Stage%20End.mp3"));
    private final MediaPlayer bossBattleMusic = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/duck-tales/ksfvgilqyf/08%20Boss.mp3"));
    private final MediaPlayer fightSound = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/mike-tysons-punch-out-original-game-rip/nqocfpxfga/28%20%28se%29%20Punching%20Opponent.mp3"));
    private final MediaPlayer welcomeSceneMusic = new MediaPlayer(new Media("https://soundimage.org/wp-content/uploads/2014/09/Our-Mountain_v003.mp3"));
    private final MediaPlayer selectionSound = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/nintendo-switch-sound-effects/cusagemg/Controller.mp3"));
    private final MediaPlayer forestJourney = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-diamond-and-pearl-super-music-collection/fauztnlz/2-71%20Ending.mp3"));

    private final MediaPlayer gameOver = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/super-mario-bros/sjjrtywzlc/09%20Game%20Over.mp3"));
    public MediaPlayer getFaintMusic() {
        return faintMusic;
    }
    public MediaPlayer getBossBattleMusic() {
        return bossBattleMusic;
    }

    public MediaPlayer getFightSound() {
        return fightSound;
    }

    public MediaPlayer getWelcomeSceneMusic() {
        return welcomeSceneMusic;
    }

    public MediaPlayer getSelectionSound() {
        return selectionSound;
    }

    public MediaPlayer getForestJourney() {
        return forestJourney;
    }

    public MediaPlayer getGameOver() {
        return gameOver;
    }
}
