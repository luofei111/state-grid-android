package com.nx.stategrid.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.nx.stategrid.R;
import com.nx.stategrid.adapter.holder.QuestionHeaderHolder;
import com.nx.stategrid.adapter.holder.QuestionInputHolder;
import com.nx.stategrid.adapter.holder.QuestionMathSelectHolder;
import com.nx.stategrid.adapter.holder.QuestionNormalSelectHolder;
import com.nx.stategrid.adapter.holder.QuestionSectionHolder;
import com.nx.stategrid.adapter.holder.QuestionSubTitleHolder;
import com.nx.stategrid.adapter.holder.QuestionTextHolder;
import com.nx.stategrid.dto.QuestionInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: luofei
 * @Date: 2020/7/3 13:46
 * @Description:
 */
public class QuestionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_HEADER = 1;

    private final int VIEW_TYPE_SUBTITLE = 2;

    private final int VIEW_TYPE_SECTION = 3;

    private final int VIEW_TYPE_TEXT = 4;

    private final int VIEW_TYPE_MATHSELECT = 5;

    private final int VIEW_TYPE_NORMALSELECT = 6;

    private final int VIEW_TYPE_INPUT = 7;

    private Context mContext;

    private List<QuestionInfo.DataBean.ContentBean.BodyBean> date;

    private Map<Integer, String> editMap = new HashMap<>();

    private OprateCallBack oprateCallBack;

    public void setOprateCallBack(OprateCallBack oprateCallBack) {
        this.oprateCallBack = oprateCallBack;
    }

    public QuestionListAdapter(Context mContext, List<QuestionInfo.DataBean.ContentBean.BodyBean> date) {
        this.mContext = mContext;
        this.date = date;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        QuestionInfo.DataBean.ContentBean.BodyBean bean = date.get(position);
        if (holder instanceof QuestionHeaderHolder) {
            QuestionHeaderHolder headerHolder = (QuestionHeaderHolder) holder;
            headerHolder.setText(R.id.header_tv, bean.getName());
        }

        if (holder instanceof QuestionSubTitleHolder) {
            QuestionSubTitleHolder subTitleHolder = (QuestionSubTitleHolder) holder;
            subTitleHolder.setText(R.id.subtitle_tv, bean.getName());
        }

        if (holder instanceof QuestionTextHolder) {
            QuestionTextHolder textHolder = (QuestionTextHolder) holder;
            textHolder.setText(R.id.text_tv, bean.getName());
        }

        if (holder instanceof QuestionMathSelectHolder) {
            QuestionMathSelectHolder mathSelectHolder = (QuestionMathSelectHolder) holder;
            mathSelectHolder.setText(R.id.math_select_title_tv, bean.getName());
            mathSelectHolder.setText(R.id.math_select_tv, bean.getValue());

            mathSelectHolder.setOnClickListener(R.id.math_select_tv, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    oprateCallBack.mathSelectCallBack(position);
                }
            });
        }

        if (holder instanceof QuestionNormalSelectHolder) {
            QuestionNormalSelectHolder normalSelectHolder = (QuestionNormalSelectHolder) holder;
            normalSelectHolder.setText(R.id.math_select_title_tv, bean.getName());
            normalSelectHolder.setText(R.id.math_select_tv, bean.getValue());

            normalSelectHolder.setOnClickListener(R.id.math_select_tv, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    oprateCallBack.nomalSelectCallBack(position);
                }
            });
        }

        if (holder instanceof QuestionSectionHolder) {
            QuestionSectionHolder sectionHolder = (QuestionSectionHolder) holder;
            sectionHolder.setText(R.id.section_tv, bean.getName());
        }

        if (holder instanceof QuestionInputHolder) {
            QuestionInputHolder inputHolder = (QuestionInputHolder) holder;
            inputHolder.setText(R.id.input_tv, bean.getName());

            EditText editText = inputHolder.itemView.findViewById(R.id.input_edit);
            editText.setText(editMap.get(position));

            editText.setTag(position);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    int tagPosition = (int) editText.getTag();
                    if (tagPosition == position && editText.hasFocus()) {
                        editMap.put(position, s.toString());
                    }
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_TYPE_HEADER) {

            view = getView(R.layout.question_header_item_layout, parent);
            return new QuestionHeaderHolder(view, mContext);
        } else if (viewType == VIEW_TYPE_SUBTITLE) {

            view = getView(R.layout.question_subtitle_item_layout, parent);
            return new QuestionSubTitleHolder(view, mContext);
        } else if (viewType == VIEW_TYPE_SECTION) {

            view = getView(R.layout.question_section_item_layout, parent);
            return new QuestionSectionHolder(view, mContext);
        } else if (viewType == VIEW_TYPE_TEXT) {

            view = getView(R.layout.question_text_item_layout, parent);
            return new QuestionTextHolder(view, mContext);
        } else if (viewType == VIEW_TYPE_MATHSELECT) {

            view = getView(R.layout.question_mathselect_item_layout, parent);
            return new QuestionMathSelectHolder(view, mContext);
        } else if (viewType == VIEW_TYPE_NORMALSELECT) {

            view = getView(R.layout.question_mathselect_item_layout, parent);
            return new QuestionNormalSelectHolder(view, mContext);
        } else if (viewType == VIEW_TYPE_INPUT) {

            view = getView(R.layout.question_input_item_layout, parent);
            return new QuestionInputHolder(view, mContext);
        } else {
            view = getView(R.layout.question_section_item_layout, parent);
            return new QuestionSectionHolder(view, mContext);
        }

    }

    @Override
    public int getItemViewType(int position) {

        String type = date.get(position).getContentType();
        switch (type) {
            case "header":
                return VIEW_TYPE_HEADER;
            case "subtitle":
                return VIEW_TYPE_SUBTITLE;
            case "text":
                return VIEW_TYPE_TEXT;
            case "mathsSelect":
                return VIEW_TYPE_MATHSELECT;
            case "normalSelect":
                return VIEW_TYPE_NORMALSELECT;
            case "section":
                return VIEW_TYPE_SECTION;
            case "Input":
            case "input":
                return VIEW_TYPE_INPUT;

        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    /**
     * 用来引入布局的方法
     */
    private View getView(int view, ViewGroup parent) {
        View view1 = LayoutInflater.from(mContext).inflate(view, parent, false);
        return view1;
    }

    public interface OprateCallBack {

        void mathSelectCallBack(int position);

        void nomalSelectCallBack(int position);
    }
}
