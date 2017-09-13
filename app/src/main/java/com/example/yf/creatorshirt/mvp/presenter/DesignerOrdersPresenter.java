package com.example.yf.creatorshirt.mvp.presenter;

import android.util.Log;

import com.example.yf.creatorshirt.http.DataManager;
import com.example.yf.creatorshirt.http.HttpResponse;
import com.example.yf.creatorshirt.mvp.model.BombStyleBean;
import com.example.yf.creatorshirt.mvp.model.orders.OrderStyleBean;
import com.example.yf.creatorshirt.mvp.presenter.base.RxPresenter;
import com.example.yf.creatorshirt.mvp.presenter.contract.DesignerOrdersContract;
import com.example.yf.creatorshirt.utils.GsonUtils;
import com.example.yf.creatorshirt.utils.RxUtils;
import com.example.yf.creatorshirt.widget.CommonSubscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by yangfang on 2017/9/12.
 */

public class DesignerOrdersPresenter extends RxPresenter<DesignerOrdersContract.DesignerDesignView> implements
        DesignerOrdersContract.Presenter {
    private DataManager mDataManager;
    private int userID;
    private int pageIndex = 0;

    @Inject
    public DesignerOrdersPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;

    }

    @Override
    public void getTotalDesigner() {
        pageIndex = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("desginUserId", userID);
        map.put("pageIndex", pageIndex);
        addSubscribe(mDataManager.getDesignOrders(GsonUtils.getGson(map))
                .compose(RxUtils.<HttpResponse<List<BombStyleBean>>>rxSchedulerHelper())
                .compose(RxUtils.<List<BombStyleBean>>handleResult())
                .subscribeWith(new CommonSubscriber<List<BombStyleBean>>(mView, "请求失败，请检查网络", false) {
                    @Override
                    public void onNext(List<BombStyleBean> orderStyleBeen) {
                        mView.showSuccessData(orderStyleBeen);
                    }
                })

        );
    }

    public void setUserId(int userId) {
        this.userID = userId;
    }

    public void getMoreDesignOrders() {
        Map<String, Integer> map = new HashMap<>();
        map.put("desginUserId", userID);
        map.put("pageIndex", ++pageIndex);
        addSubscribe(mDataManager.getDesignOrders(GsonUtils.getGson(map))
                .compose(RxUtils.<HttpResponse<List<BombStyleBean>>>rxSchedulerHelper())
                .compose(RxUtils.<List<BombStyleBean>>handleResult())
                .subscribeWith(new CommonSubscriber<List<BombStyleBean>>(mView, "请求失败，请检查网络", false) {
                    @Override
                    public void onNext(List<BombStyleBean> orderStyleBeen) {
                        mView.showMoreData(orderStyleBeen);
                    }
                })
        );
    }
}