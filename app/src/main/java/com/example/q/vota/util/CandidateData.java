package com.example.q.vota.util;

import android.content.Context;
import android.database.SQLException;

import java.util.ArrayList;

/**
 * Created by Q on 3/22/16.
 */
public class CandidateData {

    public CandidateData(Context context) {

//        dbHelper = new ContactDBHelper(context);
    }

    public void open() throws SQLException {

//        db = dbHelper.getWritableDatabase();
    }

    public void close() {

//        dbHelper.close();
    }

    public boolean updateInfo(CandidateInfo c)
    {
        boolean didSucceed = false;
        try {

//            didSucceed = db.update("contact", updateValues, "_id=" + rID, null) > 0;
        }
        catch (Exception e) {
            //null exception
        }
        return didSucceed;
    }

    public ArrayList<String> getGopCandidates() {
        ArrayList<String> candidatesNames = new ArrayList<String>();
        try {

            //query should be added here
            String query = "";
        }
        catch (Exception e) {
            candidatesNames = new ArrayList<String>();
        }
        return candidatesNames;
    }

    public ArrayList<String> getDncCandidates() {
        ArrayList<String> candidatesNames = new ArrayList<String>();
        try {

            //query should be added here
            String query = "";
        }
        catch (Exception e) {
            candidatesNames = new ArrayList<String>();
        }
        return candidatesNames;
    }

    public ArrayList<CandidateInfo> getAllCandidates() {
        ArrayList<CandidateInfo> candidateInfos = new ArrayList<CandidateInfo>();
        try {

            //add query here
//            String query = "SELECT  * FROM TABLENAME";
        }
        catch (Exception e) {
            candidateInfos = new ArrayList<CandidateInfo>();
        }
        return candidateInfos;
    }

}