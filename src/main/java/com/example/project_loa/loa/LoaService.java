package com.example.project_loa.loa;

import org.json.JSONArray;

import java.util.List;

public interface LoaService {
    ProfileVO Profile(String userid);
    JSONArray Equipment(String userid);

    CardsetVO Cards(String userid);
}
