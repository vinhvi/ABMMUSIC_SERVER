package com.server.abm.serviceImpl;

import com.server.abm.entity.HistoryListen;
import com.server.abm.entity.User;
import com.server.abm.repository.HistoryListenRepository;
import com.server.abm.service.HistoryListenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HistoryListenServiceImpl implements HistoryListenService {

    private HistoryListenRepository historyListenRepository;

    @Override
    public HistoryListen addHistory(HistoryListen historyListen) {
        return historyListenRepository.save(historyListen);
    }

    @Override
    public HistoryListen getByUser(User user) {
        return historyListenRepository.findHistoryListenByUser(user);
    }

    @Override
    public HistoryListen getById(int id) {
        return historyListenRepository.findHistoryListenById(id);
    }

}
