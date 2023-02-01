package com.example.project_loa.loa;

import lombok.Data;

@Data
public class CardVO {
    private int Slot, AwakeCount, AwakeTotal;
    private String Name, Icon, Grade, Tooltip;
}
