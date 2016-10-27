package com.example.ujiantengahsemester;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kyky on 25/10/2016.
 */

public class pesanActivity extends AppCompatActivity {

//    private LinearLayout container;
//    private ArrayList<? extends RincianData> checkedList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesan_layout);



    }

//        checkedList = new ArrayList<RincianData>(); // initializing list
//        getDataFromIntent(); // receive data from intent (put by MainActivity)
//        generateDataToContainerLayout();
//    private void getDataFromIntent() {
//        checkedList = getIntent().getParcelableArrayListExtra("Checked List");
//        Log.i("ListActivity", "size" + checkedList.size());
//    }
//
//    @SuppressLint("InflateParams")
//    private void generateDataToContainerLayout() {
//
//        int i = 0;
//        if (checkedList.size() == i) { //do nothing
//        }
//        while (checkedList.size() > i) {
//            final RincianData friend = checkedList.get(i);
//            LayoutInflater inflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            View view = inflater.inflate(R.layout.detail, null,
//                    false);
//
//            TextView friendName = (TextView) view.findViewById(R.id.textViewHarga);
//            CheckBox checked = (CheckBox)view.findViewById(R.id.cek);
//            checked.setVisibility(View.GONE);
//            if (friend.isSelected()) {
//                friendName.setText(friend.perolehHarga());
//                if (friend.isGender()) {
//                    genderImage.setImageResource(R.drawable.male);
//                } else {
//                    genderImage.setImageResource(R.drawable.female);
//                }
//
//                // add view after all
//                container.addView(view);
//            }
//
//            i++; // rise i
//        }
}
