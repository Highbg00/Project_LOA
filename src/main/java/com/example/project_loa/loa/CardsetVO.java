package com.example.project_loa.loa;

import lombok.Data;

import java.util.List;

@Data
public class CardsetVO {
    private List<CardVO> Cards;
    private List<CardeffectVO> Effects;
}
