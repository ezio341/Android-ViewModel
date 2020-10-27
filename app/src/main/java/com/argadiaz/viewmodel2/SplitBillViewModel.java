package com.argadiaz.viewmodel2;

import com.argadiaz.viewmodel2.models.SplitBillModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SplitBillViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<SplitBillModel> liveModel = new MutableLiveData<>();
    public SplitBillModel model = new SplitBillModel();

    public LiveData<SplitBillModel> getLiveModel() {
        return liveModel;
    }
    public void setAmount(float amount){
        model.setAmount(amount);
        liveModel.setValue(model);
    }
    public void setPeople(int people){
        model.setPeople(people);
        liveModel.setValue(model);
    }
    public void reset(){
        model.setAmount(0);
        model.setPeople(0);
        liveModel.setValue(model);
    }
}