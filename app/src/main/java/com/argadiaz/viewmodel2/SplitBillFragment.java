package com.argadiaz.viewmodel2;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.argadiaz.viewmodel2.databinding.SplitBillFragmentBinding;

public class SplitBillFragment extends Fragment {

    private SplitBillViewModel mViewModel;
    SplitBillFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.split_bill_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(SplitBillViewModel.class);
        binding.setViewModel(mViewModel);
        binding.setLifecycleOwner(this);
        binding.btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountStr = binding.editAmount.getText().toString();
                String peopleStr = binding.editPeople.getText().toString();
                Float amount;
                int people;
                if(amountStr.isEmpty() && peopleStr.isEmpty()){
                    amount=0.0f;
                    people=0;
                }else{
                    amount=Float.valueOf(amountStr);
                    people = Integer.valueOf(peopleStr);
                }
                mViewModel.setAmount(amount);
                mViewModel.setPeople(people);
            }
        });
        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.reset();
                binding.editAmount.setText("");
                binding.editPeople.setText("");
            }
        });
        return binding.getRoot();
    }

}