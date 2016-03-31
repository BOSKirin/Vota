package com.example.q.vota.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.q.vota.R;
import com.example.q.vota.fragment.DataFragment;
import com.example.q.vota.fragment.Fragment1;
import com.example.q.vota.fragment.Fragment2;

import java.util.ArrayList;
import java.util.Locale;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;


public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private VerticalViewPager mVerticalViewPager;
    private TextView mTitleTextView;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeContent();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String PACKAGE_NAME = getApplicationContext().getPackageName();

        //change me
        //noinspection SimplifiableIfStatement
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if(id == R.id.action_uninstall){
            Uri packageURI = Uri.parse("package:"+PACKAGE_NAME);
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
        } else if(id == R.id.action_uninstall_all_users){

            Uri packageURI = Uri.parse("package:"+PACKAGE_NAME);
            final Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageURI);
            uninstallIntent.putExtra("android.intent.extra.UNINSTALL_ALL_USERS", true);
            startActivity(uninstallIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void testingGitPush() {
        
    }

    private void initializeContent() {
        Toolbar toolbar_v7 = (Toolbar) findViewById(R.id.toolbar_v7);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final RelativeLayout contentLayout = (RelativeLayout) findViewById(R.id.content_layout);
        toolbar_v7.setTitle("");
        mTitleTextView = (TextView) findViewById(R.id.toolbar_title);
        mTitleTextView.setText(R.string.fragment_title_main_screen);
        setSupportActionBar(toolbar_v7);

        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0){
            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                contentLayout.setTranslationX(slideOffset * drawerView.getWidth());
                mDrawerLayout.bringChildToFront(drawerView);
                mDrawerLayout.requestLayout();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        final ListView navigationList = (ListView)findViewById(R.id.navigation_list_view);
        NavigationListAdapter navigationListAdapter = new NavigationListAdapter(this, R.layout.navigation_list_item);
        navigationList.setAdapter(navigationListAdapter);
        navigationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                    break;
                    case 1: {
                        final Intent intent = new Intent(getApplicationContext(), GopActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case 2: {
                        final Intent intent = new Intent(getApplicationContext(), DncActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case 3: {
                        final Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
//                        intent.putExtra(Constants.KEY_USER, "user_info");
                        startActivity(intent);
                    }
                    break;
                    case 4: {
                        final Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case 5: {
                        final Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case 6: {
                        showAlertDialog(MainActivity.this,"Logout","Are you sure you want to log out!!!","YES",new Runnable() {
                            @Override
                            public void run() {
                                //Log out user and bring user back to login screen
//                                final Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
//                                startActivity(intent);
                            }
                        }, "NO", new Runnable() {
                            @Override
                            public void run() {

                            }
                        }, null, null);
                    }
                    break;
                    default: {

                    }
                }
            }
        });

        mVerticalViewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);
        mVerticalViewPager.setAdapter(new VerticalPagerAdapter(getSupportFragmentManager()));
        mVerticalViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                final VerticalPagerAdapter verticalPagerAdapter = (VerticalPagerAdapter)mVerticalViewPager.getAdapter();
                mTitleTextView.setText(verticalPagerAdapter.getPageTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////


        final VerticalPagerAdapter verticalPagerAdapter = (VerticalPagerAdapter)mVerticalViewPager.getAdapter();
        final DataFragment fragment_1 = Fragment1.newInstance();
        verticalPagerAdapter.addFragment(0, fragment_1);
        final DataFragment fragment_2 = Fragment2.newInstance();
        verticalPagerAdapter.addFragment(1, fragment_2);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            final TextView accountHolderTextView = (TextView) toolbar.findViewById(R.id.account_holder_field);
            accountHolderTextView.setText("Welcome to Join US");
//            mAccountBalanceTextView = (TextView) toolbar.findViewById(R.id.account_balance_field);
//            mAccountBalanceProgressBar = toolbar.findViewById(R.id.account_balance_progressBar);
            setSupportActionBar(toolbar);
        }
    }

    class NavigationListAdapter extends BaseAdapter {
        private final Context c;
        private final int layout;
        private final LayoutInflater mLayoutInflater;

        public NavigationListAdapter(final Context context, final int l) {
            c = context;
            layout = l;
            mLayoutInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount() {
            return 7;
        }

        public Object getItem(final int position) {
            return position;
        }

        public long getItemId(final int position) {
            return position;
        }

        public View getView(final int position, final View convertView, final ViewGroup parent) {
            View _convertView = convertView;
            if(_convertView == null) {
                _convertView = mLayoutInflater.inflate(layout, parent, false);
            }

            switch (position){
                case 0: {
                    final ImageView menuImage = (ImageView) _convertView.findViewById(R.id.navigation_list_item_image);
                    menuImage.setImageResource(R.drawable.arrow);

                    final TextView memuText = (TextView) _convertView.findViewById(R.id.navigation_list_item_menu);
                    memuText.setText("Home");
                }
                break;
                case 1: {
                    final ImageView menuImage = (ImageView) _convertView.findViewById(R.id.navigation_list_item_image);
                    menuImage.setImageResource(R.drawable.arrow);

                    final TextView memuText = (TextView) _convertView.findViewById(R.id.navigation_list_item_menu);
                    memuText.setText("GOP");
                }
                break;
                case 2: {
                    final ImageView menuImage = (ImageView) _convertView.findViewById(R.id.navigation_list_item_image);
                    menuImage.setImageResource(R.drawable.arrow);

                    final TextView memuText = (TextView) _convertView.findViewById(R.id.navigation_list_item_menu);
                    memuText.setText("DNC");
                }
                break;
                case 3: {
                    final ImageView menuImage = (ImageView) _convertView.findViewById(R.id.navigation_list_item_image);
                    menuImage.setImageResource(R.drawable.arrow);

                    final TextView memuText = (TextView) _convertView.findViewById(R.id.navigation_list_item_menu);
                    memuText.setText("Your Profile");
                }
                break;
                case 4: {
                    final ImageView menuImage = (ImageView) _convertView.findViewById(R.id.navigation_list_item_image);
                    menuImage.setImageResource(R.drawable.arrow);

                    final TextView memuText = (TextView) _convertView.findViewById(R.id.navigation_list_item_menu);
                    memuText.setText("Help");
                }
                break;
                case 5: {
                    final ImageView menuImage = (ImageView) _convertView.findViewById(R.id.navigation_list_item_image);
                    menuImage.setImageResource(R.drawable.arrow);

                    final TextView memuText = (TextView) _convertView.findViewById(R.id.navigation_list_item_menu);
                    memuText.setText("Settings");
                }
                break;
                case 6: {
                    final ImageView menuImage = (ImageView) _convertView.findViewById(R.id.navigation_list_item_image);
                    menuImage.setImageResource(R.drawable.arrow);

                    final TextView memuText = (TextView) _convertView.findViewById(R.id.navigation_list_item_menu);
                    memuText.setText("Log out");
                }
                break;

            }

            return _convertView;
        }
    }


    public class VerticalPagerAdapter extends FragmentStatePagerAdapter {

        private ArrayList<DataFragment> mFragmentList = new ArrayList<DataFragment>(2);
        public VerticalPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public DataFragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

        public void addFragment(int position, DataFragment fragment){
            mFragmentList.add(position, fragment);
        }

        public ArrayList<DataFragment> getFragments(){
            return mFragmentList;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getText(R.string.fragment_title_1);
                case 1:
                    return getText(R.string.fragment_title_2);
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
            return;
        }

        super.onBackPressed();
    }

    public void showAlertDialog(Context context, String title, String message,
                                String positiveButtonName, final Runnable positiveClickListener,
                                String negativeButtonName, final Runnable negativeClickListener,
                                String neutralButtonName, final Runnable neutralClickListener){
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        if (title != null){
            dialogBuilder.setTitle(title);
        }
        dialogBuilder.setMessage(message);

        if (positiveButtonName != null){
            dialogBuilder.setPositiveButton(positiveButtonName, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                    if (positiveClickListener != null) { positiveClickListener.run(); }
                }
            });
        }

        if (negativeButtonName != null){
            dialogBuilder.setNegativeButton(negativeButtonName, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                    if (negativeClickListener != null) { negativeClickListener.run();}
                }
            });
        }

        if (neutralButtonName != null){
            dialogBuilder.setNeutralButton(negativeButtonName, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                    if (neutralClickListener != null)  {  neutralClickListener.run(); }
                }
            });
        }

        dialogBuilder.show();
    }
}
