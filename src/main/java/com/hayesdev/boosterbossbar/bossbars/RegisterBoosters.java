package com.hayesdev.boosterbossbar.bossbars;

import me.swanis.boosters.BoostersAPI;
import me.swanis.boosters.booster.ActiveBooster;

import java.util.Collection;

public class RegisterBoosters {

    public static boolean[] updateBoosters() {
        Collection<ActiveBooster> boosters = BoostersAPI.getBoosterManager().getActiveBoosters();
        boolean[] newBoosterList = {false, false, false};
        for (ActiveBooster booster : boosters) {
            if (booster.getBooster().isEnabled()) {
                if (booster.getBooster().getName().equalsIgnoreCase("Experience")) {
                    newBoosterList[0] = true;
                }
                else if (booster.getBooster().getName().equalsIgnoreCase("Money")) {
                    newBoosterList[1] = true;
                }
                else if (booster.getBooster().getName().equalsIgnoreCase("MobCoins")) {
                    newBoosterList[2] = true;
                }
            }
        }
        return newBoosterList;
    }

}
