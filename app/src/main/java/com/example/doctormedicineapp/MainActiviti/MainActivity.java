package com.example.doctormedicineapp.MainActiviti;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctormedicineapp.AdapterRecyclerView.MainMenuItemAdapter;
import com.example.doctormedicineapp.R;
import com.example.doctormedicineapp.model.ItemMainMenu_Model;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvItems;
    List<ItemMainMenu_Model> itemMainMenus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        rvItems = (RecyclerView) findViewById(R.id.rv_items);
        itemMainMenus= new ArrayList<>();
        itemMainMenus.add(new ItemMainMenu_Model("Đặt bác sĩ",R.drawable.doctor_mainmenu,1));
        itemMainMenus.add(new ItemMainMenu_Model("Đặt bác sĩ",R.drawable.drugs,2));
        itemMainMenus.add(new ItemMainMenu_Model("Đặt bác sĩ",R.drawable.sos,3));
        itemMainMenus.add(new ItemMainMenu_Model("Đặt bác sĩ",R.drawable.blood_bank,4));
        itemMainMenus.add(new ItemMainMenu_Model("Đặt bác sĩ",R.drawable.question,5));
        itemMainMenus.add(new ItemMainMenu_Model("Đặt bác sĩ",R.drawable.doctor_mainmenu,6));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        rvItems.setLayoutManager(mLayoutManager);
        rvItems.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(15), true));
        rvItems.setItemAnimator(new DefaultItemAnimator());
        rvItems.setHasFixedSize(true);
        rvItems.setAdapter(new MainMenuItemAdapter(this, itemMainMenus));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }

    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}


