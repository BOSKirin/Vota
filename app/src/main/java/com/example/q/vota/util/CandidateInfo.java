package com.example.q.vota.util;

import android.graphics.Bitmap;
import android.text.format.Time;

/**
 * Created by Q on 3/22/16.
 */
public class CandidateInfo {
    private int candidateID;
    private Bitmap candidatePhoto;
    private String candidateName;
    private String votes;
    private String candidateAge;
    private String candidateAddress;

    public CandidateInfo() {
        candidateID = -1;

    }

    public int getCandidateID() {
        return candidateID;
    }
    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Bitmap getBitmap(){
        return candidatePhoto;
    }
    public void setBitmap(Bitmap bmp){
        this.candidatePhoto = bmp;
    }

    public void setcandidateAge(String candidateAge) {
        this.candidateAge = candidateAge;
    }
    public String getcandidateAge() {
        return candidateAge;
    }

    public String getVotes() {
        return votes;
    }
    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getCandidateAddress() {
        return candidateAddress;
    }
    public void setcandidateAddress(String candidateAddress) {
        this.candidateAddress = candidateAddress;
    }
}