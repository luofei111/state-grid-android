package com.nx.stategrid.weiget.recycleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.math.BigDecimal;

/**
 * Created by luofei on 2016/9/19 0019.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    View convertView;
    Context context;

    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        this.convertView = itemView;
        this.context = context;
    }

    public void setText(int id, String text) {
        TextView textView = convertView.findViewById(id);
        if (text != null) {
            textView.setText(text);
        } else {
            textView.setText("暂无");
        }
    }

    /**
     * 如果flag 为true的话表示大数字 为false的话表示小数字
     *
     * @param id
     * @param content
     * @param flag
     */
    public void setTextView(int id, BigDecimal content, boolean flag) {
        TextView textView = convertView.findViewById(id);
        if (content != null) {
            textView.setText(content.toPlainString());
        } else {
            if (flag) {
                textView.setText("暂无数据");
            } else {
                textView.setText("--");
            }
        }
    }

    public void setTextfromHtml(int id, String text) {
        TextView textView = convertView.findViewById(id);
        textView.setText(Html.fromHtml(text));
    }

    public void setTextColor(int id, int color) {
        TextView textView = convertView.findViewById(id);
        textView.setTextColor(context.getResources().getColor(color));
    }

    public void setTextParseColor(int id, int color) {
        TextView textView = convertView.findViewById(id);
        textView.setTextColor(color);
    }

    public void setTextBackground(int id, int drawId) {
        TextView textView = convertView.findViewById(id);
        textView.setBackgroundResource(drawId);
    }

    public void setTextBackgroundColor(int id, int color) {
        TextView textView = convertView.findViewById(id);
        textView.setBackgroundColor(color);
    }

    public void setViewBackgroundColor(int id, int colorId) {
        View view = convertView.findViewById(id);
        view.setBackgroundColor(colorId);
    }

    public void setViewBackgroundDrawable(int id, int drawableId) {
        View view = convertView.findViewById(id);
        view.setBackgroundResource(drawableId);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int id, Drawable l, Drawable t, Drawable r, Drawable b) {
        TextView textView = convertView.findViewById(id);
        textView.setCompoundDrawablesWithIntrinsicBounds(l, t, r, b);
    }

    public void setImage(int id, String url, int defaultImg) {
        ImageView imageView = convertView.findViewById(id);
        if (url != null && !url.equals("")) {
            Glide.with(context)
                    .load(url)
                    //.placeholder(defaultImg)
                    //.error(defaultImg)
                    .into(imageView);
        } else {
            if (defaultImg != -1) {
                imageView.setBackgroundResource(defaultImg);
            }
        }
    }

    public void setImage(ImageView imageView, String url, int defaultImg) {
        if (url != null && !url.equals("")) {
            Glide.with(context)
                    .load(url)
                    //.placeholder(defaultImg)
                    //.error(defaultImg)
                    .into(imageView);
        } else {
            if (defaultImg != -1) {
                imageView.setBackgroundResource(defaultImg);
            }
        }
    }


    public void setFileImage(int id, String path, int defaultImg) {
        ImageView imageView = convertView.findViewById(id);
        if (path != null && !path.equals("")) {
            imageView.setImageBitmap(BitmapFactory.decodeFile(path));
        } else {
            imageView.setBackgroundResource(defaultImg);
        }
    }

    public void setCircleImage(int id, String url, int defaulImage) {
        ImageView imageView = (ImageView) convertView.findViewById(id);
        //GlideLoader.loadCircleImage(url, imageView, defaulImage);
    }

    public void setCircleImage2(int id, String url) {
        ImageView imageView = (ImageView) convertView.findViewById(id);
    }

    public void setImageResouse(int id, int drawableId) {
        ImageView imageView = convertView.findViewById(id);
        imageView.setImageResource(drawableId);
    }

    public void setImageDrawable(int id, Drawable drawable) {
        ImageView imageView = convertView.findViewById(id);
        imageView.setImageDrawable(drawable);
    }

    public void setImageBitmap(int id, Bitmap bitmap, int defaulImage) {
        ImageView imageView = convertView.findViewById(id);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(defaulImage);
        }
    }

    public void setViewVisiable(int id, int isVisiable) {
        View view = convertView.findViewById(id);
        view.setVisibility(isVisiable);
    }

    public void setCheckBox(int id, boolean check) {
        CheckBox checkBox = (CheckBox) convertView.findViewById(id);
        if (check) {
            checkBox.setChecked(check);
        } else {
            checkBox.setChecked(false);
        }
    }

    public void setOnClickListener(int id, View.OnClickListener onClickListener) {
        View view = convertView.findViewById(id);
        view.setOnClickListener(onClickListener);
    }

    public String getText(int id) {
        TextView textView = (TextView) convertView.findViewById(id);
        return textView.getText().toString();
    }

    public String getEditText(int id) {
        EditText editText = (EditText) convertView.findViewById(id);
        return editText.getText().toString();
    }

    public void setTag(int id, Object o) {
        View view = convertView.findViewById(id);
        view.setTag(o);
    }

    public void setViewEnable(int id, boolean enable) {
        View view = convertView.findViewById(id);
        view.setEnabled(enable);
    }

    public void setRatingBar(int id, Integer num) {
        if (num != null) {
            RatingBar ratingBar = convertView.findViewById(id);
            ratingBar.setNumStars(num);
            ratingBar.setRating(num);
        }
    }

    public void setProgress(int id, int progress) {
        ProgressBar progressBar = convertView.findViewById(id);
        progressBar.setProgress(progress);
    }

    public int getViewWidth(int id) {
        View view = convertView.findViewById(id);
        return view.getWidth();
    }

    public int getViewHeight(int id) {
        View view = convertView.findViewById(id);
        return view.getHeight();
    }

}
