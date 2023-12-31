package com.aston.sportsfinder.model;

//import com.aston.sportsfinder.service.WeatherAPI;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Game")
public class Game implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private String gameType;
    private String team1;
    private String team2;
    private int score1;
    private int score2;
    private boolean isJoined;
    private boolean isStarted;

    private String street;
    private String city;
    private String state;
    private String country;
    private double latitude;
    private double longitude;

    private String date;
    private String time;

    private String organiserName;
    private String capacity;
    private int currentPlayerCount;
    private String skillLevel;
    private String equipmentNeeded;
    private String duration;
    private String ageGroup;
    private String registrationFee;
    private String additionalNotes;
    private boolean isCreatedByUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public boolean isJoined() {
        return isJoined;
    }

    public void setJoined(boolean joined) {
        isJoined = joined;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrganiserName() {
        return organiserName;
    }

    public void setOrganiserName(String organiserName) {
        this.organiserName = organiserName;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getCurrentPlayerCount() {
        return currentPlayerCount;
    }

    public void setCurrentPlayerCount(int currentPlayerCount) {
        this.currentPlayerCount = currentPlayerCount;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getEquipmentNeeded() {
        return equipmentNeeded;
    }

    public void setEquipmentNeeded(String equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(String registrationFee) {
        this.registrationFee = registrationFee;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public boolean isCreatedByUser() {
        return isCreatedByUser;
    }

    public void setCreatedByUser(boolean createdByUser) {
        isCreatedByUser = createdByUser;
    }

    public Game(String gameType, String team1, String team2, int score1, int score2, boolean isJoined, boolean isStarted, String street, String city, String state, String country, double latitude, double longitude, String date, String time, String organiserName, String capacity, int currentPlayerCount, String skillLevel, String equipmentNeeded, String duration, String registrationFee, String additionalNotes, boolean isCreatedByUser) {
        this.gameType = gameType;
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
        this.isJoined = isJoined;
        this.isStarted = isStarted;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.time = time;
        this.organiserName = organiserName;
        this.capacity = capacity;
        this.currentPlayerCount = currentPlayerCount;
        this.skillLevel = skillLevel;
        this.equipmentNeeded = equipmentNeeded;
        this.duration = duration;
        this.registrationFee = registrationFee;
        this.additionalNotes = additionalNotes;
        this.isCreatedByUser = isCreatedByUser;
    }
}
//  Foreign key (Game --> User)
//  private int userId;

//  private WeatherAPI weather;


//    public WeatherAPI getWeather() {
//        return weather;
//    }
//
//    public void setWeather(WeatherAPI weather) {
//        this.weather = weather;
//    }