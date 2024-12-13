package com.miage.oil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {

    @Autowired
    private Dice dice;

    @GetMapping("/rollDice")
    public int rollDice() {
        return dice.roll();
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollDices(@PathVariable int count) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(dice.roll());
        }
        return results;
    }
}