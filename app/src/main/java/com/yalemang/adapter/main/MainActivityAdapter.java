package com.yalemang.adapter.main;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.yalemang.bean.CarBean;
import com.yalemang.bean.TitleBean;
import com.yalemang.carro.R;
import com.yalemang.until.GridSpacingItemDecoration;
import com.yalemang.until.SpacesItemDecoration;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class MainActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<CarBean> carBeanList;
    private List<TitleBean> titleBeansList;
    private static final int BANNER = 0;
    private static final int POPULAR_CATEGORLES = 1;
    private static final int NEW_AUCTIONS = 2;
    private static final int POPULAR_BIDS = 3;
    private static final int LATEST_NEW_CAR_LISTINGS = 4;
    ArrayList<View> viewArrayList;
    MainViewPagerAdapter mainViewPagerAdapter;


    public MainActivityAdapter(Context context, List<CarBean> carBeanList, List<TitleBean> titleBeansList) {
        this.context = context;
        this.carBeanList = carBeanList;
        this.titleBeansList = titleBeansList;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER;
        } else if (position == 1) {
            return POPULAR_CATEGORLES;
        } else if (position == 2) {
            return NEW_AUCTIONS;
        } else if (position == 3) {
            return POPULAR_BIDS;
        } else {
            return LATEST_NEW_CAR_LISTINGS;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
            TypeBannerViewHolder typeBannerViewHolder = new TypeBannerViewHolder(view);
            return typeBannerViewHolder;
        } else if (viewType == POPULAR_CATEGORLES) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_popular_categorles, null);
            TypePopularCategorlesViewHolder typePopularCategorlesViewHolder = new TypePopularCategorlesViewHolder(view);
            return typePopularCategorlesViewHolder;
        } else if (viewType == NEW_AUCTIONS) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_new_auctions, null);
            TypeNewAuctionsViewHolder typeNewAuctionsViewHolder = new TypeNewAuctionsViewHolder(view);
            return typeNewAuctionsViewHolder;
        } else if (viewType == POPULAR_BIDS) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_popular_bids, null);
            TypePopularBidsViewHolder typePopularBidsViewHolder = new TypePopularBidsViewHolder(view);
            return typePopularBidsViewHolder;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_latest_new_car_listings, null);
            TypeLatestNewCarListingsViewHolder typeLatestNewCarListingsViewHolder = new TypeLatestNewCarListingsViewHolder(view);
            return typeLatestNewCarListingsViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int postions = 0;
        if (position != 0) {
            postions = position - 1;
        }


        if (holder instanceof TypeBannerViewHolder) {

            TypeBannerViewHolder typeBannerViewHolder = (TypeBannerViewHolder) holder;

            //可以考虑一个布局重复添加
            viewArrayList = new ArrayList<>();
            //LayoutInflater.from(context).inflate(R.layout.item_banner,null);

            viewArrayList.add(LayoutInflater.from(context).inflate(R.layout.view_pager_one, null));
            viewArrayList.add(LayoutInflater.from(context).inflate(R.layout.view_pager_one, null));
            viewArrayList.add(LayoutInflater.from(context).inflate(R.layout.view_pager_two, null));
            viewArrayList.add(LayoutInflater.from(context).inflate(R.layout.view_pager_three, null));
            viewArrayList.add(LayoutInflater.from(context).inflate(R.layout.view_pager_four, null));
            viewArrayList.add(LayoutInflater.from(context).inflate(R.layout.view_pager_five, null));

//                LayoutInflater layoutInflater = getLayoutInflater();
//                viewArrayList.add(getLayoutInflater().inflate(R.layout.view_pager_one, null, false));
//                viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_one, null, false));
//                viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_one, null, false));
//                viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_two, null, false));
//                viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_three, null, false));
//                viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_four, null, false));
//                viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_five, null, false));
            /**
             * 为什么不能直接.setImageResource，要创建一个实例？
             */
            ImageView imageView = viewArrayList.get(0).findViewById(R.id.one_iv);
            imageView.setImageResource(R.mipmap.c);

            ImageView imageView1 = viewArrayList.get(1).findViewById(R.id.one_iv);
            imageView1.setImageResource(R.mipmap.suv4);

            mainViewPagerAdapter = new MainViewPagerAdapter(context, viewArrayList);
            typeBannerViewHolder.viewPager.setAdapter(mainViewPagerAdapter);


        } else if (holder instanceof TypePopularCategorlesViewHolder) {
            TypePopularCategorlesViewHolder typePopularCategorlesViewHolder = (TypePopularCategorlesViewHolder) holder;
            typePopularCategorlesViewHolder.tvTitlePopularCategorles.setText(titleBeansList.get(postions).getTitle());

            //第一个效果展示
            LinearLayoutManager popularCategorlesLinearLayoutManager = new LinearLayoutManager(context);
            popularCategorlesLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            typePopularCategorlesViewHolder.popularCategorlesRecyclerView.setLayoutManager(popularCategorlesLinearLayoutManager);
            typePopularCategorlesViewHolder.popularCategorlesRecyclerView.setAdapter(new PopularCategorlesAdapter(context, carBeanList, new PopularCategorlesAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, View view) {
                    view.setBackgroundColor(Color.RED);
                }
            }));

            int space = 15;
            typePopularCategorlesViewHolder.popularCategorlesRecyclerView.addItemDecoration(new SpacesItemDecoration(space));


        } else if (holder instanceof TypeNewAuctionsViewHolder) {
            TypeNewAuctionsViewHolder typeNewAuctionsViewHolder = (TypeNewAuctionsViewHolder) holder;
            typeNewAuctionsViewHolder.tvTitleNewAuctions.setText(titleBeansList.get(postions).getTitle());

            //第二个效果展示
            LinearLayoutManager newAuctionsViewLinearLayoutManager = new LinearLayoutManager(context);
            newAuctionsViewLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            typeNewAuctionsViewHolder.newAuctionsRecyclerView.setLayoutManager(newAuctionsViewLinearLayoutManager);
            typeNewAuctionsViewHolder.newAuctionsRecyclerView.setAdapter(new NewAuctionsAdapter(context, carBeanList, new NewAuctionsAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, View view) {
                    view.setBackgroundColor(Color.RED);
                }
            }));

            int space = 15;
            typeNewAuctionsViewHolder.newAuctionsRecyclerView.addItemDecoration(new SpacesItemDecoration(space));
        } else if (holder instanceof TypePopularBidsViewHolder) {
            TypePopularBidsViewHolder typePopularBidsViewHolder = (TypePopularBidsViewHolder) holder;
            typePopularBidsViewHolder.tvTitlePopularBids.setText(titleBeansList.get(postions).getTitle());

            //第三个效果展示
            GridLayoutManager popularBidsViewgridLayoutManager = new GridLayoutManager(context, 2);
            typePopularBidsViewHolder.popularBidsRecyclerView.setLayoutManager(popularBidsViewgridLayoutManager);

            typePopularBidsViewHolder.popularBidsRecyclerView.setAdapter(new PopularBidsAdapter(context, carBeanList, new PopularBidsAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, View view) {
                    view.setBackgroundColor(Color.RED);
                }
            }));

            // 3 columns
            int spanCount = 3;
            // 50px
            int spacing = 50;
            boolean includeEdge = false;
            typePopularBidsViewHolder.popularBidsRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        } else if (holder instanceof TypeLatestNewCarListingsViewHolder) {
            TypeLatestNewCarListingsViewHolder typeLatestNewCarListingsViewHolder = (TypeLatestNewCarListingsViewHolder) holder;
            typeLatestNewCarListingsViewHolder.tvTitleLatestNewCarListings.setText(titleBeansList.get(postions).getTitle());


            //第四个效果展示
            LinearLayoutManager latestNewCarListingsLinearLayoutManager = new LinearLayoutManager(context);
            latestNewCarListingsLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            typeLatestNewCarListingsViewHolder.latestNewCarListingsRecyclerView.setLayoutManager(latestNewCarListingsLinearLayoutManager);
            typeLatestNewCarListingsViewHolder.latestNewCarListingsRecyclerView.setAdapter(new LatestNewCarListingsAdapter(context, carBeanList, new LatestNewCarListingsAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, View view) {
                    view.setBackgroundColor(Color.RED);
                }
            }));

            int space = 15;
            typeLatestNewCarListingsViewHolder.latestNewCarListingsRecyclerView.addItemDecoration(new SpacesItemDecoration(space));
        }

    }


    @Override
    public int getItemCount() {
        return titleBeansList.size() + 1;
    }


    public class TypeBannerViewHolder extends RecyclerView.ViewHolder {

        ViewPager viewPager;

        public TypeBannerViewHolder(View itemView) {
            super(itemView);
            viewPager = itemView.findViewById(R.id.view_pager_main);

        }
    }

    public class TypePopularCategorlesViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitlePopularCategorles;
        RecyclerView popularCategorlesRecyclerView;
        TextView seeMore;

        public TypePopularCategorlesViewHolder(View itemView) {
            super(itemView);
            tvTitlePopularCategorles = itemView.findViewById(R.id.tv_title_popular_categprles);
            popularCategorlesRecyclerView = itemView.findViewById(R.id.popular_categprles_recyclerview);
            seeMore = itemView.findViewById(R.id.tv_see_more_popular_categprles);
        }
    }

    public class TypeNewAuctionsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitleNewAuctions;
        RecyclerView newAuctionsRecyclerView;

        public TypeNewAuctionsViewHolder(View itemView) {
            super(itemView);
            tvTitleNewAuctions = itemView.findViewById(R.id.tv_title_new_auctions);
            newAuctionsRecyclerView = itemView.findViewById(R.id.new_auctions_recyclerview);
        }
    }

    public class TypePopularBidsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitlePopularBids;
        RecyclerView popularBidsRecyclerView;

        public TypePopularBidsViewHolder(View itemView) {
            super(itemView);
            tvTitlePopularBids = itemView.findViewById(R.id.tv_title_popular_bids);
            popularBidsRecyclerView = itemView.findViewById(R.id.popular_bids_recyclerview);
        }
    }

    public class TypeLatestNewCarListingsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitleLatestNewCarListings;
        RecyclerView latestNewCarListingsRecyclerView;

        public TypeLatestNewCarListingsViewHolder(View itemView) {
            super(itemView);
            tvTitleLatestNewCarListings = itemView.findViewById(R.id.tv_title_latest_new_car_listings);
            latestNewCarListingsRecyclerView = itemView.findViewById(R.id.latest_new_car_listings_recyclerview);
        }
    }

}
