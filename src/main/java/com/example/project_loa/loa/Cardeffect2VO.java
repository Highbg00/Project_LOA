package com.example.project_loa.loa;

import lombok.Data;

import java.util.List;

@Data
public class Cardeffect2VO {
    private int index;
    private int[] cardSlots;
    private List<Item2VO> items;
}
