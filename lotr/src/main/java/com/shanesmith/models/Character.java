package com.shanesmith.models;

public class Character {

    private int characterId;
    private String theOneCharacterId;
    private String characterName;
    private String height;
    private String race;
    private String wikiURL;

    public Character(int characterId, String theOneCharacterId, String characterName, String height, String race, String wikiURL) {
        this.characterId = characterId;
        this.theOneCharacterId = theOneCharacterId;
        this.characterName = characterName;
        this.height = height;
        this.race = race;
        this.wikiURL = wikiURL;
    }

    public Character() {}
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getTheOneCharacterId() {
        return theOneCharacterId;
    }

    public void setTheOneCharacterId(String theOneCharacterId) {
        this.theOneCharacterId = theOneCharacterId;
    }

    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }
}
