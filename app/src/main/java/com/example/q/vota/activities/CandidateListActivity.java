package com.example.q.vota.activities;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.q.vota.R;
import com.example.q.vota.util.CandidateData;
import com.example.q.vota.util.CandidateInfo;

import java.util.ArrayList;

public class CandidateListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CandidateData db = new CandidateData(this);
        db.open();
        //three conditions: 1. GOP; 2. DNC; 3. ALL
//        final ArrayList<CandidateInfo> candidates = db.getAllCandidates();
        db.close();

//        if (candidates.size() > 0) {
//
//            CandidateAdapter candidateAdapter = new CandidateAdapter(this, candidates);
//            setListAdapter(candidateAdapter);
//            ListView listView = getListView();
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                @Override
//                public void onItemClick(AdapterView<?> parent, View itemClicked,
//                                        int position, long id) {
//                    CandidateInfo selectedContact = candidates.get(position);
//                }
//            });
//        }
//        else {

//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_candidate_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class CandidateAdapter extends ArrayAdapter<CandidateInfo> {

        private ArrayList<CandidateInfo> contactData;
        private Context ct;

        public CandidateAdapter(Context context, ArrayList<CandidateInfo> items) {
            super(context, R.layout.candidate_list_item, items);
            ct = context;
            this.contactData = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View mView = convertView;
            try {
                CandidateInfo contact = contactData.get(position);

                if (mView == null) {
                    LayoutInflater vi = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    mView = vi.inflate(R.layout.candidate_list_item, null);
                }

                TextView candidateName = (TextView) mView.findViewById(R.id.tv_candidate_name);
                ImageView candidatePhoto = (ImageView)mView.findViewById(R.id.img_photo);
                TextView votes = (TextView) mView.findViewById(R.id.tv_vote_number);
//
//                contactName.setText(contact.getContactName());
//                contactPhoto.setImageBitmap(contact.getBitmap());
//                contactNumber.setText(contact.getCellNumber());
            }
            catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
            return mView;
        }

    }
}
