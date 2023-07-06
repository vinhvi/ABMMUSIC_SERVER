package com.server.abm.repository;

import com.server.abm.entity.HistoryListen;
import com.server.abm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryListenRepository extends JpaRepository<HistoryListen,Integer> {

    HistoryListen findHistoryListenByUser(User user);

    HistoryListen findHistoryListenById(int id);
}
