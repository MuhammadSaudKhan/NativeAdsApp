package com.saud.adsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.saud.adsapp.Model.AdsModel;
import com.saud.adsapp.R;

import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.viewHolder> {
     List<AdsModel> list;
     Context context;
    public AdsAdapter(Context context,List<AdsModel> list) {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_template,null,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {
        AdLoader adLoader = new AdLoader.Builder(context, "ca-app-pub-3940256099942544/2247696110")
                .forUnifiedNativeAd(new UnifiedNativeAd
                        .OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().build();
                        holder.templateView.setStyles(styles);
                        holder.templateView.setNativeAd(unifiedNativeAd);
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TemplateView templateView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            templateView=itemView.findViewById(R.id.my_template);
        }
    }
}
