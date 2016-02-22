package com.example.q.vota.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.q.vota.R;

/**
 * Created by Q on 2/16/16.
 */
public class Fragment1 extends DataFragment {

    private static final String TAG = Fragment1.class.getSimpleName();

    private OnFragmentInteractionListener mListener;


    public static Fragment1 newInstance() {
//    public static Fragment1 newInstance(Bundle extras) {
        Fragment1 fragment = new Fragment1();
//        Bundle args = new Bundle(extras);
//        fragment.setArguments(args);
        return fragment;
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_1, container, false);
        if (view != null) {
        }
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO:
    }

    class ListAdapter extends BaseAdapter {
        private final Context c;
        private final int layout;
        private boolean isDepositAccount = false;
        private final LayoutInflater mLayoutInflater;
        private int mCount = 2;
        private String mBalance;

        public ListAdapter(final Context context, final int l, boolean isDepositAccount) {
            c = context;
            layout = l;
            mLayoutInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.isDepositAccount = isDepositAccount;
        }

        public int getCount() {
            return mCount;
        }

        public Object getItem(final int position) {
            return position;
        }

        public long getItemId(final int position) {
            return position;
        }

        public void setBalance(String balance){
            this.mBalance = balance;
        }

        public View getView(final int position, final View convertView, final ViewGroup parent) {
            View _convertView = convertView;
            if(_convertView == null) {
                _convertView = mLayoutInflater.inflate(layout, parent, false);
            }

            return _convertView;
        }
    }

}
