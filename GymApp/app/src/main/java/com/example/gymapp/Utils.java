package com.example.gymapp;

import android.util.Log;

import java.util.ArrayList;

public class Utils {
    private static final String TAG = "Utility";

    private static ArrayList<GymTrainign> allTrainings;
    private static ArrayList<Plan> usersPlans;

    public Utils() {
    }

    public static void initializeAll(){
        Log.d(TAG, "initializeAll: called");

        if (null == allTrainings){
            allTrainings = new ArrayList<>();
        }

        if (null == usersPlans){
            usersPlans = new ArrayList<>();
        }

        GymTrainign squat = new GymTrainign();
        squat.setName("Squat");
        squat.setShortDesc("Short description for this ....");
        squat.setLongDesc("Esistono innumerevoli variazioni dei passaggi del Lorem Ipsum, ma la maggior parte hanno subito delle variazioni del tempo, a causa dell’inserimento di passaggi ironici, o di sequenze casuali di caratteri palesemente poco verosimili. Se si decide di utilizzare un passaggio del Lorem Ipsum, è bene essere certi che non contenga nulla di imbarazzante. In genere, i generatori di testo segnaposto disponibili su internet tendono a ripetere paragrafi predefiniti, rendendo questo il primo vero generatore automatico su intenet. Infatti utilizza un dizionario di oltre 200 vocaboli latini, combinati con un insieme di modelli di strutture di periodi, per generare passaggi di testo verosimili. Il testo così generato è sempre privo di ripetizioni, parole imbarazzanti o fuori luogo ecc.");
        squat.setImageUrl("https://3vnqw32fta3x1ysij926ljs3-wpengine.netdna-ssl.com/wp-content/uploads/2017/03/Squat.jpg");
        allTrainings.add(squat);

        GymTrainign pushUp = new GymTrainign();
        pushUp.setName("Push up");
        pushUp.setShortDesc("Short description for this ....");
        pushUp.setLongDesc("Esistono innumerevoli variazioni dei passaggi del Lorem Ipsum, ma la maggior parte hanno subito delle variazioni del tempo, a causa dell’inserimento di passaggi ironici, o di sequenze casuali di caratteri palesemente poco verosimili. Se si decide di utilizzare un passaggio del Lorem Ipsum, è bene essere certi che non contenga nulla di imbarazzante. In genere, i generatori di testo segnaposto disponibili su internet tendono a ripetere paragrafi predefiniti, rendendo questo il primo vero generatore automatico su intenet. Infatti utilizza un dizionario di oltre 200 vocaboli latini, combinati con un insieme di modelli di strutture di periodi, per generare passaggi di testo verosimili. Il testo così generato è sempre privo di ripetizioni, parole imbarazzanti o fuori luogo ecc.");
        pushUp.setImageUrl("https://3vnqw32fta3x1ysij926ljs3-wpengine.netdna-ssl.com/wp-content/uploads/2015/06/How-to-do-a-pushup.jpg");
        allTrainings.add(pushUp);

        GymTrainign chestFly = new GymTrainign();
        chestFly.setName("Chest Fly");
        chestFly.setShortDesc("Short description for this ....");
        chestFly.setLongDesc("Esistono innumerevoli variazioni dei passaggi del Lorem Ipsum, ma la maggior parte hanno subito delle variazioni del tempo, a causa dell’inserimento di passaggi ironici, o di sequenze casuali di caratteri palesemente poco verosimili. Se si decide di utilizzare un passaggio del Lorem Ipsum, è bene essere certi che non contenga nulla di imbarazzante. In genere, i generatori di testo segnaposto disponibili su internet tendono a ripetere paragrafi predefiniti, rendendo questo il primo vero generatore automatico su intenet. Infatti utilizza un dizionario di oltre 200 vocaboli latini, combinati con un insieme di modelli di strutture di periodi, per generare passaggi di testo verosimili. Il testo così generato è sempre privo di ripetizioni, parole imbarazzanti o fuori luogo ecc.");
        chestFly.setImageUrl("https://3vnqw32fta3x1ysij926ljs3-wpengine.netdna-ssl.com/wp-content/uploads/2016/03/Superband-Chest-Fly.jpg");
        allTrainings.add(chestFly);

        GymTrainign legPress = new GymTrainign();
        legPress.setName("Leg Press");
        legPress.setShortDesc("Short description for this ....");
        legPress.setLongDesc("Esistono innumerevoli variazioni dei passaggi del Lorem Ipsum, ma la maggior parte hanno subito delle variazioni del tempo, a causa dell’inserimento di passaggi ironici, o di sequenze casuali di caratteri palesemente poco verosimili. Se si decide di utilizzare un passaggio del Lorem Ipsum, è bene essere certi che non contenga nulla di imbarazzante. In genere, i generatori di testo segnaposto disponibili su internet tendono a ripetere paragrafi predefiniti, rendendo questo il primo vero generatore automatico su intenet. Infatti utilizza un dizionario di oltre 200 vocaboli latini, combinati con un insieme di modelli di strutture di periodi, per generare passaggi di testo verosimili. Il testo così generato è sempre privo di ripetizioni, parole imbarazzanti o fuori luogo ecc.");
        legPress.setImageUrl("https://3vnqw32fta3x1ysij926ljs3-wpengine.netdna-ssl.com/wp-content/uploads/2019/11/6-Moves-Stronger-Knees.jpg");
        allTrainings.add(legPress);
    }

    public static ArrayList<GymTrainign> getAllTrainings() {
        return allTrainings;
    }

    public static void setAllTrainings(ArrayList<GymTrainign> allTrainings) {
        Utils.allTrainings = allTrainings;
    }

    public static ArrayList<Plan> getUsersPlans() {
        return usersPlans;
    }

    public static void setUsersPlans(ArrayList<Plan> usersPlans) {
        Utils.usersPlans = usersPlans;
    }
    
    public static boolean addToUsersPlan (Plan plan){
        Log.d(TAG, "addToUsersPlan: started");

        return usersPlans.add(plan);
    }

    public static boolean removeUsesPlan (Plan plan){
        Log.d(TAG, "removeUsesPlan: started");

        return usersPlans.remove(plan);
    }
}
