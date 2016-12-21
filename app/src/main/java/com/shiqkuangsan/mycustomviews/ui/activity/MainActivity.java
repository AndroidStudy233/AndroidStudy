package com.shiqkuangsan.mycustomviews.ui.activity;

import android.content.Intent;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.shiqkuangsan.baiducityselector.CitySelectorActivity;
import com.shiqkuangsan.mycustomviews.R;
import com.shiqkuangsan.mycustomviews.base.BaseActivity;
import com.shiqkuangsan.mycustomviews.utils.MyLogUtil;

import static android.R.id.list;
import static com.baidu.location.h.j.v;

/**
 * 主界面.
 */
public class MainActivity extends BaseActivity {

    private AMapLocationClient mLocationClient;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initDataAndListener() {
        initLocation();
    }


    private void initLocation() {
        /*
            注意这只是个测试,没有做6.0系统的兼容.6.0以下是没问题的
         */
        mLocationClient = new AMapLocationClient(this);
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        option.setOnceLocation(true);
        option.setNeedAddress(true);
        option.setInterval(20000);
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        String city = aMapLocation.getCity();
                        String district = aMapLocation.getDistrict();
                        MyLogUtil.d("city: " + city);
                        MyLogUtil.d("district: " + district);
                    } else {
                        //定位失败
                        MyLogUtil.e("高德Error, ErrCode:" + aMapLocation.getErrorCode()
                                + ", errInfo:" + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        mLocationClient.setLocationOption(option);

        mLocationClient.startLocation();
    }

    @Override
    public void processClick(View v) {
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。
    }

    /**
     * 轮播图
     *
     * @param view
     */
    public void switchpicture(View view) {
        startActivity(new Intent(this, SwitchPictureActivity.class));
    }

    /**
     * 自定义小开关
     *
     * @param view
     */
    public void myonoff(View view) {
        startActivity(new Intent(this, MyOnOffActivity.class));
    }

    /**
     * 下拉刷新
     *
     * @param view
     */
    public void droprefresh(View view) {
        startActivity(new Intent(this, PullRefreshActivity.class));
    }

    /**
     * 侧滑菜单
     *
     * @param view
     */
    public void slidemenu(View view) {
        startActivity(new Intent(this, SlideMenuActivity.class));
    }

    /**
     * 下拉刷新测试
     *
     * @param view
     */
    public void ptrtest(View view) {
        startActivity(new Intent(this, PtrDemoActivity.class));
    }

    /**
     * 图片选择
     *
     * @param view
     */
    public void picchoser(View view) {
        startActivity(new Intent(this, PicChooserActivity.class));
    }

    /**
     * 图片查看
     *
     * @param view
     */
    public void piclooker(View view) {
        startActivity(new Intent(this, PicLookerActivity.class));
    }

    /**
     * xUtils测试
     *
     * @param view
     */
    public void xutils(View view) {
        startActivity(new Intent(this, XUtilsActivity.class));
    }

    /**
     * CoodinatorLayout
     *
     * @param view
     */
    public void coordinator(View view) {
        startActivity(new Intent(this, CoordinatorActivity.class));
    }

    /**
     * RecyclerView和AutoRatioLayout和CardView
     *
     * @param view
     */
    public void recycler(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    /**
     * 调试沉浸式的页面
     *
     * @param view
     */
    public void immerse(View view) {
        startActivity(new Intent(this, ImmerseActivity.class));
    }

    /**
     * 城市列表页面
     *
     * @param view
     */
    public void citypicker(View view) {
        startActivity(new Intent(this, CitySelectorActivity.class));
    }

    /**
     * 滑动返回上个界面演示
     *
     * @param view
     */
    public void swipeback(View view) {
        startActivity(new Intent(this, TestSwipeBackActivity.class));
    }

    /**
     * MD风格设置界面
     *
     * @param view
     */
    public void mdsettings(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }

}
