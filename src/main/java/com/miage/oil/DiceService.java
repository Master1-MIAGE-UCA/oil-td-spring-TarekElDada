package com.miage.oil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {

    @Autowired
    private Dice dice;

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    public List<Integer> rollDices(int count) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(dice.roll());
        }

        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(count);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);

        return results;
    }
}