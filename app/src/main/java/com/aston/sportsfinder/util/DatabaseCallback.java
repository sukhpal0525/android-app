package com.aston.sportsfinder.util;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.aston.sportsfinder.dao.GameDao;
import com.aston.sportsfinder.dao.NotificationDao;
import com.aston.sportsfinder.dao.UserDao;
import com.aston.sportsfinder.model.Game;
import com.aston.sportsfinder.model.Notification;
import com.aston.sportsfinder.model.User;

import java.util.concurrent.ExecutorService;

public class DatabaseCallback extends RoomDatabase.Callback {

    private ExecutorService asyncTaskExecutor;

    public DatabaseCallback(ExecutorService executorService) {
        this.asyncTaskExecutor = executorService;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
    }

    public void insertTestData(GameDao gameDao, UserDao userDao, NotificationDao notificationDao) {
        asyncTaskExecutor.execute(() -> {
            if (userDao.countUsers() == 0) {
                userDao.insertUser(new User(1, "FName", "LName"));
            }
            if (gameDao.countGames() == 0) {
                gameDao.insertGame(new Game("Football", "Arsenal", "Newcastle", 1, 0, false, false, "123 Broadway St", "Manhattan", "NY", "USA", 40.7831, -73.9712, "2023-10-20", "14:00"));
                gameDao.insertGame(new Game("Football", "England", "Newcastle", 2, 1, false, true, "Battery Park", "Manhattan", "NY", "USA", 40.7033, -74.0170, "2023-11-10", "12:00"));
                gameDao.insertGame(new Game("Football", "Liverpool", "Barcelona", 3, 5, false, false, "334 Furman St", "Brooklyn", "NY", "USA", 40.7006, -73.9946, "2023-10-21", "16:00"));

                gameDao.insertGame(new Game("Baseball", "England", "France", 3, 1, false, false, "Silver Lake Park", "Staten Island", "NY", "USA", 40.6259, -74.0917, "2023-10-24", "13:00"));
                gameDao.insertGame(new Game("Baseball", "Germany", "France", 3, 2, false, false, "McCarren Park", "Brooklyn", "NY", "USA", 40.7203, -73.9516, "2023-10-26", "14:30"));
                gameDao.insertGame(new Game("Baseball", "Spain", "Italy", 4, 2, false, false, "95 Prospect Park W", "Brooklyn", "NY", "USA", 40.6619, -73.9797, "2023-10-27", "10:00"));

                gameDao.insertGame(new Game("Rugby", "USA", "France", 1, 4, false, false, "1410 Richmond Terrace", "Staten Island", "NY", "USA", 40.6404, -74.1357, "2023-10-24", "13:00"));
                gameDao.insertGame(new Game("Rugby", "PSG", "Valencia", 1, 3, false, false, "Flushing Meadows Park", "Queens", "NY", "USA", 40.7405, -73.8407, "2023-11-07", "18:30"));
                gameDao.insertGame(new Game("Rugby", "England", "USA", 1, 1, false, false, "1 E 161 St", "The Bronx", "NY", "USA", 40.8296, -73.9262, "2023-10-23", "15:30"));

                gameDao.insertGame(new Game("Tennis", "Russia", "Italy", 1, 1, false, false, "McCarren Park", "Brooklyn", "NY", "USA", 40.7210, -73.9520, "2023-10-27", "10:00"));

                gameDao.insertGame(new Game("Hockey", "Russia", "Italy", 1, 0, false, false, "Sunset Park", "Brooklyn", "NY", "USA", 40.6455, -74.0124, "2023-10-27", "10:00"));

                gameDao.insertGame(new Game("Cricket", "Russia", "Italy", 1, 3, false, false, "Flushing Meadows Corona Park", "Queens", "NY", "USA", 40.7410, -73.8410, "2023-10-27", "10:00"));
            }
        });
    }
}

//        gameDao.insertGame(new Game("Football", "Arsenal", "Liverpool", 2, 3, false, false, "Prospect Park", "Brooklyn", "NY", "USA", 40.6602, -73.9690, "2023-11-05", "17:00"));
//        gameDao.insertGame(new Game("Football", "Juventus", "Marseille", 2, 3, false, false, "Clove Lakes Park", "Staten Island", "NY", "USA", 40.6150, -74.1058, "2023-11-08", "16:00"));
//        gameDao.insertGame(new Game("Football", "AC Milan", "USA", 2, 3, false, false, "Van Cortlandt Park", "The Bronx", "NY", "USA", 40.8985, -73.8867, "2023-11-09", "14:00"));


// gameType, team1, team2, score1, score2, isJoined, isStarted, street, city, state, country, latitude, longitude, date, time

//      gameDao.insertGame(new Game(4, "Football", "Team A", "Team B", 2, 3, false, true, "1 E 161 St", "The Bronx", "NY", "USA", 40.8296, -73.9262, "2023-10-23", "15:30"));
//      gameDao.insertGame(new Game(5, "Football", "Team A", "Team B", 2, 3, false, true, "1410 Richmond Terrace", "Staten Island", "NY", "USA", 40.6404, -74.1357, "2023-10-24", "13:00"));
//      gameDao.insertGame(new Game(6, "Football", "Team A", "Team B", 2, 3, false, true, "776 Lorimer St", "Brooklyn", "NY", "USA", 40.7215, -73.9523, "2023-10-26", "14:30"));
//      gameDao.insertGame(new Game(7, "Football", "Team A", "Team B", 2, 3, false, true, "95 Prospect Park W", "Brooklyn", "NY", "USA", 40.6619, -73.9797, "2023-10-27", "10:00"));
//      gameDao.insertGame(new Game(8, "Football", "Team A", "Team B", 2, 3, false, true, "1904 Surf Ave", "Brooklyn", "NY", "USA", 40.5753, -73.9797, "2023-10-28", "18:00"));
//      gameDao.insertGame(new Game(9, "Football", "Team A", "Team B", 2, 3, false, true, "19 19th St", "Queens", "NY", "USA", 40.7798, -73.9223, "2023-10-29", "15:45"));
//      gameDao.insertGame(new Game(10, "Football", "Team A", "Team B", 2, 3, false, true, "Highland Park", "Brooklyn", "NY", "USA", 40.6894, -73.8807, "2023-10-30", "16:00"));

//      db.execSQL("INSERT INTO Game (gameType, team1, team2, isJoined, street, city, state, country, latitude, longitude, date, time) VALUES ('Football', 'Team A', 'Team B', 0, '456 Fulton St', 'Brooklyn', 'NY', 'USA', 40.6782, -73.9442, '2023-10-21', '16:00')");