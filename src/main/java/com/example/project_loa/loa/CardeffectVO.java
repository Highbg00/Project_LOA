package com.example.project_loa.loa;

import lombok.Data;

import java.util.List;

@Data
public class CardeffectVO {
    private int Index;
    private int[] CardSlots;
    private List<ItemVO> Items;
}
