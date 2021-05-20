package com.coc.fintoodemoapp.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.coc.fintoodemoapp.R;
import com.coc.fintoodemoapp.utils.DTU;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneFragment extends Fragment {

    private EditText edtDate;
    private EditText edtNumberOfUnits;
    private EditText edtPurchasePrice;
    private Spinner spnInvestmentFor;
    private SwitchCompat switchCompat;

    private Button btnAddMore;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        setupUI(rootView);
        setupEvents();
        return rootView;
    }

    private void setupUI(View rootView) {
        edtDate = rootView.findViewById(R.id.edt_date);
        btnAddMore = rootView.findViewById(R.id.btn_add_more);
        switchCompat = rootView.findViewById(R.id.switchCompact);
        edtNumberOfUnits = rootView.findViewById(R.id.edt_unit_no);
        edtPurchasePrice = rootView.findViewById(R.id.edt_purchase_price);

        spnInvestmentFor = rootView.findViewById(R.id.spn_select);
        List<String> list = new ArrayList<>();
        list.add("Who is this investment for?*");
        list.add("Self");
        list.add("Wife");
        list.add("Family");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),R.layout.simple_item_selected, list);
        spnInvestmentFor.setAdapter(dataAdapter);

    }

    private void setupEvents() {
        btnAddMore.setOnClickListener(v -> {
            edtDate.setText("Date of purchase");
            edtPurchasePrice.setText("");
            edtNumberOfUnits.setText("");
            switchCompat.setChecked(false);
            spnInvestmentFor.setSelection(0);
            Toast.makeText(getActivity(), "Data Saved Sucesfully", Toast.LENGTH_SHORT).show();
        });

        edtDate.setOnClickListener(v -> {
            openDatePicker(edtDate);
        });
    }

    private void openDatePicker(EditText edtDate) {
        DTU.showDatePickerDialog(getActivity(), DTU.FLAG_OLD_AND_NEW, edtDate);
    }
}