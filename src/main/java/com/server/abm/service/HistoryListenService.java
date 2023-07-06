package com.server.abm.service;

import com.server.abm.entity.HistoryListen;
import com.server.abm.entity.User;
import com.server.abm.repository.HistoryListenRepository;

public interface HistoryListenService {

    HistoryListen addHistory(HistoryListen historyListen);

    HistoryListen getByUser(User user);

    HistoryListen getById(int id);
}
