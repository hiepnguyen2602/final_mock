package gst.trainingcourse.final_mock.fragment;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gst.trainingcourse.final_mock.models.AppInfo;
import gst.trainingcourse.final_mock.BuildConfig;
import gst.trainingcourse.final_mock.R;
import gst.trainingcourse.final_mock.adapter.AppInfoAdapter;
import gst.trainingcourse.final_mock.utils.OnItemClick;


public class AppFragment extends BaseFragment implements OnItemClick {
    private List<AppInfo> mAppInfos;
    private AppInfoAdapter adapter;
    private List<Uri> file;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_fragment, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvAppInfo = view.findViewById(R.id.rvappinfo);
        initData();
        adapter = new AppInfoAdapter();
        adapter.setData(mAppInfos);
        rvAppInfo.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter.setOnItemClick(this);
        rvAppInfo.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private void initData() {
        mAppInfos = new ArrayList<>();
        List<ApplicationInfo> applicationInfos = getContext().getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo mInfo : applicationInfos) {
            if (getContext().getPackageManager().getLaunchIntentForPackage(mInfo.packageName) != null) {
                mAppInfos.add(new AppInfo(mInfo.publicSourceDir, mInfo.loadLabel(getContext().getPackageManager()).toString(), mInfo.packageName, mInfo.loadIcon(getContext().getPackageManager())));
            }
        }
    }




    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(), "fjafa" + mAppInfos.get(position).getFilePathApk().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onITemOnLongClick(int position) {

    }


}
