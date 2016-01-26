package com.hai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hai.R;
import com.hai.activity.fragment.ContentFragment;
import com.hai.activity.fragment.MenuLeft;

/**
 * Created by 黄海 on 2016/1/21.
 */
public class ActionBarActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar);
        initToolbar();
        final ContentFragment f_content = (ContentFragment) getSupportFragmentManager().findFragmentById(R.id.f_content);
        final MenuLeft f_leftMenu = (MenuLeft) getSupportFragmentManager().findFragmentById(R.id.f_leftMenu);
        Fragment f_rightMenu = getSupportFragmentManager().findFragmentById(R.id.f_rightMenu);
        f_leftMenu.setOnMenuItemSelectedListener(new MenuLeft.OnMenuItemSelectedListener() {
            @Override
            public void menuItemSelected(String title) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                f_content.refresh(title);
            }
        });
    }

    void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("title");
        toolbar.setSubtitle("subtitle");
        toolbar.inflateMenu(R.menu.menu_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(ActionBarActivity.this, "action_settings", 0).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(ActionBarActivity.this, "action_share", 0).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu
                .findItem(R.id.action_share));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        mShareActionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }
}
