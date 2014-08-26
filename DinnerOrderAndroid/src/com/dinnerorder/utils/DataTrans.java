package com.dinnerorder.utils;

import java.util.List;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

class DataTrans implements Parcelable {
	List<Map<String, String>> temp;
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}

	public static final Parcelable.Creator<DataTrans> CREATOR = new Parcelable.Creator<DataTrans>() {

		@Override
		public DataTrans createFromParcel(Parcel source) {
			return null;
		}

		@Override
		public DataTrans[] newArray(int size) {
			return null;
		}

	};

}
