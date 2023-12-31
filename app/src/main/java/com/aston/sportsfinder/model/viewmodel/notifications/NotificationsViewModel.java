package com.aston.sportsfinder.model.viewmodel.notifications;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.aston.sportsfinder.dao.NotificationDao;
import com.aston.sportsfinder.dao.UserDao;
import com.aston.sportsfinder.model.Game;
import com.aston.sportsfinder.model.Notification;
import com.aston.sportsfinder.util.DatabaseClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class NotificationsViewModel extends AndroidViewModel {

    private final MediatorLiveData<List<Notification>> notificationsLiveData = new MediatorLiveData<>();
    private final MutableLiveData<Integer> unreadNotificationsCount = new MutableLiveData<>();
    private final MutableLiveData<Integer> selectedGameId = new MutableLiveData<>();
    private final NotificationDao notificationDao;
    private final UserDao userDao;
    private final ExecutorService asyncTaskExecutor;

    public NotificationsViewModel(@NonNull Application application) {
        super(application);
        notificationDao = DatabaseClient.getInstance(application).getAppDatabase().notificationDao();
        userDao = DatabaseClient.getInstance(application).getAppDatabase().userDao();
        asyncTaskExecutor = DatabaseClient.getInstance(application).executorService;

        loadNotifications();
    }

    public void insertNotifications(Notification newNotification) {
        asyncTaskExecutor.execute(() -> {
            notificationDao.insertNotification(newNotification);
            Integer userId = userDao.getCurrentUserId();
            if (userId != null) {
                updateUnreadNotificationsCount(userId);
            }
        });
    }

    public void loadNotifications() {
        asyncTaskExecutor.execute(() -> {
            Integer userId = userDao.getCurrentUserId();
            if (userId != null) {
                List<Notification> notifications = notificationDao.getNotifications(userId);
                notificationsLiveData.postValue(notifications);
                updateUnreadNotificationsCount(userId);
            } else {
                notificationsLiveData.postValue(new ArrayList<>());
            }
        });
    }

    public void markNotificationsAsRead() {
        asyncTaskExecutor.execute(() -> {
            Integer userId = userDao.getCurrentUserId();
            if (userId != null) {
                notificationDao.markNotificationsAsRead(userId);
                int notificationCount = notificationDao.getUnreadNotificationCount(userId);
                unreadNotificationsCount.postValue(notificationCount);
            }
        });
    }

    public void updateUnreadNotificationsCount(int userId) {
        int notificationCount = notificationDao.getUnreadNotificationCount(userId);
        unreadNotificationsCount.postValue(notificationCount);
    }

    public LiveData<List<Notification>> getNotifications() {
        return notificationsLiveData;
    }

    public LiveData<Integer> getUnreadNotificationsCount() {
        return unreadNotificationsCount;
    }

    public void selectGameId(int gameId) { selectedGameId.setValue(gameId); }

    public LiveData<Integer> getSelectedGameId() { return selectedGameId; }
}