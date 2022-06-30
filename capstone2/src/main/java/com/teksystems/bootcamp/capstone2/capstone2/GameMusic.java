package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameMusic {
    private final MediaPlayer faintMusic = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/street-fighter-ii-the-world-warrior-arcade/uvpuolxyky/07%20Stage%20End.mp3"));
    private final MediaPlayer bossBattleMusic = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/duck-tales/ksfvgilqyf/08%20Boss.mp3"));
    private final MediaPlayer fightSound = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/mike-tysons-punch-out-original-game-rip/nqocfpxfga/28%20%28se%29%20Punching%20Opponent.mp3"));
    private final MediaPlayer welcomeSceneMusic = new MediaPlayer(new Media("https://soundimage.org/wp-content/uploads/2014/09/Our-Mountain_v003.mp3"));
    private final MediaPlayer selectionSound = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/nintendo-switch-sound-effects/roewkmcy/Bing.mp3"));
    private final MediaPlayer forestJourney = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-diamond-and-pearl-super-music-collection/fauztnlz/2-71%20Ending.mp3"));
    private final MediaPlayer cityScene = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-ruby-sapphire-music-super-complete/aiamawtl/2-44%20The%20Four%20Heavenly%20Kings%20Appears.mp3"));
    private final MediaPlayer gameOver = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/super-mario-world-original-soundtrack/hkqfpnii/25%20-%20Game%20Over.mp3"));
    private final MediaPlayer alarmClock = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-colosseum/padskxhagu/16%20-%20Level%20Up.mp3"));
    private final MediaPlayer ateMushroom = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/animal-crossing-new-horizons-2020-switch-gamerip/divrihnfan/3-57%20Fainted....mp3"));
    private final MediaPlayer cityBossScene = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/super-mario-world-original-soundtrack/qtnubcxm/8%20-%20Map%206%20%28Koopa%20Castle%29.mp3"));
    private final MediaPlayer missedBus = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/among-us/wpxiltjrot/Impostor%20Kill.mp3"));
    private final MediaPlayer cityScene2 = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-leafgreen-2004-gba/ocerplbsmz/34%20Mt.%20Moon.mp3"));
    private final MediaPlayer swimSound = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-leafgreen-2004-gba/bkvmwygfsx/51%20Forget%20Skill.mp3"));
    private final MediaPlayer jumpSound = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-leafgreen-2004-gba/eyyycncdpl/62%20Bad%20Luck.mp3"));

    private final MediaPlayer wonFight = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-firered-leafgreen-enhanced-soundtrack/jbbwdqfzcf/40%20Winner%21.mp3"));
    private final MediaPlayer lostFight = new MediaPlayer(new Media("https://vgmsite.com/soundtracks/pokemon-firered-leafgreen-enhanced-soundtrack/wpnundlehp/41%20Loser....mp3"));

    public MediaPlayer getLostFight() {
        return lostFight;
    }

    public MediaPlayer getWonFight() {
        return wonFight;
    }

    public MediaPlayer getJumpSound() {
        return jumpSound;
    }

    public MediaPlayer getSwimSound() {
        return swimSound;
    }

    public MediaPlayer getCityScene2() {
        return cityScene2;
    }

    public MediaPlayer getMissedBus() {
        return missedBus;
    }

    public MediaPlayer getCityBossScene() {
        return cityBossScene;
    }

    public MediaPlayer getAteMushroom() {
        return ateMushroom;
    }

    public MediaPlayer getAlarmClock() {
        return alarmClock;
    }

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

    public MediaPlayer getCityScene() {
        return cityScene;
    }
}
