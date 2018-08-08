package by.st.currency.error;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import by.st.currency.R;

public class ErrorFragment extends Fragment implements Button.OnClickListener {

    private OnErrorFragmentListener mListener;

    private Button btError;

    public static ErrorFragment newInstance(String error) {
        ErrorFragment frag = new ErrorFragment();
        Bundle args = new Bundle();
        args.putString("error", error);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnErrorFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(false);
        View v = inflater.inflate(R.layout.fragment_error, container, false);

        btError = v.findViewById(R.id.btError);
        TextView tvError = v.findViewById(R.id.tvError);
        Bundle args = getArguments();
        if (args != null)
            tvError.setText(args.getString("error"));

        btError.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v == btError)
            mListener.onRepeatButtonClicked();
    }

    public interface OnErrorFragmentListener {
        void onRepeatButtonClicked();
    }
}
